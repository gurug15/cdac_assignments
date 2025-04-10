package com.cdac.acts.person;

public class Address {
	private String area;
	private String city;
	private int pincode;
	
	public Address()
	{
		
	}
	
	
	public Address(String area,String city,int pincode)
	{
		this.area=area;
		this.city=city;
		this.pincode=pincode;
		
	}
	
	


	public String getArea() {
		return area;
	}


	public String getCity() {
		return city;
	}


	public int getPincode() {
		return pincode;
	}


//	public void setArea(String area) {
//		this.area = area;
//	}
//
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//
//	public void setPincode(int pincode) {
//		this.pincode = pincode;
//	}


	@Override
	public String toString() {
		return "Address [area=" + area + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
	
	
	
	
	
	
}
