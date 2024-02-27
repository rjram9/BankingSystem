package com.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Loan;
import com.banking.repository.LoanRepository;

@Service
public class LoanService {
	private final LoanRepository loanRepository;
	   @Autowired
	   public LoanService(LoanRepository loanRepository) {
	       this.loanRepository = loanRepository;
	   }
	   public Loan applyLoan(Loan loan) {
	       loan.setStatus("pending");
	       return loanRepository.save(loan);
	   }
	   public List<Loan> getLoansByuserId(Long customerId) {
	       return loanRepository.findByUserId(customerId);
	   }
}
