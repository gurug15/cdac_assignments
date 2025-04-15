package com.cdac.acts.assignment1.bank;


import com.cdac.acts.assignment1.inter.AccountTypeEnum;
import com.cdac.acts.assignment1.inter.Maturabe;

public class FixedDeposit extends Account implements Maturabe {
	
	public FixedDeposit(String name, double balance,AccountTypeEnum accType) {
		super(name, balance,accType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateMaturityAmount(double years) {
		super.setBalance(getBalance()*Math.pow((1+FIXED_DEPOSIT/100), years));
		
		return getBalance();
	}
	
	
}
