package com.bank.controller;


import java.util.Map;

import javax.validation.Valid;









import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bank.domain.model.Customer;
import com.bank.domain.service.CustomerManager;
import com.bank.domain.service.CustomerService;
import com.bank.util.Constants;



/**
 * The Class CustomerController.
 */
@RestController
public class CustomerController implements CustomerControllerInterface {
	

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(CustomerController.class);

	
	/** The validator. */
	@Autowired
	@Qualifier(Constants.CUSTOMER_VALIDATOR)
	private Validator validator;
	
	
	/**
	 * Inits the binder.
	 *
	 * @param binder the binder
	 */
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	/** The customer manager. */
	//@AutoWired has some issue, need to work on it later
	public CustomerService customerManager = new CustomerManager();

	
	/* (non-Javadoc)
	 * @see com.bank.controller.CustomerControllerInterface#visitHome()
	 */
	@Override
	@RequestMapping(value = Constants.HOME_REQUEST, method = RequestMethod.GET)
	public ModelAndView visitHome() {
		logger.info(" visitHome method");
		
		return methodForHomePage();
	}

	/* (non-Javadoc)
	 * @see com.bank.controller.CustomerControllerInterface#customerWelcomePage()
	 */
	@Override
	@RequestMapping(value = Constants.HELLO,  method = RequestMethod.GET)
	public ModelAndView customerWelcomePage() throws Exception{
		
		return methodForCustWelcomepage();
	}

	
	/* (non-Javadoc)
	 * @see com.bank.controller.CustomerControllerInterface#saveCustomerDetails(com.bank.domain.model.Customer, org.springframework.validation.BindingResult)
	 */
	@Override
	@RequestMapping(value = Constants.SAVE, method = RequestMethod.POST)
	public ModelAndView saveCustomerDetails(
			@Valid @ModelAttribute(Constants.COMMAND) Customer customer, BindingResult bindingResult)  throws Exception{
		
		if (bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView(Constants.WELCOME_PAGE);
			model.addObject(Constants.COMMAND, customer);
			Map<String, String> list = customerManager.getStates();
			model.addObject(Constants.STATE_LIST, list);
			return model;
		}
		customer = customerManager.getcustomers(customer);
		customer = customerManager.getPinNumber(customer);
		ModelAndView model = new ModelAndView(Constants.VIEW_CUSTOMER_PAGE);
		model.addObject(Constants.CUSTOMER_BO, customer);
		return model;
	}

	
	/**
	 * Method for home page.
	 *
	 * @return the model and view
	 */
	private ModelAndView methodForHomePage() {
		return new ModelAndView(Constants.HOME, Constants.WELCOME_MESSAGE,
				Constants.WELCOME_MESSAGE_TEXT);
	}

	/**
	 * Method for cust welcomepage.
	 *
	 * @return the model and view
	 * @throws Exception the exception
	 */
	private ModelAndView methodForCustWelcomepage() throws Exception {
		ModelAndView model;
		customerManager.callRestFulWebservice(null);
		Map<String, String> list = customerManager.getStates();
		model = new ModelAndView(Constants.WELCOME_PAGE);
		model.addObject(Constants.STATE_LIST, list);
		model.addObject(Constants.COMMAND, new Customer());
		return model;
	}
}
