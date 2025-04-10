package com.cdac.acts.person;

import java.time.LocalDate;

public class Main {
	
	private static String ageCal(LocalDate dob)
	{
		int age = LocalDate.now().getYear() - dob.getYear();
		if (age>100) {
			return "Age above 100";
		}
		
		return "Age below 100";
		
	}
	private static String bornBefore(LocalDate dob)
	{
		 
		if (LocalDate.of(1947, 8, 15).isBefore(dob)) {
			return "yes Born before 15 Aug 1947";
		}
		
		return "No";
		
	}

	public static void main(String[] args) {
		LocalDate dob = LocalDate.parse("1920-08-17");
		System.out.println(bornBefore(dob));
		System.out.println(ageCal(dob));

	}

}
