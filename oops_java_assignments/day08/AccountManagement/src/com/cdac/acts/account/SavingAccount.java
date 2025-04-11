package com.cdac.acts.account;

import java.time.LocalDate;

public class SavingAccount extends Account {
	
	
	
	
	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(String accountName, LocalDate dateOfOpening, double balance) {
		super(accountName, dateOfOpening, balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SavingAccount ["+super.toString()+"]";
	}

	@Override
	public double applyInterest() {
		setBalance(getBalance()*1.03);
		
		return getBalance();
	}

}
