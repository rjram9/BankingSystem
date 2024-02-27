package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entity.Account;
import com.banking.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController { 
	@Autowired
	AccountService service;
	
	@PostMapping("/account")
	public Account createAccount(@RequestBody Account account) {
		return service.createAccount(account);
				
	}
	
	@GetMapping("/account/{id}")
	public Account getAccount(@PathVariable int id) {
		return service.getAccount(id);
	}
	
	@PutMapping("/updateAccount")
	public Account updateAccount(@RequestBody Account account) {
		return service.updateAccount(account);
	}
	
	@GetMapping("/accountBalance/{id}")
	public double getBalance(@PathVariable int id) {
		return service.getBalance(id);
	}
}
