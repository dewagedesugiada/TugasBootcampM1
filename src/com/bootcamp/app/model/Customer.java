package com.bootcamp.app.model;

public class Customer {
	private int Id ;
	private int CustomerNumber ;
	private String FirstName ;
	private String LastName ;
	private String getBirthDate;
	private String Username;
	private String Password ;
	private String Phonetype ;
	private String PhoneNumber ;
	
	
	public Customer() {}
	public Customer(int customernumber, String firstname, String lastname, String birthdate, String username, String password , String phonetype, String phonenumber) {
		this.CustomerNumber = customernumber ;
		this.FirstName = firstname ;
		this.LastName = lastname ;
		this.getBirthDate = birthdate ;
		this.Username = username ;
		this.Password = password ;
		this.Phonetype = phonetype ;
		this.PhoneNumber = phonenumber ;
	}
	
//	public Customer(int id) { 
//		this.Id = id ;
//	}
	
	public Customer(String firstname, String lastname, String birthdate, String username, String password , String phonetype, String phonenumber, int id) {
		this.FirstName = firstname ;
		this.LastName = lastname ;
		this.getBirthDate = birthdate ;
		this.Username = username ;
		this.Password = password ;
		this.Phonetype = phonetype ;
		this.PhoneNumber = phonenumber ;
		this.Id = id ;
	}
	public int getCustomerNumber() {
		return CustomerNumber;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setCustomerNumber(int customerNumber) {
		CustomerNumber = customerNumber;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getBirthDate() {
		return getBirthDate;
	}
	public void setBirthDate(String getbirthDate) {
		getBirthDate = getbirthDate;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPhonetype() {
		return Phonetype;
	}
	public void setPhonetype(String phonetype) {
		Phonetype = phonetype;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

}
