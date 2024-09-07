package com.mfouad.userService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfouad.userService.dtos.UserResponse;
import com.mfouad.userService.entities.User;
import com.mfouad.userService.services.UsersServices;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {
	
	private final UsersServices service;
	
	
	@GetMapping()
	public List<User> getUsers() {
		return service.getUsers();
	}
	
	@GetMapping("/{user-id}")
	public UserResponse getUsers(@PathVariable("user-id") String id) {
		
		return service.getUser(id);
	}
	
	@PostMapping()
	public User  createUser(@RequestBody User entity) {
		
		return service.saveUser(entity);
	}
	

}
