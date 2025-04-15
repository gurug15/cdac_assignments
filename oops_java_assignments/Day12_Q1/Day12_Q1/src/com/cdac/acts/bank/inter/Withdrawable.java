package com.cdac.acts.bank.inter;

import com.cdac.acts.bank.exception.MinBalanceException;

public interface Withdrawable {
	public Double withdraw(Double amount) throws MinBalanceException;
}
