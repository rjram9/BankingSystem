package com.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Account;
import com.banking.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository repo;
	
	public Account createAccount(Account account) {
		return repo.save(account);
	}
	
	public Account getAccount(int id) {
		return repo.getById(id);
	}
	
	public Account updateAccount(Account account) {
		Account temp = repo.getById(account.getId());
		temp.setBalance(account.getBalance());
		return repo.save(temp);
	}
	
	public Double getBalance(int id) {
		return repo.getById(id).getBalance();
	}
}
