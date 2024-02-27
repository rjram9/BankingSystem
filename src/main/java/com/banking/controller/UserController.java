package com.banking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entity.User;
import com.banking.exceptions.NoSuchUserException;
import com.banking.service.UserService;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController { 
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) throws NoSuchUserException {
		try {
			return userService.getUserById(id);
		}
		catch(NoSuchElementException ex) {
			throw new NoSuchUserException("No such user present in the system");
		}
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return createdUser;
	}
	
	
}
