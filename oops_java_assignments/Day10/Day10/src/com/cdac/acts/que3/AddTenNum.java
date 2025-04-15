package com.cdac.acts.que3;

import java.util.ArrayList;
import java.util.Scanner;

public class AddTenNum {

	public static void main(String[] args) {
		ArrayList<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Accepting 10 double numbers from the user
        int count = 0;
        do {
            System.out.println("Enter a double number:");
            double num = scanner.nextDouble();
            numbers.add(num);
            count++; 
        } while (count < 10);

        // Calculating the sum of all numbers
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }

        // Printing the sum
        System.out.println("The sum of all numbers is: " + sum);

        // Demonstrating indexOf and lastIndexOf
        System.out.println("Enter a number to find its index:");
        double findNum = scanner.nextDouble();

        int firstIndex = numbers.indexOf(findNum);
        int lastIndex = numbers.lastIndexOf(findNum);

        System.out.println("First index of the number: " + firstIndex);
        System.out.println("Last index of the number: " + lastIndex);

        scanner.close();
	}

}
