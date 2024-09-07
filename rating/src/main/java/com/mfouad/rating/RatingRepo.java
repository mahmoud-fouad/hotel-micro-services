package com.mfouad.rating;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepo extends MongoRepository<Rating,String>{

	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
	
	List<Rating> findByUserIdAndHotelId(String userId,String hotelId);
	

}
