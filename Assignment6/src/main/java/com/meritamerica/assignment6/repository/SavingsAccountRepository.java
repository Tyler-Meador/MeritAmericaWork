package com.meritamerica.assignment6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment6.model.SavingsAccount;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Integer>{

}
