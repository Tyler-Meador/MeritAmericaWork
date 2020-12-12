package com.meritamerica.assignment6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment6.model.AccountHolder;
import com.meritamerica.assignment6.repository.AccountHolderRepository;

@Service
public class AccountHolderService {
	
	@Autowired
	private AccountHolderRepository repository;
	
	public AccountHolder addAccountHolder(AccountHolder account) {
		return repository.save(account);
	}
	
	public List<AccountHolder> getAccountHolders(){
		return repository.findAll();
	}
	
	public AccountHolder getAccountById(int id) {
		return repository.findById(id).orElse(null);
	}

}
