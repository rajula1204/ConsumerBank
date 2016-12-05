package com.bank.util;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bank.domain.model.Customer;


public class CustomerFormValidator implements Validator {

private static final Logger logger = LoggerFactory.getLogger(Customer.class);
	
 
	

	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Customer.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		logger.info("validate.method...................started");		

			
 		Customer cust = (Customer) obj;
		if(cust.getPhone() <=0){
			errors.rejectValue("phone", "negativeValue", new Object[]{"'phone'"}, "phone can't be negative");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fName", "fName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lName", "lName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "city.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "state.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "zipCode.required");
		
			
	}
}
