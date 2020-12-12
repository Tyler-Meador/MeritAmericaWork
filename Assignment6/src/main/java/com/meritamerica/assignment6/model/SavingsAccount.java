package com.meritamerica.assignment6.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Savings_Account")
public class SavingsAccount extends BankAccount{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountNumber;
	Double interestRate = .0001;
	
	
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	

	
}
