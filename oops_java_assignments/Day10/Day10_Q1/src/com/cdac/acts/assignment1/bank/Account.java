package com.cdac.acts.assignment1.bank;

import com.cdac.acts.assignment1.exception.MinBalException;
import com.cdac.acts.assignment1.inter.AccountTypeEnum;
import com.cdac.acts.assignment1.inter.Depositable;
import com.cdac.acts.assignment1.inter.Withdrawable;

public abstract class Account implements Depositable, Withdrawable{
	private static long count = 1000;
	private long accNo;
	private String name;
	private double balance;
	private AccountTypeEnum accType; 
	
	protected Account( String name, double balance,AccountTypeEnum accType) {
		this.accNo = count++;
		this.name = name;
		this.balance = balance;
		this.accType = accType;
	}

	public AccountTypeEnum getAccType() {
		return accType;
	}

	public long getAccNo() {
		return accNo;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public double deposit(double deposit) {
		if(deposit<0) {
			return -1;
		}
		setBalance(getBalance()+deposit);
		return getBalance();
	}
	
	
	@Override
	public double withdraw(double withdraw) throws MinBalException {
		System.out.println(getBalance()+" balance");
		
		if(withdraw>getBalance()) {
			throw new MinBalException("Minimum balance in current Account");
		}
		setBalance(getBalance()-withdraw);
		return getBalance();
	}
	
	
}
