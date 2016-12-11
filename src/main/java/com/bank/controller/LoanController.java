package com.bank.controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bank.domain.model.Loan;
import com.bank.domain.model.MortgageBO;
import com.bank.domain.service.CustomerManager;
import com.bank.domain.service.CustomerService;
import com.bank.exception.EmployeeNotFoundException;
import com.bank.util.Constants;




/**
 * The Class LoanController.
 */
@RestController
public class LoanController {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	
	/** The customer manager. */
	//@AutoWired has some issue, need to work on it later 
	public CustomerService customerManager = new CustomerManager();


	/**
	 * Validate method.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value=Constants.VALIDATE_CUSTOMER,method = RequestMethod.GET)  
    public ModelAndView validateMethod(){  
		logger.info("validateMethod start");
		return new ModelAndView(Constants.LOAN_INFORMATION_PAGE,Constants.COMMAND,new Loan());  
    }  
	

	/**
	 * Fetch loan details.
	 *
	 * @param loan the loan
	 * @return the model and view
	 * @throws IOException 
	 */
	@RequestMapping(value=Constants.LOAN_DETAILS, method = RequestMethod.POST)  
    public ModelAndView fetchLoanDetails(@ModelAttribute(Constants.COMMAND) Loan loan) throws IOException{
		MortgageBO mBO =null;
        logger.info("fetchLoanDetails start");
        ModelAndView model = new ModelAndView(Constants.LOAN_INFORMATION_PAGE);
        //mBO = customerManager.callLoanWEbservice(loan);   //having some issue need to check it later, The server sent HTTP status code 200: OK
        mBO = customerManager.callTempMortgageServiceToFillData();
        
        model.addObject(Constants.MORTGAGE, mBO);
                model.addObject(Constants.LOAN, loan);
        
        return   model;
    }

	/*  @RequestMapping(value="/validatecustomer/{customerId}/{pinNumber}",method = RequestMethod.GET)  
    public ModelAndView ValidateMethod(@PathVariable String customerId,@PathVariable String pinNumber){  
        logger.info("Customerid......................:"+customerId);
		logger.info("pinNumber...................... :"+pinNumber);
		MortgageBO bean = callwebServiceToValidate(customerId,pinNumber));
		
		return new ModelAndView("loanInformation","command",new Loan());  
    }  
   */

	
	/**
	 * Testing the Exception.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the employee
	 * @throws Exception the exception
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String getException(@PathVariable("id") int id, Model model) throws Exception{
		//deliberately throwing different types of exception
		if(id==1){
			throw new EmployeeNotFoundException(id);
		}else if(id==2){
			throw new SQLException("SQLException, id="+id);
		}else if(id==3){
			throw new IOException("IOException, id="+id);
		}else if(id==10){
			model.addAttribute(Constants.WELCOME_MESSAGE, Constants.WELCOME_MESSAGE_TEXT);
			return Constants.HOME;
		}else {
			throw new Exception("Generic Exception, id="+id);
		}
		
	}
	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
		
		ModelAndView modelAndView = formException(request, ex);
	    return modelAndView;
	}

	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(HttpServletRequest request, Exception ex){
		
		ModelAndView modelAndView = formException(request, ex);
	    return modelAndView;
	}
	/** Local method
	 * @param request
	 * @param ex
	 * @return
	 */
	private ModelAndView formException(HttpServletRequest request, Exception ex) {
		logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
		return modelAndView;
	}

}
