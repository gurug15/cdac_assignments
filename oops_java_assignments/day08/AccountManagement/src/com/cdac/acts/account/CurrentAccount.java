package com.cdac.acts.account;

import java.time.LocalDate;

public class CurrentAccount extends Account {

	
	
	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(String accountName, LocalDate dateOfOpening, double balance) {
		super(accountName, dateOfOpening, balance);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Current Account ["+super.toString()+"]";
	}

	@Override
	public double applyInterest() {
		setBalance(getBalance()*1.01);
		
		return getBalance();
	}
}
