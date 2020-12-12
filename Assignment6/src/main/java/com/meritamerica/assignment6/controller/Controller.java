package com.meritamerica.assignment6.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment6.model.AccountHolder;
import com.meritamerica.assignment6.model.AccountHolderContactDetails;
import com.meritamerica.assignment6.model.CDAccount;
import com.meritamerica.assignment6.model.CheckingAccount;
import com.meritamerica.assignment6.model.SavingsAccount;
import com.meritamerica.assignment6.service.AccountHolderContactDetailsService;
import com.meritamerica.assignment6.service.AccountHolderService;
import com.meritamerica.assignment6.service.CDAccountService;
import com.meritamerica.assignment6.service.CheckingAccountService;
import com.meritamerica.assignment6.service.SavingsAccountService;


@RestController
public class Controller {
	
	@Autowired
	private AccountHolderService service;
	@Autowired
	private AccountHolderContactDetailsService detailsService;
	@Autowired
	private CheckingAccountService checkingService;
	@Autowired
	private SavingsAccountService savingsService;
	@Autowired
	private CDAccountService cdService;
	
	@PostMapping(value = "/AccountHolders")
	public AccountHolder addAccountHolder(@RequestBody AccountHolder acc) {
		return service.addAccountHolder(acc);
	}
	
	@GetMapping(value = "/AccountHolders")
	public List<AccountHolder> getAccountHolders(){
		return service.getAccountHolders();
	}
	
	@GetMapping(value = "/AccountHolders/{id}")
	public AccountHolder getAccountById(@PathVariable int id) {
		return service.getAccountById(id);
	}
	
	@PostMapping(value = "/AccountHolders/{id}/ContactDetails")
	public AccountHolderContactDetails addDetails(@PathVariable int id, @RequestBody AccountHolderContactDetails acc) {
		acc.setId(id);
		return detailsService.addDetails(acc);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/ContactDetails")
	public AccountHolderContactDetails getDetails(@PathVariable int id){
		return detailsService.getDetailsById(id);
	}
	
	@PostMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	public CheckingAccount addCheckingAccount(@PathVariable int id, @RequestBody CheckingAccount acc) {
		acc.setHolderId(id);
		return checkingService.addChecking(acc);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	public List<CheckingAccount> getCheckingAccounts(@PathVariable int id){
		return service.getAccountById(id).getChecking();
	}
	
	@PostMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	public SavingsAccount addSavingsAccount(@PathVariable int id, @RequestBody SavingsAccount acc) {
		acc.setHolderId(id);
		return savingsService.addSavings(acc);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccounts(@PathVariable int id){
		return service.getAccountById(id).getSavings();
	}
	
	@PostMapping(value = "/AccountHolders/{id}/CDAccounts")
	public CDAccount addCDAccount(@PathVariable int id, @RequestBody CDAccount acc) {
		acc.setHolderId(id);
		return cdService.addCDAccount(acc);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CDAccounts")
	public List<CDAccount> getCDAccounts(@PathVariable int id){
		return service.getAccountById(id).getCdAccounts();
	}

	
	
}
