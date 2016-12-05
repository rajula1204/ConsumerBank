package com.bank.controller;



import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.bank.domain.model.Customer;

public interface CustomerControllerInterface {

	public abstract ModelAndView visitHome();

	public abstract ModelAndView customerWelcomePage() throws Exception;

	public abstract ModelAndView saveCustomerDetails(Customer customer,
			BindingResult bindingResult) throws Exception;

}