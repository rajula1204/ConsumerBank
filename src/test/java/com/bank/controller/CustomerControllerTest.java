package com.bank.controller;


import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import com.bank.controller.*;

import com.bank.domain.model.Customer;

public class CustomerControllerTest extends TestCase {
	
	private static final Logger logger = LoggerFactory.getLogger(Customer.class);
	
//   @Autowired
//    private ApplicationContext applicationContext;
//
//    @Autowired
//    private CustomerController controller;
//
//    private MockMvc mockMvc;
    
       
    @Override
	@Before
   public void setUp() {
  //  	mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        logger.info("setUPmethod()");
    }
/*
    @Test
    public void testVisitHome() throws Exception {
    	   	mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(model().attribute(Constants.WELCOME_MESSAGE,
				Constants.WELCOME_MESSAGE_TEXT))
            .andExpect(view().name(Constants.HOME));
    	
    	
    System.out.println("test completed");
	}
  
    */
    @Test
    public void testHandleRequestView() throws Exception{
        CustomerController controller = new CustomerController();
         ModelAndView modelAndView = controller.visitHome();
                
        assertEquals("home", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
    }
    

  
}
