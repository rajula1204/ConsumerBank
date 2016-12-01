package com.loan.controller;

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
import java.util.Random;
import java.util.UUID;

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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.bank.dao.Customer;
import com.bank.dao.Quote;
import com.bank.dao.StaticStates;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Pullareddyr
 * 1. Implemented SLF4J log files
 * 2. Implemented Validations using Manual and Annotated. Still need to apply for few fields 
 * 3. Used Maven tool to build the application
 * 4. Interceptors are under constructions, facing issue with configuration files.
 * 5. Java configuration(no xml) is written but not tested yet. would like to test it finally. 
 * 6.Successfully converted the Json to java objects
 * 7. Successfully consumed the rest web services to load states in the dropdown box. however json output array format
 *   is little bit diffrent (callRestFulWebservice()), unable to convert into java object, 
 *   for time being, stored same json output in local system with little modifications and reading data.
 * 8.Successfully created customer identification number and pinNumber. 
 * 9. Unit Test cases under construction
 * 10. Memcache implemented. need to test thoroughly
 *           
 */

@RestController
public class CustomerController {
	private static final Logger logger = LoggerFactory
			.getLogger(CustomerController.class);

	Map<UUID, Object> map = new HashMap<UUID, Object>();
	Map<String, String> stateMap = new HashMap<String, String>();
	Random r = new Random();

	@Autowired
	@Qualifier("customerValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping("/")
	public ModelAndView visitHome() {
		logger.info(" visitHome method");
		return new ModelAndView("home", "welcomeMessage",
				"WelCome to Consumer Bank");
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView customerWelcomePage() {
		callRestFulWebservice(null);

		Map<String, String> list = getStates();
		ModelAndView model = new ModelAndView("welcomepage");
		model.addObject("stateList", list);
		model.addObject("command", new Customer());

		return model;
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveCustomerDetails(
			@Valid @ModelAttribute("command") Customer customer,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("welcomepage");
			model.addObject("command", customer);
			Map<String, String> list = getStates();
			model.addObject("stateList", list);
			return model;
		}
		customer = getcustomers(customer);
		customer = getPinNumber(customer);
		ModelAndView model = new ModelAndView("viewcustomers");
		model.addObject("customerBO", customer);
		return model;
	}

	private Customer getPinNumber(Customer customer) {
		String val = "" + ((int) (Math.random() * 9000) + 1000);
		customer.setPinNumber(val);
		return customer;
	}

	/*
	 * Called the webservice and created data into local json file for reuse.
	 * The data we get from the webservice is not in valid format. Created
	 * temporary json file.
	 */
	
	private Map<String, String> getStates() {

		List<StaticStates> list = null;
		Map<String, String> map = null;
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			list = objectMapper.readValue(
					new File("C:\\rajula\\st.json"),
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

		return map;
	}
        
	private void callRestFulWebservice(Object newParam) {
		// callRSWithRestTemplate();
		// callRSWithHttpURLConnection();
		

	}
	
	private void callRSWithRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject(
				"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		System.out
				.println("restful service..with callRSWithRestTemplate.............."
						+ quote.getValue());

	}

	private void callRSWithHttpURLConnection() {
		try {

			URL url = new URL("http://services.groupkt.com/state/get/USA/all");
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
			System.out.println("Output from Server .... \n");
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

	
	private Customer getcustomers(Customer cust) {
		String uniqueKey = UUID.randomUUID().toString();
		cust.setCustomerId(uniqueKey);

		return cust;
	}

}
