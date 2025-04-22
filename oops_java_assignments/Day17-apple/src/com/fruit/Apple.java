package com.fruit;

import java.util.Objects;

public class Apple implements Comparable<Apple> {
    private double weight;
    private int quantity;
    private String color;
    private String taste;

    // Parameterized Constructor
    public Apple(double weight, int quantity, String color, String taste) {
        this.weight = weight;
        this.quantity = quantity;
        this.color = color;
        this.taste = taste;
    }

    // Getters
    public double getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getColor() {
        return color;
    }

    public String getTaste() {
        return taste;
    }

    // Setters
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apple other = (Apple) obj;
		return Objects.equals(color, other.color) && quantity == other.quantity && Objects.equals(taste, other.taste)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

	public void setTaste(String taste) {
        this.taste = taste;
    }

    // toString override
    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", quantity=" + quantity +
                ", color='" + color + '\'' +
                ", taste='" + taste + '\'' +
                '}';
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(color, quantity, taste, weight);
	}
    

    // Comparable implementation (compare by weight only)
    @Override
    public int compareTo(Apple other) {
        return Double.compare(this.weight, other.weight);
    }
}
