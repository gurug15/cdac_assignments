package com.cdac.acts.account;

import java.time.LocalDate;

public abstract class Account {
	//accountNumber, accountName, dateOfOpening, balcance.
	private static long count = 1000;
	private long accountNumber;
	private String accountName;
	private LocalDate dateOfOpening;
	private double balance;
	
	protected double getBalance() {
		return balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}

	public Account() {
		accountNumber = count++;
	}

	public Account( String accountName, LocalDate dateOfOpening, double balance) {
		this.accountNumber = count++;
		this.accountName = accountName;
		this.dateOfOpening = dateOfOpening;
		this.balance = balance;
	}
	
	public abstract double applyInterest();

	@Override
	public String toString() {
		return "\nAccount [accountNumber=" + accountNumber + ", accountName=" + accountName + ", dateOfOpening="
				+ dateOfOpening + ", balance=" + balance + "]";
	}
	
	
	
	
}
