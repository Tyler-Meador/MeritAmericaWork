package com.meritamerica.assignment6.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CD_Account")
public class CDAccount extends BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int accountNumder;
	
	Double interestRate;
	Integer Term;
	
	
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	public Integer getTerm() {
		return Term;
	}
	public void setTerm(Integer term) {
		Term = term;
	}
	
	
}
