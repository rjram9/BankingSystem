package com.banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int transferFrom;
	private int transferTo;
	private txnType transactionType;
	private boolean isInterBankTxn;
	private double amount;
	private String date;
	
	enum txnType{
		CREDIT,DEBIT
	}

	public Transaction(int id, int transferFrom, int trasferTo, txnType transactionType, boolean isInterBankTxn,
			double amount, String date) {
		super();
		this.id = id;
		this.transferFrom = transferFrom;
		this.transferTo = trasferTo;
		this.transactionType = transactionType;
		this.isInterBankTxn = isInterBankTxn;
		this.amount = amount;
		this.date = date;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTransferFrom() {
		return transferFrom;
	}

	public void setTransferFrom(int transferFrom) {
		this.transferFrom = transferFrom;
	}

	public int getTrasferTo() {
		return transferTo;
	}

	public void setTrasferTo(int trasferTo) {
		this.transferTo = trasferTo;
	}

	public txnType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(txnType transactionType) {
		this.transactionType = transactionType;
	}

	public boolean isInterBankTxn() {
		return isInterBankTxn;
	}

	public void setInterBankTxn(boolean isInterBankTxn) {
		this.isInterBankTxn = isInterBankTxn;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
