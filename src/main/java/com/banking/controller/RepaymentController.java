package com.banking.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entity.Repayment;
import com.banking.repository.RepaymentRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RepaymentController {
	 
	 
	   private final RepaymentRepository repaymentRepository;
	   public RepaymentController(RepaymentRepository repaymentRepository) {
	       this.repaymentRepository = repaymentRepository;
	   }
	   @PostMapping("/repayments")
	   public Repayment makeRepayment(@RequestBody Repayment repayment) {
	       repayment.setStatus("paid");
	       return repaymentRepository.save(repayment);
	   }
	   @GetMapping("/{loanId}")
	   public List<Repayment> getRepaymentsByLoanId(@PathVariable Long loanId) {
	       return repaymentRepository.findByLoanId(loanId);
	   }
	
}
