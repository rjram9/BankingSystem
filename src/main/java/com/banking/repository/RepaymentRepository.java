package com.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.entity.Repayment;

public interface RepaymentRepository extends JpaRepository<Repayment,Long> {
	List<Repayment> findByLoanId(Long loanId);

}
