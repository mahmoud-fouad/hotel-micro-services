package com.mfouad.userService.services;

import java.util.List;

import com.mfouad.userService.dtos.UserResponse;
import com.mfouad.userService.entities.User;

public interface UsersServices {
	
	List<User> getUsers();
	
	public User saveUser(User user);
	
	public UserResponse getUser(String userId);

}
