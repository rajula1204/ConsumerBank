/*Class : CustomerManager.java
 * 
 */

package com.bank.domain.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPFaultException;

import net.spy.memcached.MemcachedClient;
import net.webservicex.Mortgage;
import net.webservicex.MortgageHttpGet;
import net.webservicex.MortgageResults;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.bank.domain.model.Customer;
import com.bank.domain.model.Loan;
import com.bank.domain.model.MortgageBO;
import com.bank.domain.model.Quote;
import com.bank.domain.model.StaticStates;
import com.bank.handler.ContextListener;
import com.bank.util.Constants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class CustomerManager.
 */
@Named
public class CustomerManager implements CustomerService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(Customer.class);
	
	List<StaticStates> list = null;
	Map<String, String> map = null;
	
	// private MemcachedClient memcached;
       
		
	 	@Inject
	    public CustomerManager() {
	      
	    }

	
	/* Generating pin number for each new customer.
	 * @see com.bank.domain.service.CustomerService#getPinNumber(com.bank.domain.model.Customer)
	 */
	@Override
	public Customer getPinNumber(Customer customer) {
		String val = Constants.SPACE + ((int) (Math.random() * 9000) + 1000);
		customer.setPinNumber(val);
		return customer;
	}


	/* Reading data from the local json file. it is temporary. Used memcache.
	 * @see com.bank.domain.service.CustomerService#getStates()
	 */
	//@Cacheable(value = "defaultCache", key = "map")
	@Override
	public Map<String, String> getStates()  throws Exception {
   
		 
		ObjectMapper objectMapper = new ObjectMapper();

		if(ContextListener.getClient().get(Constants.MEMCACHED_STATES) != null){
			logger.info("getting the value from memcache");
			Object obj = ContextListener.getClient().get(Constants.MEMCACHED_STATES);
			@SuppressWarnings("unchecked")
			Map<String, String> map = (Map<String, String>) obj;          		
			
			return map;
		}
		
		try {
			
			list = objectMapper.readValue(
					new File(Constants.JSON_LOCAL_FILE),
					objectMapper.getTypeFactory().constructCollectionType(
							List.class, StaticStates.class));
			
			map = new HashMap<String, String>();
		
			for (StaticStates st : list) {
				map.put(st.getAbbr(), st.getName());
	
			}
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Adding the states into Memcache");
		ContextListener.getClient().add(Constants.MEMCACHED_STATES,2000,map);
		return map;
	}
        
	/* For time being  filling dummey data. It will be deleted once the Web service (method callLoanWEbservice()) works fine
	 * @see com.bank.domain.service.CustomerService#callTempMortgageServiceToFillData()
	 */
	@Override
	public MortgageBO callTempMortgageServiceToFillData() throws IOException {
		MortgageBO mBO = new MortgageBO();
		
		if(ContextListener.getClient().get(Constants.MEMCACHED_MORTGAGE) != null){
			logger.info("getting the mortgage value from memcache");
			Object obj = ContextListener.getClient().get(Constants.MEMCACHED_MORTGAGE);
			
			mBO = (MortgageBO) obj;          		
			
			return mBO;
		}
				
        mBO.setMonthlyInsurance(0.82);
        mBO.setMonthlyPrincipalAndInterest(4298.78);
        mBO.setMonthlyTax(0.84);
        mBO.setTotalPayment(4300.44);
		
        logger.info("Adding the mortgage into Memcache");
		ContextListener.getClient().add(Constants.MEMCACHED_MORTGAGE,2000,mBO);
        
        return mBO;
	}
	
	/* Calling Restful WEbservice
	 * @see com.bank.domain.service.CustomerService#callRestFulWebservice(java.lang.Object)
	 */
	@Override
	public void callRestFulWebservice(Object newParam)  throws Exception {
		callRSWithRestTemplate();
		callRSWithHttpURLConnection();
		

	}
	
	/**
	 * Call RS with rest template.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	private void callRSWithRestTemplate()  throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject(
				Constants.REST_WEBSERVICE_URL_RANDOM, Quote.class);
		System.out
				.println("restful service..with callRSWithRestTemplate.............."
						+ quote.getValue());

	}

	/**
	 * Call RS with http URL connection.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	private void callRSWithHttpURLConnection()  throws Exception{
		try {

			URL url = new URL(Constants.REST_WEBSERVICE_URL_STATES);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			StringBuffer sb = new StringBuffer();
			logger.info("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				sb.append(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	
	/* (non-Javadoc)
	 * @see com.bank.domain.service.CustomerService#getcustomers(com.bank.domain.model.Customer)
	 */
	@Override
	public Customer getcustomers(Customer cust) {
		String uniqueKey = UUID.randomUUID().toString();
		cust.setCustomerId(uniqueKey);
		return cust;
	}
	
	
	/* (non-Javadoc)
	 * @see com.bank.domain.service.CustomerService#callLoanWEbservice(com.bank.domain.model.Loan)
	 */
	@Override
	public MortgageBO callLoanWebService(Loan loan) throws Exception {
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
		} catch (NullPointerException e) {

			e.printStackTrace();

		}
		try{
		MortgageHttpGet  mortGet = mortService.getMortgageHttpGet();
		BindingProvider bp = (BindingProvider)mortGet;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://www.webserviceX.NET/");
        logger.info("callLoanWEbservice before webservice method call");
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
