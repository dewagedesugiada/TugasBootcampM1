package com.bootcamp.app.controller;

import java.util.List;
import com.bootcamp.app.model.Account;

public interface AccountDao {
	String insert (Account ac ) throws Exception ;
	String delete (Account ac ) throws Exception ;
	String update(Account ac) throws Exception ;
	List<Account> getList() throws Exception;
	List<Account> LastData() throws Exception;
}
