package com.meritamerica.assignment6.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account_Holder")
public class AccountHolder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String firstName;
	String middleName;
	String lastName;
	String ssn;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private AccountHolderContactDetails contactDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "holderId", referencedColumnName = "id")
	private List<CheckingAccount> checking;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "holderId", referencedColumnName = "id")
	private List<SavingsAccount> savings;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "holderId", referencedColumnName = "id")
	private List<CDAccount> cdAccounts;
	
	
	
	
	public List<CDAccount> getCdAccounts() {
		return cdAccounts;
	}
	public void setCdAccounts(List<CDAccount> cdAccounts) {
		this.cdAccounts = cdAccounts;
	}
	public List<SavingsAccount> getSavings() {
		return savings;
	}
	public void setSavings(List<SavingsAccount> savings) {
		this.savings = savings;
	}
	public List<CheckingAccount> getChecking() {
		return checking;
	}
	public void setChecking(List<CheckingAccount> checking) {
		this.checking = checking;
	}
	public AccountHolderContactDetails getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(AccountHolderContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	
	
}
