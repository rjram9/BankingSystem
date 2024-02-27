package com.banking.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entity.Loan;
import com.banking.repository.LoanRepository;

@RestController
@RequestMapping("/api")
public class LoanController {
	private final LoanRepository loanRepository;
	public LoanController (LoanRepository loanRepository) {
		this.loanRepository=loanRepository;
	}
	@PostMapping("/applyLoan")
	   public Loan applyLoan(@RequestBody Loan loan) {
	       loan.setStatus("pending");
	       return loanRepository.save(loan);
	   }
	   @GetMapping("loan/{userId}")
	   public List<Loan> getLoansByuserId(@PathVariable Long userId) {
	       return loanRepository.findByUserId(userId);
	   }
	}
