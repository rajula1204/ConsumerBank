package com.bank.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.domain.model.Customer;

public interface CustomerControllerInterface {

	public abstract ModelAndView visitHome();

	public abstract ModelAndView customerWelcomePage() throws Exception;

	public abstract ModelAndView saveCustomerDetails(Customer customer,
			BindingResult bindingResult) throws Exception;

}