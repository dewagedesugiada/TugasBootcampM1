package com.bootcamp.app.controller;

import java.util.List;

import com.bootcamp.app.model.DBBanking;
import com.bootcamp.app.model.Transaction;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class TransactionDaoImpl implements TransactionDao {

	String message = "" ;
	
	Transaction ac = new Transaction();
	DBBanking ConnDb = new DBBanking();
	Connection connection =  ConnDb.get_connection();
	
	@Override
	public String insert(Transaction tr) throws Exception {
		PreparedStatement ps = null ;
		try {
			String sql = "INSERT INTO transaction VALUES (?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, tr.getIdTransaction());
			ps.setString(2, tr.getType());
			ps.setString(3, tr.getAmount());
			ps.setString(4, tr.getAmountSign());
			ps.setInt(5, tr.getAccountNumber());
			
			ps.executeUpdate();
//			System.out.println(ps);
			return "Successfully.....";
		} catch (Exception e) {
			return "Failed !" ;	
		}
		
	}

	@Override
	public String delete(Transaction tr) throws Exception {
		PreparedStatement ps = null ;
		try {
			String sql = "DELETE FROM transaction where Id_transaction=? ";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, tr.getId());
			ps.executeUpdate() ;
			
			message = "Delete Successfully.." ;
			
		} catch (Exception e) {
			message = "Failed !";
		}
		
		return message;
		
	}

	@Override
	public String update(Transaction tr) throws Exception {
		
		PreparedStatement ps = null ;
		try {
			String sql = "UPDATE transaction set Type=?, Amount=?, Amount_sign=? where Id_transaction=?" ;
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, tr.getType());
			ps.setString(2, tr.getAmount());
			ps.setString(3, tr.getAmountSign());
			ps.setInt(4, tr.getId());
			
			ps.executeUpdate();
//			System.out.println(ps);
			message = "Update Success..." ;
		} catch (Exception e) {
			message = "Update  Failed ! " ;
		}
		
		return message;
	}

	@Override
	public List<Transaction> getList() throws Exception {
		
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM transaction");
		
		List<Transaction> list = new ArrayList<>();
		while(rs.next()) {
			Transaction tr = new Transaction();
			tr.setIdTransaction(rs.getInt("Id_transaction"));
			tr.setType(rs.getString("type"));
			tr.setAmount(rs.getString("Amount"));
			tr.setAmountSign(rs.getString("Amount_sign"));
			tr.setAccountNumber(rs.getInt("Account_number"));
			
			list.add(tr);
		}
		return list;
		
	}

	@Override
	public List<Transaction> LastData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
