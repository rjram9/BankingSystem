package com.banking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int transferFrom;
	private int transferTo;
	private String transactionType;
	private boolean isInterBankTxn;
	private double amount;
	private String date;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int id, int transferFrom, int transferTo, String transactionType, boolean isInterBankTxn,
			double amount, String date) {
		super();
		this.id = id;
		this.transferFrom = transferFrom;
		this.transferTo = transferTo;
		this.transactionType = transactionType;
		this.isInterBankTxn = isInterBankTxn;
		this.amount = amount;
		this.date = date;
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
	public int getTransferTo() {
		return transferTo;
	}
	public void setTransferTo(int transferTo) {
		this.transferTo = transferTo;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
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
