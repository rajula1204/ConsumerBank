package com.loan.controller;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPFaultException;

import net.webservicex.Mortgage;
import net.webservicex.MortgageHttpGet;
import net.webservicex.MortgageResults;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bank.dao.Loan;
import com.bank.dao.MortgageBO;
/**
@author Pullareddyr
* 1. Implemented SLF4J log files
* 2. Implemented Validations using Manual and Annotated. Still need to apply for few fields 
* 3. Used Maven tool to build the application
* 4. Successfully created customer identification number and pinNumber. Temporally commented this method
*    as this query string is staying permanently. Need to findout why.   
* 5. Unit Test cases under construction
* 6. Successfully implemented CXF client code to fetch the data from mortgage Web service. As per my observation this web service is on and off some time. 
*    Webservice returning status code 200, but values are not return. Now populating dummy data based on webservice output.   
*/
@RestController
public class LoanController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	

/*  @RequestMapping(value="/validatecustomer/{customerId}/{pinNumber}",method = RequestMethod.GET)  
    public ModelAndView ValidateMethod(@PathVariable String customerId,@PathVariable String pinNumber){  
        logger.info("Customerid......................:"+customerId);
		logger.info("pinNumber...................... :"+pinNumber);
		MortgageBO mBO = callLoanWEbservice(new Loan());
		return new ModelAndView("loanInformation","command",new Loan());  
    }  
*/

	@RequestMapping(value="/validatecustomer",method = RequestMethod.GET)  
    public ModelAndView validateMethod(){  
		logger.info("validateMethod start");
		return new ModelAndView("loanInformation","command",new Loan());  
    }  
	
	
	@RequestMapping(value="loandetail", method = RequestMethod.POST)  
    public ModelAndView fetchLoanDetails(@ModelAttribute("command") Loan loan){
		MortgageBO mBO =null;
        logger.info("fetchLoanDetails start");
        //mBO = callLoanWEbservice(loan);   //having some issue while returning data
        ModelAndView model = new ModelAndView("loanInformation");
      //Creating dummy data
        mBO = new MortgageBO();
        mBO.setMonthlyInsurance(1000);
        mBO.setMonthlyPrincipalAndInterest(10);
        mBO.setMonthlyTax(30);
        mBO.setTotalPayment(40);
        
        model.addObject("mortgage", mBO);
                model.addObject("loan", loan);
        
        return   model;
    }
	
	
	
	private MortgageBO callLoanWEbservice(Loan loan) {
		Mortgage mortService = null;
		MortgageBO m=null;
		MortgageResults mortResult = null;
		final QName SERVICE_NAME = new QName("http://www.webserviceX.NET/", "Mortgage");
		URL url;
		try {
			url = new URL("file:/C:/Users/pullareddyr/Struts/ConsumerBank/src/main/resources/Mortgage.wsdl");
			mortService = new Mortgage(url,SERVICE_NAME);
		} catch (MalformedURLException e) {
				e.printStackTrace();
		}
		
		try{
		MortgageHttpGet  mortGet = mortService.getMortgageHttpGet();
		BindingProvider bp = (BindingProvider)mortGet;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://www.webserviceX.NET/");
        logger.info("callLoanWEbservice before webservice method call");
        //System.setProperty("com.sun.xml.internal.bind.api.JAXBRIContext", "com.sun.xml.bind.v2.runtime.JAXBContextImpl");
        mortResult  = mortGet.getMortgagePayment(String.valueOf(loan.getYears()), String.valueOf(loan.getSalary()),
       							String.valueOf(loan.getLoanAmount()), String.valueOf(loan.getAnnualTax()),String.valueOf(loan.getAnnualInsurance()));
        logger.info("callLoanWEbservice after webservice method call"); 		
		m= new MortgageBO();
		m.setMonthlyPrincipalAndInterest(mortResult.getMonthlyPrincipalAndInterest());
		m.setMonthlyInsurance(mortResult.getMonthlyInsurance());
		m.setMonthlyTax(mortResult.getMonthlyTax());
		m.setTotalPayment(mortResult.getTotalPayment());
		
	}catch (SOAPFaultException e) {
		logger.info("SOAPFaultException error..message :"+e.getMessage());
		logger.info("fault code:"+e.getFault().getFaultCode());
		
	} catch (WebServiceException we) {
		logger.info("webservice exception :"+we.getMessage());
		
	}
		return m;
}
	
}
