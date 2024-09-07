package com.mfouad.userService.dtos;

import java.util.List;

public record UserResponse( String name,  String email,  String about
		,List<UserHotelRatingRes> ratings 
		) {

}
