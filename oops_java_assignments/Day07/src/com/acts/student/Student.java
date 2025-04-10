package com.acts.student;

import java.time.LocalDate;
import com.acts.student.CourseEnum;
import com.cdac.acts.person.Address;


public class Student {
	private static int count = 0;
	private String name;
	private int rollNo;
	//private CourseEnum courseEnum;
	private LocalDate dob;
	private Address address;
	
	
	public Student() {
		rollNo = count++;
	}
	public Student(String name,LocalDate dob,Address addr) {
		this.dob =dob;
		this.name = name;
		this.rollNo = count++;
		this.address = addr;
	}
	
	public LocalDate getDate() {
		return dob; 
	}
	
	
	@Override
	public String toString() {
		return "\nStudent [name=" + name + ", rollNo=" + rollNo + ", dob=" + dob + ", address=" + address + "]";
	}
	
	
   
}
