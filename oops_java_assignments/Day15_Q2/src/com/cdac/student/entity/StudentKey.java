package com.cdac.student.entity;

import java.util.Objects;

public class StudentKey  implements Comparable<StudentKey>{
	private Integer standard;
	private String division;
	private Integer rollNo;
	
	
	
	public StudentKey(Integer standard, String division, Integer rollNo) {
		super();
		this.standard = standard;
		this.division = division;
		this.rollNo = rollNo;
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
	public void setStandard(Integer standard) {
		this.standard = standard;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}
	
	@Override
	public String toString() {
		return "[standard=" + standard + ", division=" + division + ", rollNo=" + rollNo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(division, rollNo, standard);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentKey other = (StudentKey) obj;
		return Objects.equals(division, other.division) && Objects.equals(rollNo, other.rollNo)
				&& Objects.equals(standard, other.standard);
	}
	
	@Override
	public int compareTo(StudentKey key) {
		return this.rollNo.compareTo(key.rollNo);
	}
	

	
	
}
