package com.bank.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bank.domain.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "/WEB-INF/spring-servlet.xml"
		
})
public abstract class BaseControllerTestCase {
	private static final Logger logger = LoggerFactory.getLogger(Customer.class);


    @Before
    public void onSetUp() {
    	 System.out.println("Customer controller onSetUP() ");
    }

}
