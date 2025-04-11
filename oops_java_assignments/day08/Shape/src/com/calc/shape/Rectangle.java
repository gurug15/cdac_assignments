package com.calc.shape;

public class Rectangle extends Shape {
	private double len;
	private double wid;
	
	
	public Rectangle(double len, double wid) {
		super();
		this.len = len;
		this.wid = wid;
	}
	public double calculateArea() {
		return len*wid;
	}
	 public  double calculatePerimeter() {
		 return 2*(len+wid);
	 }

}
