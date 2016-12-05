package com.bank.domain.model;

/**
 * A model bean for the user login credentials
 *  
 * @author Giuseppe Urso
 *
 */
public class LoginForm {
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
