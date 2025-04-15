package com.acts.fruit.entity;

public class Fruit {
  private  String name;
  private String color;
  private double price;
  private int quantity;
  

public Fruit() {
	super();
}

 public Fruit(String name, String color, double price, int quantity) {
	super();
	this.name = name;
	this.color = color;
	this.price = price;
	this.quantity = quantity;
}




public String getName() {
	return name;
}


public String getColor() {
	return color;
}


public double getPrice() {
	return price;
}


public int getQuantity() {
	return quantity;
}


public void setName(String name) {
	this.name = name;
}


public void setColor(String color) {
	this.color = color;
}


public void setPrice(double price) {
	this.price = price;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}


@Override
public String toString() {
	return "Fruit [name=" + name + ", color=" + color + ", price=" + price + ", quantity=" + quantity + "]";
}
  
}
