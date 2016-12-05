package com.bank.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.domain.model.LoginForm;
import com.bank.util.Constants;




/**
 * Handles requests for the application pages.
 * 
 * @author Pullareddy
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	static String bundle = Constants.CONFIGURATION;
	public static ResourceBundle settings = ResourceBundle.getBundle(bundle);
	
	
	/**
	 * Simply selects the login view to render by returning its name.
	 */
	@RequestMapping(value = Constants.ROOT, method = RequestMethod.GET)
	public String showLogin(Model model, LoginForm loginform) {
		logger.info("Login page");
		if (!model.containsAttribute(Constants.ERROR)) {
			model.addAttribute(Constants.ERROR, false);
		}
		model.addAttribute("loginAttribute", loginform);
		return Constants.LOGIN_PAGE;
	}
	
	/**
	 * The POST method to submit login credentials.
	 * @throws Exception 
	 */
	@RequestMapping(value = Constants.LOGIN_DO, method = RequestMethod.POST)
	public String login(Model model, LoginForm loginform, Locale locale, HttpServletRequest request) throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,locale);
		String formattedDate = dateFormat.format(date);
		
		String username = loginform.getUsername();
		String password = loginform.getPassword();
	
		
		logger.info("Login attempt for username "+ username+" at: "+formattedDate);
		
		// A simple authentication manager
		if(username != null && password != null){
			
			if( username.equals(settings.getString("username")) &&	password.equals(settings.getObject("password")) ){
				// Set a session attribute to check authentication then redirect to the welcome uri; 
				request.getSession().setAttribute("LOGGEDIN_USER", loginform);
				return "redirect:/home";
			}else{
				return "redirect:/login.failed";
			}
		}else{
			return "redirect:/login.failed";
		}
	}
		
	/**
	 * The login failed controller
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login.failed", method = RequestMethod.GET)
	public String loginFailed(Model model, LoginForm loginForm) {
		logger.debug("Showing the login failed page");
		model.addAttribute("error", true);
		model.addAttribute("loginAttribute", loginForm);
		return "login";
	}
	
}
