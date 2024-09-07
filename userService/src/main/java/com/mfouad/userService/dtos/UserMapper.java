package com.mfouad.userService.dtos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mfouad.userService.entities.User;

@Component
public class UserMapper {
	
	public UserResponse toUserRepsone(User user) {
		return new UserResponse(user.getName(), user.getEmail(), user.getAbout(), null);
	}
	
	public UserResponse toUserRepsone(User user,List<UserHotelRatingRes> rating) {
		return new UserResponse(user.getName(), user.getEmail(), user.getAbout(), rating);
	}

}
