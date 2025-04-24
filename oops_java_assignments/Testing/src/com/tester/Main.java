package com.tester;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.entity.Person;
import com.filehandling.FileUtil;
import com.utils.MenuMethods;

public class Main {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Person Menu ===");
            System.out.println("1. Add Person");
            System.out.println("2. View All Persons");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Person p = MenuMethods.createPerson(scanner);
                    people.add(p);
                    String message = p.getId() + " " + p.getFirstName()+ " "+p.getPhoneNumber();
                    FileUtil.writeLogs(message);
                    System.out.println("Person added successfully!");
                    break;
                case 2:
                    if (people.isEmpty()) {
                        System.out.println("No persons added yet.");
                    } else {
                        System.out.println("\n--- All Persons ---");
                        for (Person person : people) {
                            System.out.println(person);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

   
}
