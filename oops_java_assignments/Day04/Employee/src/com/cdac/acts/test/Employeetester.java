package com.cdac.acts.test;
import java.util.Scanner;
import com.cdac.acts.Employee;

public class Employeetester {
    
   
    

    public static void main(String[] args) {
    	Employee[] employees = new Employee[100];
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Employees");
            System.out.println("2. Print Employee by EMP ID");
            System.out.println("3. Print All Employees Sorted by SALARY ");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(scanner,employees,count);
                    count++;
                    break;
                case 2:
                    printEmployeeByEmpId(scanner,employees,count);
                    break;
                case 3:
                    printAllEmployeesSortedBySal(scanner,employees,count);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addEmployee(Scanner scanner,Employee students[],int count ) {
        System.out.print("Enter EMP ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter SALARY: ");
        int sal = scanner.nextInt();

        students[count] = new Employee(empId, name, sal);
        System.out.println("Student added successfully!");
    }

    private static void printEmployeeByEmpId(Scanner scanner,Employee employees[],int count ) {
        System.out.print("Enter Roll No: ");
        int searchempId = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (employees[i].empId == searchempId) {
                System.out.println(employees[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found!");
        }
    }

    private static void printAllEmployeesSortedBySal(Scanner scanner,Employee employees[],int count ) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (employees[j].sal < employees[j + 1].sal) {
                    Employee temp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = temp;
                }
            }
        }

        System.out.println("Employees sorted by SALARY:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }
}