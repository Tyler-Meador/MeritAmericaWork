package com.meritamerica.pair7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.pair7.model.AccountHolder;
import com.meritamerica.pair7.repository.AccountHolderRepository;



@Service
public class AccountHolderService{

	@Autowired
	private AccountHolderRepository repository;

	public AccountHolder addAccountHolder(AccountHolder acc) {
		return repository.save(acc);
	}
	
	public List<AccountHolder> getAccountHolders(){
		return repository.findAll();
	}
	
	public AccountHolder getAccountHolderById(int id){
		return repository.findById(id).orElse(null);
	}
	
	public boolean searchForId(int id) {
		return repository.existsById(id);
	}
	
	
	
}
