package com.bank.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class EmailValidator implements ConstraintValidator<BankEmail, String> {
	private static final Logger logger = LoggerFactory.getLogger(EmailValidator.class);
	
	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN =
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

public EmailValidator(){
	pattern = Pattern.compile(EMAIL_PATTERN);
}
	@Override
	public void initialize(BankEmail arg0) {
	
		
	}
	/**
	 * Validate email with regular expression
	 *
	 * @param email
	 *            email for validation
	 * @return true valid email, false invalid email
	 */
	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		logger.info("isValid.method...................started");
		if(email == null){
			return false;
		}

		matcher = pattern.matcher(email);
		return matcher.matches();

	}

}