package com.cdac.acts.jobboard;

import java.time.LocalDate;
import java.util.Objects;

import com.cdac.acts.jobboard.util.DegreeEnum;

public class JobSeeker  implements Comparable<JobSeeker>{
	private static int count = 123;
	private int registrationId;
	private String name;
	private String email;
	private String password;
	private LocalDate dob;
	private LocalDate graduationDate;
	private String phoneNo;
	private DegreeEnum degree;
	
	
	public JobSeeker( String name, String email, String password, LocalDate dob,
			LocalDate graduationDate, String phoneNo, DegreeEnum degree) {
		super();
		this.registrationId = count+=2;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.graduationDate = graduationDate;
		this.phoneNo = phoneNo;
		this.degree = degree;
	}
	
	


	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public int getRegistrationId() {
		return registrationId;
	}




	public String getName() {
		return name;
	}




	public String getPassword() {
		return password;
	}




	public LocalDate getDob() {
		return dob;
	}




	public LocalDate getGraduationDate() {
		return graduationDate;
	}




	public String getPhoneNo() {
		return phoneNo;
	}




	public DegreeEnum getDegree() {
		return degree;
	}




	@Override
	public String toString() {
		return "\nJobSeeker [registrationId=" + registrationId + ", name=" + name + ", email=" + email + ", password="
				+ "********" + ", dob=" + dob + ", graduationDate=" + graduationDate + ", phoneNo=" + phoneNo
				+ ", degree=" + degree + "]";
	}
	
	@Override
	public int compareTo(JobSeeker J) {
		return this.email.compareTo(J.email);
	}




//	@Override
//	public int hashCode() {
//		return Objects.hash(degree, dob, email, graduationDate, name, password, phoneNo, registrationId);
//	}
//
//
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		JobSeeker other = (JobSeeker) obj;
//		return degree == other.degree && Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
//				&& Objects.equals(graduationDate, other.graduationDate) && Objects.equals(name, other.name)
//				&& Objects.equals(password, other.password) && Objects.equals(phoneNo, other.phoneNo)
//				&& registrationId == other.registrationId;
//	}
	
	

}
