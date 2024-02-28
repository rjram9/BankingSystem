package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	Account findByAccountNo(String contactNo);
}
