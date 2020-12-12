package com.meritamerica.assignment6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment6.model.SavingsAccount;
import com.meritamerica.assignment6.repository.SavingsAccountRepository;

@Service
public class SavingsAccountService {
	@Autowired
	private SavingsAccountRepository repository;
	
	public SavingsAccount addSavings(SavingsAccount acc) {
		return repository.save(acc);
	}
	
	public List<SavingsAccount> getSavingsAccounts(){
		return repository.findAll();
	}
	
	public SavingsAccount getSavingsById(int id) {
		return repository.findById(id).orElse(null);
	}
}
