package com.bootcamp.app.controller;

import java.util.List;

import com.bootcamp.app.model.Account;

public interface AccountDao {
	String insert (Account cs ) throws Exception ;
	String delete (Account cs ) throws Exception ;
	String update(Account cs) throws Exception ;
	List<Account> getList() throws Exception;
	List<Account> LastData() throws Exception;
}
