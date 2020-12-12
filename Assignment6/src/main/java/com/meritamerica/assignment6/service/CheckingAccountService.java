package com.meritamerica.assignment6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment6.model.CheckingAccount;
import com.meritamerica.assignment6.repository.CheckingAccountRepository;

@Service
public class CheckingAccountService {

	@Autowired
	private CheckingAccountRepository repository;
	
	public CheckingAccount addChecking(CheckingAccount acc) {
		return repository.save(acc);
	}
	
	public List<CheckingAccount> getCheckingAccounts(){
		return repository.findAll();
	}
	
	public CheckingAccount getCheckingById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	
}
