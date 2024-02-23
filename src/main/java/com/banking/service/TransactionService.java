package com.banking.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Account;
import com.banking.entity.Transaction;
import com.banking.exceptions.InsufficientBalanceException;
import com.banking.repository.TransactionRepository;

@Service

public class TransactionService {
	
	@Autowired
	TransactionRepository repo;
	
	@Autowired
	AccountService acntService;
	
	public Transaction createTransaction(Transaction txn) throws InsufficientBalanceException {
		
		double txnAmnt = txn.getAmount();
		int fromAcnt = txn.getTransferFrom();
		int toAcnt = txn.getTransferTo();
		double fromAcntBal = acntService.getBalance(fromAcnt);
		
		if(txnAmnt>fromAcntBal) {
			throw new InsufficientBalanceException("Insufficient Balance");
		}
		
		Transaction temp = repo.save(txn);
		
		if(temp.getTransactionType().equals("DEBIT")) {
			Account fromAcntObj = acntService.getAccount(fromAcnt);
			Account toAcntObj = acntService.getAccount(toAcnt);
			fromAcntObj.setBalance(fromAcntObj.getBalance()-txnAmnt);
			toAcntObj.setBalance(toAcntObj.getBalance()+txnAmnt);
			acntService.updateAccount(fromAcntObj);
			acntService.updateAccount(toAcntObj);
		}
		return temp;
	}
	
	public List<Transaction> getTransactions(int accountId){
		List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(repo.findByTransferFrom(accountId));
        transactions.addAll(repo.findByTransferTo(accountId));
        transactions.sort(Collections.reverseOrder());
        return transactions;
	}
	
	public void deleteAllTxns() {
		repo.deleteAll();
	}
	
}
