package com.meritamerica.pair6.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@MappedSuperclass
public class BankAccount {
	
	
	private int holderId;
	@NotNull(message = "Cannot be blank")
	private Double balance;
	private long openedOn;
	
	
	
	public BankAccount() {
		
	}
	

	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getOpenedOn() {
		return openedOn;
	}
	public void setOpenedOn(long openedOn) {
		this.openedOn = openedOn;
	}
	public void setHolderId(int holderId) {
		this.holderId = holderId;
	}
	
	
}
