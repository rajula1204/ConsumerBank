package com.bank.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee Not Found") //404
public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = -3332292346834265371L;

	public EmployeeNotFoundException(int id){
		super("EmployeeNotFoundException with id="+id);
	}
}
