package com.meritamerica.pair7.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "Account_Holder")
public class AccountHolder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@NotBlank(message = "Cannot be blank")
	@NotNull(message = "Cannot be blank")
	String firstName;
	String middleName;
	@NotBlank(message = "Cannot be blank")
	@NotNull(message = "Cannot be blank")
	String lastName;
	@NotBlank(message = "Cannot be blank")
	@NotNull(message = "Cannot be blank")
	String ssn;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private AccountHolderContactDetails contactDetails;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "holderId", referencedColumnName = "id")
	private List<CheckingAccount> checkingAccounts;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "holderId", referencedColumnName = "id")
	private List<SavingsAccount> savingsAccounts;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "holderId", referencedColumnName = "id")
	private List<CDAccount> CDAccounts;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Users user;
	
	
	public List<CDAccount> getCDAccounts() {
		return CDAccounts;
	}
	public void setCDAccounts(List<CDAccount> cDAccounts) {
		CDAccounts = cDAccounts;
	}
	public List<SavingsAccount> getSavingsAccounts() {
		return savingsAccounts;
	}
	public void setSavingsAccounts(List<SavingsAccount> savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}
	public List<CheckingAccount> getCheckingAccounts() {
		return checkingAccounts;
	}
	public void setCheckingAccounts(List<CheckingAccount> checkingAccounts) {
		this.checkingAccounts = checkingAccounts;
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
