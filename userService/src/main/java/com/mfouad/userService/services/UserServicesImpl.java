package com.mfouad.userService.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mfouad.userService.dtos.HotelDetailsRes;
import com.mfouad.userService.dtos.UserHotelRatingRes;
import com.mfouad.userService.dtos.UserMapper;
import com.mfouad.userService.dtos.UserRatingRes;
import com.mfouad.userService.dtos.UserResponse;
import com.mfouad.userService.entities.User;
import com.mfouad.userService.exceptions.UserNotFoundException;
import com.mfouad.userService.repositories.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UsersServices{

	public final UserRepo repo;
	private final UserMapper mapper;
	
	private final RestTemplate restTemplate;
	
	private final HotelApisClient hotelClient;
	
	
	
	@Override
	public List<User> getUsers() {
		return repo.findAll();
	}

	@Override
	public User saveUser(User user) {
	user.setUserId(UUID.randomUUID().toString());
		return repo.save(user);
	}

	@Override
	public UserResponse getUser(String userId) {
		User user= repo.findById(userId)
				.orElseThrow(() -> new  UserNotFoundException());
		
		List<UserRatingRes> rating= restTemplate.exchange(String.format("http://RATING-SERVICES/api/v1/ratings/user/%s", user.getUserId()), HttpMethod.GET,null,new ParameterizedTypeReference<List<UserRatingRes>>() {} ).getBody();
		List<UserHotelRatingRes> userHotelRating= rating.stream().map( r-> {
//			HotelDetailsRes hotelDetails= restTemplate.exchange(String.format("http://HOTELS-SERVICE/api/v1/hotels/%s", r.hotelId()), HttpMethod.GET,null,new ParameterizedTypeReference<HotelDetailsRes>() {} ).getBody();
			HotelDetailsRes hotelDetails= hotelClient.getHotel(r.hotelId());
			
			return new UserHotelRatingRes(hotelDetails.name(),hotelDetails.about(),hotelDetails.location() , r.rating(),r.feedback()) ;} )
				.collect(Collectors.toList());
		
		return mapper.toUserRepsone(user,userHotelRating);
	}

	@Override
	public UserResponse getUserDetails(String id) {
		User user= repo.findById(id)
				.orElseThrow(() -> new  UserNotFoundException());
		return mapper.toUserRepsone(user);
	}
	
	

}
