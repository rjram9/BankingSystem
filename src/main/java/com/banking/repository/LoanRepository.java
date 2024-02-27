package com.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.entity.Loan;

public interface LoanRepository  extends JpaRepository<Loan,Long> {
	List<Loan>findByUserId(Long userId);

}
