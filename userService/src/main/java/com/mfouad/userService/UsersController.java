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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UsersController {
	
	private final UsersServices service;
	
	
	@GetMapping()
	public List<User> getUsers() {
		return service.getUsers();
	}
	
	@GetMapping("/{user-id}")
	@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "getUserDetailsOnly")
	public UserResponse getUsers(@PathVariable("user-id") String id) {
		
		return service.getUser(id);
	}
	
	public UserResponse getUserDetailsOnly(String id,Exception ex) {
		log.info("==== fallback because get userid is down");
		ex.printStackTrace();
		return service.getUserDetails(id);
	}
	
	@PostMapping()
	public User  createUser(@RequestBody User entity) {
		
		return service.saveUser(entity);
	}
	

}
