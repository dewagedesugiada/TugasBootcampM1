package com.bootcamp.app.model;

public class Transaction {
	private int IdTransaction ;
	private String Type ;
	private String Amount ;
	private String AmountSign ;
	private int AccountNumber ;
	private int Id ;
	
	public Transaction() {}
	
	public Transaction(int idtrans, String type, String amount, String amountsign , int accountnumber ) {
		this.IdTransaction = idtrans;
		this.Type = type;
		this.Amount = amount ;
		this.AmountSign = amountsign;
		this.AccountNumber = accountnumber ;
	}

	public Transaction(String type, String amount, String amountsign , int id) {
		this.Type = type;
		this.Amount = amount ;
		this.AmountSign = amountsign;
		this.Id = id ;
	}

	public int getIdTransaction() {
		return IdTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		IdTransaction = idTransaction;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getAmountSign() {
		return AmountSign;
	}

	public void setAmountSign(String amountSign) {
		AmountSign = amountSign;
	}

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	
}
