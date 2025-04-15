package com.acts.fruit.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.acts.fruit.entity.Fruit;

public class Main {

	public static void main(String[] args) {
		List<Fruit> fruitList = new ArrayList<Fruit>();
		Scanner sc = new Scanner(System.in);
		
		
	try {
		while(true) {
			System.out.println("1.Enter Fruit"
					+ "\n2.Remove Fruit add index"
					+ "\n3.showFruits"
					+ "\n4.exit"
					+ "\nEnter your choice");
			int choice  = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Please enter the following details:");
				System.out.print("Enter Name: ");
				String name = sc.next();
				System.out.print("Enter Color: ");
				String color = sc.next();
				System.out.print("Enter Price: ");
				double price = sc.nextDouble();
				System.out.print("Enter Quantity: ");
				int quantity = sc.nextInt();
				fruitList.add(new Fruit(name,color,price,quantity));
				break;
			case 2:
				System.out.print("Enter Index: ");
				int index = sc.nextInt();
				fruitList.remove(index);
				break;
			case 3:
				 System.out.println("Fruits before removal:");
			        for (Fruit fruit : fruitList) {
			            System.out.println(fruit);
			        }
			        break;
			case 4:
				System.out.println("Exixing ....");
				return;
				default:
					System.out.println("invalid args");
			}
			}
	} catch (Exception e) {
		System.out.println("Exception occuting");
	}

	}

}
