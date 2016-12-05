package com.bank.domain.service;

import java.util.Map;

import com.bank.domain.model.Customer;
import com.bank.domain.model.Loan;
import com.bank.domain.model.MortgageBO;

public interface CustomerService {

	public abstract Customer getPinNumber(Customer customer);

	//@Cacheable(value = "defaultCache", key = "map")
	public abstract Map<String, String> getStates() throws Exception;

	public abstract void callRestFulWebservice(Object newParam) throws Exception;

	public abstract Customer getcustomers(Customer cust);
	
	public abstract MortgageBO callLoanWEbservice(Loan loan) throws Exception;
	public abstract MortgageBO callTempMortgageServiceToFillData();

}