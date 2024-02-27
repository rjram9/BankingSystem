package com.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.banking.entity.User;
import com.banking.repository.UserRepository;

import java.util.ArrayList;

@Service("userDetailService")
@ComponentScan(basePackages = "com.test.project.security.model")
public class JwtUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User user = userRepository.findByContactNo(username);
			if (user == null) {
				throw new UsernameNotFoundException("User not found with mobile no: " + username);
			}
			return new org.springframework.security.core.userdetails.User(user.getContactNo(), user.getPin(), new ArrayList<>());
		} catch (Exception e){
			throw new UsernameNotFoundException("User not found with mobile no: " + username);
		}
	}

}
