package com.mfouad.userService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mfouad.userService.entities.User;

public interface UserRepo extends JpaRepository<User, String> {

}
