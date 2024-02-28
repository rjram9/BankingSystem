package com.banking.service;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.banking.config.JwtTokenUtil;
import com.banking.dto.Constants;
import com.banking.entity.User;
import com.banking.exceptions.BadRequestException;
import com.banking.repository.UserRepository;




@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LogManager.getLogger(getClass());

    public String createUser(User user) {
        if (userRepository.findByContactNo(user.getContactNo()) != null) {
            logger.info("user already exist with mobile number : {}", user.getContactNo());
            throw new BadRequestException(Constants.USER_EXIST);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPin(encoder.encode(user.getPin()));
        Date now = new Date();
        user.setAge(getAgeBetween(user.getDob(), now));
        user = userRepository.save(user);
        return accountService.createAccount(user);
    }

    private int getAgeBetween(Date dob, Date now) {
        DateTime dobjoda = new DateTime(dob);
        DateTime nowjoda = new DateTime(now);
        return Years.yearsBetween(dobjoda, nowjoda).getYears();
    }

    public User getUserFromToken(String token) {
        String contactNo = jwtTokenUtil.getUsernameFromToken(token);
        return userRepository.findByContactNo(contactNo);
    }

    public String updateUser(User user) {
        User existingUser = userRepository.findByContactNo(user.getContactNo());
        if (existingUser==null){
            logger.info("User not found with contact no : {}",user.getContactNo());
            throw new BadRequestException("User not found with contact no : "+user.getContactNo());
        }
        user.setId(existingUser.getId());
        user.setContactNo(existingUser.getContactNo());
        user.setPin(existingUser.getPin());
        user.setAge(getAgeBetween(user.getDob(),new Date()));
        userRepository.save(user);
        return Constants.USER_UPDATED;
    }
}

