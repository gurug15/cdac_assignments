package com.MobilePhone;

public class MobilePhone {
	private Integer serialNo;
	private String brand;
	private String os;
	private String color;
	private Double price;
	private Integer ram;
	
	public MobilePhone(Integer serialNo, String brand, String os, String color, Double price, Integer ram) {
		super();
		this.serialNo = serialNo;
		this.brand = brand;
		this.os = os;
		this.color = color;
		this.price = price;
		this.ram = ram;
	}
	public Integer getSerialNo() {
		return serialNo;
	}
	public String getBrand() {
		return brand;
	}
	public String getOs() {
		return os;
	}
	public String getColor() {
		return color;
	}
	public Double getPrice() {
		return price;
	}
	public Integer getRam() {
		return ram;
	}
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	@Override
	public String toString() {
		return "\nMobilePhone [serialNo=" + serialNo + ", brand=" + brand + ", os=" + os + ", color=" + color + ", price="
				+ price + ", ram=" + ram + "]";
	}
	

}
