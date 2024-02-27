package com.banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Repayment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long loanId;
	private double amount;
	private String status;
public Repayment() {
	// TODO Auto-generated constructor stub
}
public Repayment(long id, long loanId, double amount, String status) {
	super();
	this.id = id;
	this.loanId = loanId;
	this.amount = amount;
	this.status = status;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getLoanId() {
	return loanId;
}
public void setLoanId(long loanId) {
	this.loanId = loanId;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
