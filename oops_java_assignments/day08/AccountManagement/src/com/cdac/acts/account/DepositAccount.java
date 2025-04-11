package com.cdac.acts.account;

import java.time.LocalDate;

public class DepositAccount extends Account{

	
	public DepositAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepositAccount(String accountName, LocalDate dateOfOpening, double balance) {
		super(accountName, dateOfOpening, balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Deposit Account ["+super.toString()+"]";
	}
	@Override
	public double applyInterest() {
		setBalance(getBalance()*1.08);
		
		return getBalance();
	}
}
