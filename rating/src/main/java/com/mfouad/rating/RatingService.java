package com.mfouad.rating;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RatingService {
	
	private final RatingRepo repo;
	
	
	public Rating createRating(Rating rating) {
		
	return	repo.save(rating);
	}
	
	public List<Rating> getUserRatings(String userId){
		return repo.findByUserId(userId);
	}
	
	public List<Rating> getUserRatingsForHotel(String userId,String hotelID){
		return repo.findByUserIdAndHotelId(userId,hotelID);
	}
	
	
	public List<Rating> getHotelRatings(String hotelID){
		return repo.findByHotelId(hotelID);
	}
	
	public List<Rating> getAllRatings(){
		return repo.findAll();
	}
	

}
