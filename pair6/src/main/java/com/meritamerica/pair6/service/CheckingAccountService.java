package com.meritamerica.pair6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.pair6.model.CheckingAccount;
import com.meritamerica.pair6.repository.CheckingAccountRepository;

@Service
public class CheckingAccountService {
	@Autowired
	private CheckingAccountRepository repository;
	
	public CheckingAccount addAccount(CheckingAccount acc) {
		return repository.save(acc);
	}
	
	public List<CheckingAccount> getAccount(){
		return repository.findAll();
	}
	
	public List<CheckingAccount> getAccountById(Iterable<Integer> ids){
		return repository.findAllById(ids);
	}
	
	public boolean searchForId(int id) {
		return repository.existsById(id);
	}
}
