package com.cdac.acts.assignment1.inter;

import com.cdac.acts.assignment1.exception.MinBalException;

public interface Withdrawable {

	double withdraw(double d) throws MinBalException;
}
