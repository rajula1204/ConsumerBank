package com.bank.dao;


import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.bank.validator.BankEmail;



public class Customer {
    @NotNull
    @Size(min=2, max=30) 
	private String fName;
    @NotNull
    @Size(min=2, max=30)
	private String lName;
	private String aLaneOne;
	private String aLaneTwo;
	  @NotNull
	private String state;
	
	private String city;
	  @NotNull
	private int phone;
	@BankEmail
	private String email;
	@NotNull
	private int zipCode;
	
	private String customerId;
	private String pinNumber;
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String uniqueKey) {
		this.customerId = uniqueKey;
	}

	public String getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}
	
	
	private static final Logger logger = LoggerFactory.getLogger(Customer.class);
	
	public Customer(){
		logger.info("Customer class....................started");
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getaLaneOne() {
		return aLaneOne;
	}
	public void setaLaneOne(String aLaneOne) {
		this.aLaneOne = aLaneOne;
	}
	public String getaLaneTwo() {
		return aLaneTwo;
	}
	public void setaLaneTwo(String aLaneTwo) {
		this.aLaneTwo = aLaneTwo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
}
