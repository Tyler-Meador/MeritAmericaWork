package com.meritamerica.assignment6.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account_Details")
public class AccountHolderContactDetails {

	@Id
	int id;
	
	String email;
	Long phoneNum;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
