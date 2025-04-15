package com.cdac.acts.assignment1.bank;


import com.cdac.acts.assignment1.exception.MinBalException;
import com.cdac.acts.assignment1.inter.AccountTypeEnum;
import com.cdac.acts.assignment1.inter.Maturabe;
import com.cdac.acts.assignment1.inter.Withdrawable;

public class SavingAccount extends Account implements Maturabe,Withdrawable {

	
	
	public SavingAccount(String name, double balance,AccountTypeEnum accType) {
		super(name, balance,accType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double withdraw(double withdraw) throws MinBalException {
		if(withdraw<getBalance() || withdraw<0) {
			throw new MinBalException("Minimum balance in current Account");
		}
		super.setBalance(getBalance()-withdraw);
		return getBalance();
	}

	

	@Override
	public double calculateMaturityAmount(double years) {
		double balance = getBalance()*Math.pow((1+SAVING_ACC/100), years);
		super.setBalance(balance);
		System.out.println("here");
		return getBalance();
	}

	
	
	

}
