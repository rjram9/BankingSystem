package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entity.Transaction;
import com.banking.exceptions.InsufficientBalanceException;
import com.banking.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {
	
	@Autowired
	TransactionService service;
	
	@GetMapping("/transactions/{acntId}")
	public List<Transaction> getTransactions(@PathVariable int acntId){
		return service.getTransactions(acntId);
	}
	
	@PostMapping("/transfer")
	public Transaction transfer(@RequestBody Transaction txn) throws InsufficientBalanceException{
		return service.createTransaction(txn);
	}
	
	@DeleteMapping("/deleteAllTxns")
	public void deleteAllTxns() {
		service.deleteAllTxns();
	}
}
