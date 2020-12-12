package com.meritamerica.assignment6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment6.model.CDAccount;
import com.meritamerica.assignment6.repository.CDAccountRepository;

@Service
public class CDAccountService {

	@Autowired
	private CDAccountRepository repository;
	
	 public CDAccount addCDAccount(CDAccount acc) {
		return repository.save(acc);
	 }
	 
	 public List<CDAccount> getCDAccounts(){
		 return repository.findAll();
	 }
	 
	 public CDAccount getCDAccountById(int id) {
		 return repository.findById(id).orElse(null);
	 }
}
