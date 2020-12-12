package com.meritamerica.pair6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.pair6.model.SavingsAccount;
import com.meritamerica.pair6.repository.SavingsAccountRepository;

@Service
public class SavingsAccountService {
	@Autowired
	private SavingsAccountRepository repository;
	
	public SavingsAccount addAccount(SavingsAccount acc) {
		return repository.save(acc);
	}
	
	public List<SavingsAccount> getAccount(){
		return repository.findAll();
	}
	
	public List<SavingsAccount> getAccountById(Iterable<Integer> ids){
		return repository.findAllById(ids);
	}
	
	public boolean searchForId(int id) {
		return repository.existsById(id);
	}
}
