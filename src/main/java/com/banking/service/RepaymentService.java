package com.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Repayment;
import com.banking.repository.RepaymentRepository;

@Service
public class RepaymentService {
	private final RepaymentRepository repaymentRepository;
	   @Autowired
	   public RepaymentService(RepaymentRepository repaymentRepository) {
	       this.repaymentRepository = repaymentRepository;
	   }
	   public Repayment makeRepayment(Repayment repayment) {
	       repayment.setStatus("paid");
	       return repaymentRepository.save(repayment);
	   }
	   public List<Repayment> getRepaymentsByLoanId(Long loanId) {
	       return repaymentRepository.findByLoanId(loanId);
	   }
}
