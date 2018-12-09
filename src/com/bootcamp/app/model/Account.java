package com.bootcamp.app.model;

public class Account {
	
	private int AcountNumber ;
	private String OpenDate ;
	private String Balance ;
	private int CustomerNumber ;
	
	public Account() {}
	
	public Account(int accountNumber, String openDate, String balance, int customerNumber ) {
		this.AcountNumber = accountNumber;
		this.OpenDate = openDate;
		this.Balance = balance ;
		this.CustomerNumber = customerNumber ;
	}
	public int getAcountNumber() {
		return AcountNumber;
	}
	public void setAcountNumber(int acountNumber) {
		AcountNumber = acountNumber;
	}
	public String getOpenDate() {
		return OpenDate;
	}
	public void setOpenDate(String openDate) {
		OpenDate = openDate;
	}
	public String getBalance() {
		return Balance;
	}
	public void setBalance(String balance) {
		Balance = balance;
	}
	public int getCustomerNumber() {
		return CustomerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		CustomerNumber = customerNumber;
	}
	
}
