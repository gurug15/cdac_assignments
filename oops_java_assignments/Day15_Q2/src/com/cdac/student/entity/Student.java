package com.cdac.student.entity;

public class Student {
	private StudentKey key;
	private Integer standard;
	private String division;
	private Integer rollNo;
	private String name;
	
	public Student(Integer standard, String division, Integer rollNo, String name) {
		super();
		this.key = new StudentKey(standard, division, rollNo);
		this.standard = standard;
		this.division = division;
		this.rollNo = rollNo;
		this.name = name;
	}
	
	
	
	public StudentKey getKey() {
		return key;
	}



	public Integer getStandard() {
		return standard;
	}



	public String getDivision() {
		return division;
	}



	public Integer getRollNo() {
		return rollNo;
	}



	public String getName() {
		return name;
	}



	public void setKey(StudentKey key) {
		this.key = key;
	}



	public void setStandard(Integer standard) {
		this.standard = standard;
	}



	public void setDivision(String division) {
		this.division = division;
	}



	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Student [standard=" + standard + ", division=" + division + ", rollNo=" + rollNo
				+ ", name=" + name + "]";
	}
	
	
}
