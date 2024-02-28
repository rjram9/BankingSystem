package com.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
	List<Transaction> findByTransferFrom(String transferFrom);

    List<Transaction> findByTransferTo(String transferTo);
}
