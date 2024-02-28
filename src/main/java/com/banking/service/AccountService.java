package com.banking.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.config.JwtTokenUtil;
import com.banking.dto.Constants;
import com.banking.entity.Account;
import com.banking.entity.User;
import com.banking.repository.AccountRepository;
import com.banking.repository.TransactionRepository;
import com.banking.repository.UserRepository;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    TransactionService transactionService;

    private final Logger logger = LogManager.getLogger(getClass());

    public String createAccount(User user) {
        Account account = new Account();
        account.setAccountNo(user.getContactNo());
        account.setBalance((long) 1000);
        accountRepository.save(account);
        return Constants.ACCOUNT_CREATED;
    }

    public Account getAccountFromToken(String token) {
        String contactNo = jwtTokenUtil.getUsernameFromToken(token);
        return accountRepository.findByAccountNo(contactNo);
    }

    public Account getAccountByAccountNo(String accountNo) {
        return accountRepository.findByAccountNo(accountNo);
    }

    public void updateAccount(Account account) {
        accountRepository.save(account);
    }
}
