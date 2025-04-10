package com.cdac.acts.person;

import java.time.LocalDate;


public class Person {
	
	private  String addharNo;
	private String name;
	private LocalDate dob;
	private Address addr;
	
	private Person()
	{}

	private Person(String addharNo, String name, LocalDate dob, Address addr) {
		
		this.addharNo = addharNo;
		this.name = name;
		this.dob = dob;
		this.addr = addr;
	}
	
	

	public String getAddharNo() {
		return addharNo;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public Address getAddr() {
		return addr;
	}
	



	@Override
	public String toString() {
		return "Person [addharNo=" + addharNo + ", name=" + name + ", dob=" + dob + ", addr=" + addr + "]";
	}
	
	
	
	
	
	
}
