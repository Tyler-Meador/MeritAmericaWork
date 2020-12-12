package com.meritamerica.pair6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.pair6.model.CDAccount;
import com.meritamerica.pair6.repository.CDAccountRepository;


@Service
public class CDAccountService {
	@Autowired
	private CDAccountRepository repository;
	
	public CDAccount addAccount(CDAccount acc) {
		return repository.save(acc);
	}
	
	public List<CDAccount> getAccount(){
		return repository.findAll();
	}
	
	public List<CDAccount> getAccountById(Iterable<Integer> ids){
		return repository.findAllById(ids);
	}
	
	public boolean searchForId(int id) {
		return repository.existsById(id);
	}
}
