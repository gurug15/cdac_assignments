package com.cdac.acts.assignment1.bank;


import com.cdac.acts.assignment1.exception.MinBalException;
import com.cdac.acts.assignment1.inter.AccountTypeEnum;
import com.cdac.acts.assignment1.inter.Withdrawable;

public class CurrentAccount extends Account implements Withdrawable {

	
	
	public CurrentAccount(String name, double balance,AccountTypeEnum accType) {
		super(name, balance,accType);
		// TODO Auto-generated constructor stub
	}

	

}
