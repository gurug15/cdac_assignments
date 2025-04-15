package com.cdac.acts.assignment1.inter;

public enum AccountTypeEnum {
	SA("SavingAccount"),
	FD("FixedDeposit"),
	CA("CurrentAccount");
	
	private final String str;
	private AccountTypeEnum(String str) {
		this.str = str;
	}
	
	public String getValue(){
		return str;
	}

}
