package com.bank.handler;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bank.domain.model.LoginForm;
import com.bank.util.Constants;



/**
 * The Authentication Interceptor class. This class implements the spring HandlerInteceptor
 * to processing requests into three steps:<br>
 * - pre-handle<br>
 * - post-handle<br>
 * - after-completition
 * 
 * @see org.springframework.web.servlet.HandlerInterceptor
 * @author pullareddy
 * 
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);
	static String bundle = Constants.CONFIGURATION;
	public static ResourceBundle settings = ResourceBundle.getBundle(bundle);

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {

		logger.info("Interceptor: Pre-handle");

		// Avoid a redirect loop for some urls  ConsumerBank
		
		String uri =request.getRequestURI();
		logger.info("getRequestURI....................:"+uri);
		if( !request.getRequestURI().equals("/ConsumerBank/") &&
		    !request.getRequestURI().equals("/ConsumerBank/login.do") &&
		    !request.getRequestURI().equals("/ConsumerBank/login.failed"))
		  {

			LoginForm userData = (LoginForm) request.getSession().getAttribute(Constants.LOGGEDIN_USER);

		   if(userData == null)
		   {

		    response.sendRedirect("/ConsumerBank/");

		    return false;
		   }   
		  }
			  return true;
}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("Post-handle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("After-completion");
	}

}
