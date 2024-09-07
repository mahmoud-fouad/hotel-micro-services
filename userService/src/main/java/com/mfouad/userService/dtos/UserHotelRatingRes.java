package com.mfouad.userService.dtos;

public record UserHotelRatingRes(String hotelName,
		  String hotelAbout,
		  String hotelLocation,
		  int userRating, String userFeedback) {

}
