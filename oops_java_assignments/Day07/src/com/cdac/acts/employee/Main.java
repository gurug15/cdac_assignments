package com.cdac.acts.employee;

import java.time.LocalDate;

public class Main {
	

	public static void main(String[] args) {
		
			Employee emp = new Employee(101,"Guru",
					LocalDate.of(2006, 4, 30),
					LocalDate.of(2001, 8, 20),
					Deptenum.IT);
			System.out.println(emp.getGratuty());
 	}

}
