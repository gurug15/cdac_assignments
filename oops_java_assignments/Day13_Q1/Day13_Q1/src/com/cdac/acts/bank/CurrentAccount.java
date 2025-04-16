package com.cdac.acts.bank;

import java.time.LocalDate;

public class CurrentAccount extends Account {

	public CurrentAccount(String accName, LocalDate dateOfOpening, double balance) {
		super(accName, dateOfOpening, balance);
	}

}
