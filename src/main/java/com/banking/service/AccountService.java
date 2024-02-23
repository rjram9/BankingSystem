package com.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Account;
import com.banking.repository.AccountRepository;
import com.banking.repository.TransactionRepository;
import com.banking.repository.UserRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository repo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TransactionRepository txnRepo;
	
	public Account createAccount(Account account) {
		return repo.save(account);
	}
	
	public Account getAccount(int id) {
		return repo.findById(id).get();
	}
	
	public Account updateAccount(Account account) {
		Account temp = repo.getById(account.getId());
		temp.setBalance(account.getBalance());
		return repo.save(temp);
	}
	
	public Double getBalance(int id) {
		return repo.getById(id).getBalance();
	}
	
	public void deleteAllRecords() {
		userRepo.deleteAll();
		repo.deleteAll();
		txnRepo.deleteAll();
	}
}
