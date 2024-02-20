package com.banking.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Transaction;
import com.banking.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository repo;
	
	public Transaction createTransaction(Transaction txn) {
		return repo.save(txn);
	}
	
	public List<Transaction> getTransactions(int accountId){
		List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(repo.findByTransferFrom(accountId));
        transactions.addAll(repo.findByTransferTo(accountId));
        transactions.sort(Collections.reverseOrder());
        return transactions;
	}
	
}
