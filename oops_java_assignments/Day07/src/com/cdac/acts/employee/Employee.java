package com.cdac.acts.employee;

import java.time.LocalDate;
import java.time.Period;

public class Employee {
	private int empNo;
	private String eName;
	private LocalDate join_date,eDOB;
	private Deptenum deptenum;
	
	
	private Employee()
	{}


	public Employee(int empNo, String eName, LocalDate join_date, LocalDate eDOB,Deptenum deptenum) {
		
		this.empNo = empNo;
		this.eName = eName;
		this.join_date = join_date;
		this.eDOB = eDOB;
		this.deptenum = deptenum;
	}


	public int getEmpNo() {
		return empNo;
	}


	public String geteName() {
		return eName;
	}


	public LocalDate getJoin_date() {
		return join_date;
	}


	public LocalDate geteDOB() {
		return eDOB;
	}


	public Deptenum getDeptenum() {
		return deptenum;
	}
	
	public String getGratuty()
	{
		int year = LocalDate.now().getYear() - join_date.getYear();
		if(year>5)
		{
			return "Eligible for Gratuty";
		}
	
		return "Is Not Eligible";
	}

	@Override
	public String toString() {
		return "Employee \n[empNo=" + empNo + ", eName=" + eName + ", join_date=" + join_date + ", eDOB=" + eDOB
				+ ", deptenum=" + deptenum.getValue() + "]";
	}
	
	


	

	


	
	
	
	
	
	
	

}
