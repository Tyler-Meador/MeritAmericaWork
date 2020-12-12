package com.meritamerica.assignment6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment6.model.AccountHolderContactDetails;
import com.meritamerica.assignment6.repository.AccountHolderContactDetailsRepository;

@Service
public class AccountHolderContactDetailsService {

	@Autowired
	private AccountHolderContactDetailsRepository repository;
	
	public AccountHolderContactDetails addDetails(AccountHolderContactDetails acc) {
		return repository.save(acc);
	}
	
	public List<AccountHolderContactDetails> getDetails(){
		return repository.findAll();
	}
	
	public AccountHolderContactDetails getDetailsById(int id) {
		return repository.findById(id).orElse(null);
	}
}
