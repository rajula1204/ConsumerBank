package com.bank.domain.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bank.util.BankEmail;


/**
 * The Class Customer.
 */
public class Customer {
    
     /** The name.
	 */
    @NotNull
    @Size(min=2, max=30) 
	private String fName;
    
     /** The l name.
	 */
    @NotNull
    @Size(min=2, max=30)
	private String lName;
	
	/**
	 * The a lane one.
	 */
	private String aLaneOne;
	
	/**
	 * The a lane two.
	 */
	private String aLaneTwo;
	  
  	 /** The state.
	 */
  	@NotNull
	private String state;
	
	/**
	 * The city.
	 */
	private String city;
	  
  	/** The phone.
	 */
  	@NotNull
	private int phone;
	
	/**
	 * The email.
	 */
	@BankEmail
	private String email;
	
	/**
	 * The zip code.
	 */
	@NotNull
	private int zipCode;
	
	/**
	 * The customer id.
	 */
	private String customerId;
	
	/**
	 * The pin number.
	 */
	private String pinNumber;
	
	/**
	 * Gets the customer id.
	 * 
	 * @return the customer id
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer id.
	 * 
	 * @param uniqueKey
	 *            the new customer id
	 */
	public void setCustomerId(String uniqueKey) {
		this.customerId = uniqueKey;
	}

	/**
	 * Gets the pin number.
	 * 
	 * @return the pin number
	 */
	public String getPinNumber() {
		return pinNumber;
	}

	/**
	 * Sets the pin number.
	 * 
	 * @param pinNumber
	 *            the new pin number
	 */
	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}
	
	
	/**
	 * The Constant logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(Customer.class);
	
	/**
	 * Instantiates a new customer.
	 */
	public Customer(){
		
	}
	
	/**
	 * Gets the f name.
	 * 
	 * @return the f name
	 */
	public String getfName() {
		return fName;
	}
	
	/**
	 * Sets the f name.
	 * 
	 * @param fName
	 *            the new f name
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	/**
	 * Gets the l name.
	 * 
	 * @return the l name
	 */
	public String getlName() {
		return lName;
	}
	
	/**
	 * Sets the l name.
	 * 
	 * @param lName
	 *            the new l name
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	/**
	 * Gets the a lane one.
	 * 
	 * @return the a lane one
	 */
	public String getaLaneOne() {
		return aLaneOne;
	}
	
	/**
	 * Sets the a lane one.
	 * 
	 * @param aLaneOne
	 *            the new a lane one
	 */
	public void setaLaneOne(String aLaneOne) {
		this.aLaneOne = aLaneOne;
	}
	
	/**
	 * Gets the a lane two.
	 * 
	 * @return the a lane two
	 */
	public String getaLaneTwo() {
		return aLaneTwo;
	}
	
	/**
	 * Sets the a lane two.
	 * 
	 * @param aLaneTwo
	 *            the new a lane two
	 */
	public void setaLaneTwo(String aLaneTwo) {
		this.aLaneTwo = aLaneTwo;
	}
	
	/**
	 * Gets the state.
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets the state.
	 * 
	 * @param state
	 *            the new state
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Gets the city.
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 * 
	 * @param city
	 *            the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the phone.
	 * 
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}
	
	/**
	 * Sets the phone.
	 * 
	 * @param phone
	 *            the new phone
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the zip code.
	 * 
	 * @return the zip code
	 */
	public int getZipCode() {
		return zipCode;
	}
	
	/**
	 * Sets the zip code.
	 * 
	 * @param zipCode
	 *            the new zip code
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
}
