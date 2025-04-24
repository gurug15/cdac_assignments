package com.utils;

import java.util.Scanner;

import com.entity.Person;

public class MenuMethods {

	private MenuMethods() {}
	 public static Person createPerson(Scanner scanner) {
	        System.out.print("Enter ID: ");
	        Long id = scanner.nextLong();
	        scanner.nextLine();

	        System.out.print("Enter First Name: ");
	        String firstName = scanner.nextLine();

	        System.out.print("Enter Last Name: ");
	        String lastName = scanner.nextLine();

	        System.out.print("Enter Email: ");
	        String email = scanner.nextLine();

	        System.out.print("Enter Phone Number: ");
	        String phoneNumber = scanner.nextLine();

	        System.out.print("Enter Age: ");
	        int age = scanner.nextInt();
	        scanner.nextLine();

	        System.out.print("Enter Address: ");
	        String address = scanner.nextLine();

	        return new Person(id, firstName, lastName, email, phoneNumber, age, address);
	    }
}
