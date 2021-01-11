package com.meritamerica.pair7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.pair7.model.AccountHolderContactDetails;
import com.meritamerica.pair7.repository.AccountHolderContactDetailsRepository;


@Service
public class AccountHolderContactDetailsService {
	@Autowired
	private AccountHolderContactDetailsRepository repository;
	
	public AccountHolderContactDetails addContact(AccountHolderContactDetails acc) {
		return repository.save(acc);
	}
	
	public List<AccountHolderContactDetails> getContact(){
		return repository.findAll();
	}
	
	public AccountHolderContactDetails getContactById(int id){
		return repository.findById(id).orElse(null);
	}
	public boolean searchForId(int id) {
		return repository.existsById(id);
	}
	
}
