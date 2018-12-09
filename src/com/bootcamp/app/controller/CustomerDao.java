package com.bootcamp.app.controller;

import java.util.List;

import com.bootcamp.app.model.Customer;

public interface CustomerDao {
	
	String insert (Customer cs ) throws Exception ;
	String delete (Customer cs ) throws Exception ;
	String update(Customer cs) throws Exception ;
	List<Customer> getList() throws Exception;
	List<Customer> LastData() throws Exception;
	
}
