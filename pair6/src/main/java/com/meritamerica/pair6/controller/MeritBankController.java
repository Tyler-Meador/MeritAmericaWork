package com.meritamerica.pair6.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.pair6.exceptions.BalanceErrorException;
import com.meritamerica.pair6.exceptions.NotFoundException;
import com.meritamerica.pair6.model.AccountHolder;
import com.meritamerica.pair6.model.AccountHolderContactDetails;
import com.meritamerica.pair6.model.CDAccount;
import com.meritamerica.pair6.model.CDOffering;
import com.meritamerica.pair6.model.CheckingAccount;
import com.meritamerica.pair6.model.SavingsAccount;
import com.meritamerica.pair6.service.AccountHolderContactDetailsService;
import com.meritamerica.pair6.service.AccountHolderService;
import com.meritamerica.pair6.service.CDAccountService;
import com.meritamerica.pair6.service.CDOfferingService;
import com.meritamerica.pair6.service.CheckingAccountService;
import com.meritamerica.pair6.service.SavingsAccountService;

@RestController
public class MeritBankController {

	@Autowired
	private AccountHolderService service;
	@Autowired
	private AccountHolderContactDetailsService contactService;
	@Autowired
	private CheckingAccountService checkingService;
	@Autowired
	private SavingsAccountService savingsService;
	@Autowired
	private CDAccountService CDService;
	@Autowired
	private CDOfferingService offeringService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/AccountHolders")
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder acc) {
		return service.addAccountHolder(acc);
	}
	
	@GetMapping(value = "/AccountHolders")
	public List<AccountHolder> getAccountHolders(){
		return service.getAccountHolders();
	}
	
	@GetMapping(value = "/AccountHolders/{id}")
	public AccountHolder getAccountById(@PathVariable int id) throws NotFoundException {
		if(!service.searchForId(id)) {
			throw new NotFoundException("id does not exist");
		}
		return service.getAccountHolderById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/AccountHolders/{id}/ContactDetails")
	public AccountHolderContactDetails addAccountHolder(@PathVariable int id, @RequestBody AccountHolderContactDetails acc) throws NotFoundException {
		if(!service.searchForId(id)) {
			throw new NotFoundException("id does not exist");
		}
		acc.setId(id);
		return contactService.addContact(acc);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/ContactDetails")
	public AccountHolderContactDetails getContactById(@PathVariable int id) throws NotFoundException{
		if(!service.searchForId(id)) {
			throw new NotFoundException("id does not exist");
		}
		return contactService.getContactById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	public CheckingAccount addCheckingAccount(@PathVariable int id, @RequestBody @Valid CheckingAccount acc) throws NotFoundException, BalanceErrorException{
		if(!service.searchForId(id)) {
			throw new NotFoundException("id does not exist");
		}
		if(acc.getBalance() < 0) {
			throw new BalanceErrorException("Balance cannot be less than 0");
		}
		int cBalance = 0;
		List<CheckingAccount> temp = new ArrayList<CheckingAccount>();
		temp = service.getAccountHolderById(id).getCheckingAccounts();
		for(int i = 0; i < temp.size(); i++) {
			cBalance += temp.get(i).getBalance();
		}
		if(cBalance > 250000) {
			throw new BalanceErrorException("Balance cannot be greater than 250,000");
		}
		acc.setHolderId(id);
		return checkingService.addAccount(acc);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	public List<CheckingAccount> getCheckingAccounts(@PathVariable int id) throws NotFoundException{
		if(!service.searchForId(id)) {
			throw new NotFoundException("id does not exist");
		}
		return service.getAccountHolderById(id).getCheckingAccounts();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	public SavingsAccount addSavingsAccount(@PathVariable int id, @RequestBody @Valid SavingsAccount acc) throws NotFoundException, BalanceErrorException{
		if(!service.searchForId(id)) {
			throw new NotFoundException("id does not exist");
		}
		if(acc.getBalance() < 0) {
			throw new BalanceErrorException("Balance cannot be less than 0");
		}
		int cBalance = 0;
		List<SavingsAccount> temp = new ArrayList<SavingsAccount>();
		temp = service.getAccountHolderById(id).getSavingsAccounts();
		for(int i = 0; i < temp.size(); i++) {
			cBalance += temp.get(i).getBalance();
		}
		if(cBalance > 250000) {
			throw new BalanceErrorException("Balance cannot be greater than 250,000");
		}
		acc.setHolderId(id);
		return savingsService.addAccount(acc);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccounts(@PathVariable int id) throws NotFoundException{
		if(!service.searchForId(id)) {
			throw new NotFoundException("id does not exist");
		}
		return service.getAccountHolderById(id).getSavingsAccounts();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/AccountHolders/{id}/CDAccounts")
	public CDAccount addCDAccount(@PathVariable int id, @RequestBody @Valid CDAccount acc) throws NotFoundException, BalanceErrorException{
		if(!service.searchForId(id)) {
			throw new NotFoundException("id does not exist");
		}
		if(acc.getBalance() < 0) {
			throw new BalanceErrorException("Balance cannot be less than 0");
		}
		if(acc.getInterestRate() <= 0 || acc.getInterestRate() >= 1) {
			throw new BalanceErrorException("Interest rate must be between 0 and 1");
		}
		if(acc.getTerm() < 1) {
			throw new BalanceErrorException("Term cannot be less than 1");
		}
		acc.setHolderId(id);
		return CDService.addAccount(acc);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CDAccounts")
	public List<CDAccount> getCDAccounts(@PathVariable int id) throws NotFoundException{
		if(!service.searchForId(id)) {
			throw new NotFoundException("id does not exist");
		}
		return service.getAccountHolderById(id).getCDAccounts();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/CDOfferings")
	public CDOffering addCDOffering(@RequestBody @Valid CDOffering acc) throws BalanceErrorException {
		if(acc.getInterestRate() <= 0 || acc.getInterestRate() >= 1) {
			throw new BalanceErrorException("Interest rate must be between 0 and 1");
		}
		if(acc.getTerm() < 1) {
			throw new BalanceErrorException("Term cannot be less than 1");
		}
		return offeringService.addAccount(acc);
	}
	
	@GetMapping(value = "/CDOfferings")
	public List<CDOffering> getCDOffering(){
		return offeringService.getAccount();
	}
	
	
}
