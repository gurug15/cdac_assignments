package com.calc.shape;

public class Circle extends Shape {
    private double radius;
    private final double PI = 3.14;
    
    
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	public void draw() {
		System.out.println("circle:draw");
	}
	public double calculateArea() {
		
		return PI*radius*radius;
		
	}
	public double calculatePerimeter() {
			
		return 2*PI*radius;
	}

}
