package com.bootcamp.app.controller;
import java.util.List;
import com.bootcamp.app.model.Transaction;

public interface TransactionDao {

	String insert (Transaction tr ) throws Exception ;
	String delete (Transaction tr ) throws Exception ;
	String update(Transaction tr) throws Exception ;
	List<Transaction> getList() throws Exception;
	List<Transaction> LastData() throws Exception;
	
}
