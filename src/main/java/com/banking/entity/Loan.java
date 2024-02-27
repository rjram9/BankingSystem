package com.banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long userId;
	private double amount;
	private double interestRate;
	private int term;
	private String status;
   public Loan() {
	// TODO Auto-generated constructor stub
}
public Loan(long id, long userId, double amount, double interestRate, int term, String status) {
	super();
	this.id = id;
	this.userId = userId;
	this.amount = amount;
	this.interestRate = interestRate;
	this.term = term;
	this.status = status;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public double getInterestRate() {
	return interestRate;
}
public void setInterestRate(double interestRate) {
	this.interestRate = interestRate;
}
public int getTerm() {
	return term;
}
public void setTerm(int term) {
	this.term = term;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
   
}
