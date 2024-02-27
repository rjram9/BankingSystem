package com.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.User;
import com.banking.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	@Autowired
    private com.banking.config.JwtTokenUtil jwtTokenUtil;
	
	public User getUserById(int id) {
		return userRepo.findById(id).get();
	}
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public User updateUser(User user) {
		User temp = userRepo.findById(user.getId()).get();
		temp.setName(user.getName());
		temp.setEmail(user.getEmail());
		temp.setContactNo(user.getContactNo());
		temp.setPin(user.getPin());
		return userRepo.save(temp);
	}
	
	public User getUserFromToken(String token) {
        String contactNo = jwtTokenUtil.getUsernameFromToken(token);
        return userRepo.findByContactNo(contactNo);
    }
	
}
