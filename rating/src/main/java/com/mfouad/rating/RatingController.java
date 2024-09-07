package com.mfouad.rating;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("api/v1/ratings")
@RequiredArgsConstructor
public class RatingController {
	
	private final RatingService service;
	
	@PostMapping()
	public Rating postRating(@RequestBody Rating rating) {
		
		return service.createRating(rating);
	}
	
	@GetMapping()
	public List<Rating> getAllRatings() {
		return service.getAllRatings();
	}
	
	@GetMapping("/{hotel-id}")
	public List<Rating> getAllHotelRatings(@PathVariable("hotel-id") String hotelID) {
		return service.getHotelRatings(hotelID);
	}
	
	
	@GetMapping("/{hotel-id}/{user-id}")
	public List<Rating> getHotelUserRatings(@PathVariable("hotel-id") String hotelID,@PathVariable("user-id") String userId) {
		return service.getUserRatingsForHotel(userId,hotelID);
	}
	
	@GetMapping("/user/{user-id}")
	public List<Rating> geAllUserRatings(@PathVariable("user-id") String userId) {
		return service.getUserRatings(userId);
	}
	
	

}
