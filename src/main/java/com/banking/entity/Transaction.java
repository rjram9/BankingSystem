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
	private int trasferTo;
	private txnType transactionType;
	private boolean isInterBankTxn;
	private double amount;
	private String date;
	
	enum txnType{
		CREDIT,DEBIT
	}
	
	public Transaction(int id, int transferFrom, int trasferTo, double amount, String date) {
		super();
		this.id = id;
		this.transferFrom = transferFrom;
		this.trasferTo = trasferTo;
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
		return trasferTo;
	}
	public void setTrasferTo(int trasferTo) {
		this.trasferTo = trasferTo;
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
