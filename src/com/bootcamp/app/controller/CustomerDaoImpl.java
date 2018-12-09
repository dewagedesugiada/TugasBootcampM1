package com.bootcamp.app.controller;

import java.util.ArrayList;
import java.util.List;

//import javax.print.DocFlavor.STRING;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bootcamp.app.model.Customer;
import com.bootcamp.app.model.DBBanking;

public class CustomerDaoImpl implements CustomerDao{

String message = "" ;
	
	Customer cs = new Customer();
	DBBanking ConnDB = new DBBanking() ;
	Connection connection = ConnDB.get_connection() ;
	@Override
	public String insert(Customer cs) throws Exception {
		
		PreparedStatement ps =null ;
		try {
			String sql = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?)" ;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cs.getCustomerNumber());
			ps.setString(2, cs.getFirstName());
			ps.setString(3, cs.getLastName());
			ps.setString(4, cs.getBirthDate());
			ps.setString(5, cs.getUsername());
			ps.setString(6, cs.getPassword());
			ps.setString(7, cs.getPhonetype());
			ps.setString(8, cs.getPhoneNumber());
			
			ps.executeUpdate();
			return  "Success..";
			
		} catch (Exception e) {
			return  "Failed !" ;
		}
		
	}
	
	public List<Customer> getList() throws Exception {
		Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from customer");
        
        List<Customer> list = new ArrayList<>();
        
        while (resultSet.next()) {
        		Customer customer = new Customer();
        		customer.setCustomerNumber(resultSet.getInt("CustomerNumber"));
        		customer.setFirstName(resultSet.getString("First_name"));
        		customer.setLastName(resultSet.getString("Last_name"));
        		customer.setBirthDate(resultSet.getString("Birth_date"));
        		customer.setUsername(resultSet.getString("Username"));
        		customer.setPassword(resultSet.getString("Password"));
        		customer.setPhonetype(resultSet.getString("Phone_type"));
        		customer.setPhoneNumber(resultSet.getString("Phone_number"));
        		
        		list.add(customer);
        }
        
        return list;
	}


	
	public String delete(Customer cs) throws Exception {
		PreparedStatement ps = null ;
		try {
			String sql = "DELETE FROM customer where CustomerNumber= ?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cs.getId());
			System.out.println(ps);
			ps.executeUpdate();
			
			message = "Succes..";
		} catch (Exception e) {
			message = "Failed !" ;
		}
		return message;
	}
	
	@Override
	public String update(Customer cs) throws Exception {
		
		PreparedStatement ps = null ;
		try {
			String sql = "UPDATE customer set First_name=? , Last_name=?, Birth_date=?, Username=?, Password=?, Phone_type=?, Phone_number=? where CustomerNumber=?" ;
			ps = connection.prepareStatement(sql);
			ps.setString(1, cs.getFirstName());
			ps.setString(2, cs.getLastName());
			ps.setString(3, cs.getBirthDate());
			ps.setString(4, cs.getUsername());
			ps.setString(5, cs.getPassword());
			ps.setString(6, cs.getPhonetype());
			ps.setString(7, cs.getPhoneNumber());
			ps.setInt(8, cs.getId());
			
			ps.executeUpdate();
			message = "Update Success..." ;
		} catch (Exception e) {
			message = "Update  Failed ! " ;
		}
		
		return message;
	}
	
	
	public List<Customer> LastData() throws Exception {
		Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from customer ");
        
        List<Customer> list = new ArrayList<>();
        
        while (resultSet.next()) {
        		Customer customer = new Customer();
        		customer.setCustomerNumber(resultSet.getInt("CustomerNumber"));
        		customer.setFirstName(resultSet.getString("First_name"));
        		customer.setLastName(resultSet.getString("Last_name"));
        		customer.setBirthDate(resultSet.getString("Birth_date"));
        		customer.setUsername(resultSet.getString("Username"));
        		customer.setPassword(resultSet.getString("Password"));
        		customer.setPhonetype(resultSet.getString("Phone_type"));
        		customer.setPhoneNumber(resultSet.getString("Phone_type"));
        		
        		list.add(customer);
        }
        
        return list;
	}
	
		
}
