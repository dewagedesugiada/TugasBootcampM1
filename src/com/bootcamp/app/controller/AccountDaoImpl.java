package com.bootcamp.app.controller;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import com.bootcamp.app.model.Account;
import com.bootcamp.app.model.DBBanking;
import javax.print.DocFlavor.STRING;
public class AccountDaoImpl implements AccountDao {
	String message = "" ;
	
	Account ac = new Account();
	DBBanking ConnDb = new DBBanking();
	Connection connection =  ConnDb.get_connection();
	@Override
	public String insert(Account ac) throws Exception {
		PreparedStatement ps = null ;
		try {
			String sql = "INSERT INTO account VALUES (?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ac.getAcountNumber());
			ps.setString(2, ac.getOpenDate());
			ps.setString(3, ac.getBalance());
			ps.setInt(4, ac.getCustomerNumber());
			
			ps.executeUpdate();
//			System.out.println(ps);
			return "Successfully.....";
		} catch (Exception e) {
			return "Failed !" ;	
		}
	}
	@Override
	public String delete(Account ac) throws Exception {
		PreparedStatement ps = null ;
		try {
			String sql = "DELETE FROM account where Account_number=? ";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ac.getId());
			ps.executeUpdate() ;
			
			message = "Delete Successfully.." ;
			
		} catch (Exception e) {
			message = "Failed !";
		}
		
		return message;
	}
	@Override
	public String update(Account ac) throws Exception {
		PreparedStatement ps = null ;
		try {
			String sql = "UPDATE account set Balance=? where Account_number=?" ;
			ps = connection.prepareStatement(sql);
			ps.setString(1, ac.getBalance());
			ps.setInt(2, ac.getId());
			
			ps.executeUpdate();
			message = "Update Success..." ;
		} catch (Exception e) {
			message = "Update  Failed ! " ;
		}
		
		return message;
	}
	@Override
	public List<Account> getList() throws Exception {
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM account");
		
		List<Account> list = new ArrayList<>();
		while(rs.next()) {
			Account ac = new Account();
			ac.setAcountNumber(rs.getInt("Account_number"));
			ac.setOpenDate(rs.getString("Open_date"));
			ac.setBalance(rs.getString("Balance"));
			ac.setCustomerNumber(rs.getInt("CustomerNumber"));
			
			list.add(ac);
		}
		return list;
	}
	@Override
	public List<Account> LastData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
