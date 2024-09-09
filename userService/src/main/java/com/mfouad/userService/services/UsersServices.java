package com.mfouad.userService.services;

import java.util.List;

import com.mfouad.userService.dtos.UserRatingRes;
import com.mfouad.userService.dtos.UserResponse;
import com.mfouad.userService.entities.User;

public interface UsersServices {
	
	List<User> getUsers();
	
	public User saveUser(User user);
	
	public UserResponse getUser(String userId);

	UserResponse getUserDetails(String id);
	
	List<UserRatingRes> getUserHotels(String userId);

}
