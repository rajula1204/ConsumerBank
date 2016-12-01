package com.bank.dao;

public class Loan {

	private int years;
	private double salary;
	private double loanAmount;
	private double annualTax;
	private double annualInsurance;
	
	
	public int getYears() {
		return years;
	}


	public void setYears(int years) {
		this.years = years;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public double getLoanAmount() {
		return loanAmount;
	}


	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}


	public double getAnnualTax() {
		return annualTax;
	}


	public void setAnnualTax(double annualTax) {
		this.annualTax = annualTax;
	}


	public double getAnnualInsurance() {
		return annualInsurance;
	}


	public void setAnnualInsurance(double annualInsurance) {
		this.annualInsurance = annualInsurance;
	}


	public Loan(){}
		
}
