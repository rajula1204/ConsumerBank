package com.bank.util;


public interface Constants {
	//jsp mapping files
	public static final String HOME = "home";
	public static final String WELCOME_MESSAGE = "welcomeMessage";
	public static final String WELCOME_PAGE = "customerpage";
	public static final String VIEW_CUSTOMER_PAGE = "viewcustomers";
	public static final String LOAN_INFORMATION_PAGE = "loanInformation";
	public static final String LOGIN_PAGE = "login";
	public static final String LOAN_DETAILS = "loandetail";
	
	//RequestMappings
	public static final String CUSTOMER_VALIDATOR = "customerValidator";
	public static final String HOME_REQUEST = "/home";
	public static final String HELLO ="/hello";
	public static final String SAVE = "/save";
	public static final String ROOT = "/";
	public static final String VALIDATE_CUSTOMER = "/validatecustomer";
	
	public static final String LOGIN_DO = "/login.do";
	//FormBeans to jsps
	public static final String STATE_LIST = "stateList";
	public static final String COMMAND = "command";
	public static final String CUSTOMER_BO = "customerBO";
	public static final String MORTGAGE = "mortgage";
	public static final String LOAN = "loan";
	public static final String SPACE = "";
	//WebServices
	public static final String REST_WEBSERVICE_URL_RANDOM = "http://gturnquist-quoters.cfapps.io/api/random";
	public static final String REST_WEBSERVICE_URL_STATES = "http://services.groupkt.com/state/get/USA/all";
	//Text to display
	public static final String WELCOME_MESSAGE_TEXT = "WelCome to Consumer Bank";
	public static final String CONFIGURATION = "configuration";
	public static final String LOGGEDIN_USER = "LOGGEDIN_USER";
	public static final String ERROR = "error";

    // files
	public static final String JSON_LOCAL_FILE = "C:\\rajula\\st.json"; //find the file in com/bank/controller folder
	
	

}
