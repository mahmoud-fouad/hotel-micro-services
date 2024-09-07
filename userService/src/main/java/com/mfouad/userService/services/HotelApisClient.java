package com.mfouad.userService.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mfouad.userService.dtos.HotelDetailsRes;

@FeignClient(name="HOTELS-SERVICE")
public interface HotelApisClient {
	
	@GetMapping("api/v1/hotels/{hotel-id}")
	HotelDetailsRes getHotel(@PathVariable ("hotel-id")String hotelId);

}
