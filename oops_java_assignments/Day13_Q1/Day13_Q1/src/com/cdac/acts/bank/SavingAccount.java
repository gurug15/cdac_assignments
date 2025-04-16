package com.cdac.acts.bank;

import java.time.LocalDate;

public class SavingAccount extends Account{
	
	private final double INTEREST = 3.5;
	public SavingAccount( String accName, LocalDate dateOfOpening, double balance) {
		super(accName, dateOfOpening, balance);
	}
	
	
	
	public void applyInterst() {
		// TODO Auto-generated method stub
		
		super.setBalance(super.getBalance()*1.035);
	}
	
   
}
