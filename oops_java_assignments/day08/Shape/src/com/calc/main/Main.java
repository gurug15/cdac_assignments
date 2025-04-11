package com.calc.main;

import java.util.Scanner;

import com.calc.shape.Circle;
import com.calc.shape.Rectangle;
import com.calc.shape.Shape;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Shape shape = null; // Shape reference

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Circle");
            System.out.println("2. Create Rectangle");
            System.out.println("3. Display Area");
            System.out.println("4. Display Perimeter");
            System.out.println("5. Draw Circle (requires downcasting)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Create Circle
                    System.out.print("Enter radius of the circle: ");
                    double radius = sc.nextDouble();
                    shape = new Circle(radius); // Upcasting
                    System.out.println("Circle created successfully.");
                    break;

                case 2: // Create Rectangle
                    System.out.print("Enter length of the rectangle: ");
                    double length = sc.nextDouble();
                    System.out.print("Enter width of the rectangle: ");
                    double width = sc.nextDouble();
                    shape = new Rectangle(length, width); // Upcasting
                    System.out.println("Rectangle created successfully.");
                    break;

                case 3: // Display Area
                    if (shape != null) {
                        System.out.println("Area: " + shape.calculateArea());
                    } else {
                        System.out.println("No shape created yet.");
                    }
                    break;

                case 4: // Display Perimeter
                    if (shape != null) {
                        System.out.println("Perimeter: " + shape.calculatePerimeter());
                    } else {
                        System.out.println("No shape created yet.");
                    }
                    break;

                case 5: // Draw Circle (Downcasting required)
                    if (shape instanceof Circle) {
                        Circle circle = (Circle) shape; // Downcasting
                        circle.draw();
                    } else {
                        System.out.println("The current shape is not a circle.");
                    }
                    break;

                case 6: // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
  
		//sc.close();
	}

}
