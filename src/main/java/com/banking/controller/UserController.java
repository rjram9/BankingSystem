package com.banking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entity.User;
import com.banking.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class UserController { 
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	public User getUser(@RequestParam int id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return createdUser;
	}
}
