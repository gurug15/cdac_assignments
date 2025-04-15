package com.cdac.acts.bank;

import java.time.LocalDate;

import com.cdac.acts.bank.exception.MinBalanceException;
import com.cdac.acts.bank.inter.Depositable;
import com.cdac.acts.bank.inter.Withdrawable;

public class Account implements Withdrawable,Depositable,Comparable<Account>{
 private static Long count = (long) 1000;
 private Long  accNo;
 private String accName;
 private LocalDate dateOfOpening;
 private Double balance;
 
public Account( String accName, LocalDate dateOfOpening, double balance) {
	super();
	this.accNo = count++;
	this.accName = accName;
	this.dateOfOpening = dateOfOpening;
	this.balance = balance;
}

public long getAccNo() {
	return accNo;
}

public String getAccName() {
	return accName;
}

public LocalDate getDateOfOpening() {
	return dateOfOpening;
}

public Double getBalance() {
	return balance;
}


public void setBalance(double balance) {
	this.balance = balance;
}



@Override
public String toString() {
	return "\nAccount [accNo=" + accNo + ", accName=" + accName + ", dateOfOpening=" + dateOfOpening + ", balance="
			+ balance + "]";
}

@Override
public Double deposit(Double amount) throws Exception {
	if(amount<0) {
		throw new Exception("amount is negative");
	}
	
	
	return this.balance;
}

@Override
public Double withdraw(Double amount) throws MinBalanceException {
	// TODO Auto-generated method stub
	return 0.0;
}
@Override
public int compareTo(Account acc) {
	return acc.accNo.compareTo(this.accNo);
}
 
	
}
