package com.cdac.acts.test;
import java.util.Scanner;
import com.cdac.acts.Student;

public class Studenttester {
    
   
    

    public static void main(String[] args) {
    	Student[] students = new Student[100];
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Print Student by Roll No");
            System.out.println("3. Print All Students Sorted by Marks");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner,students,count);
                    count++;
                    break;
                case 2:
                    printStudentByRollNo(scanner,students,count);
                    break;
                case 3:
                    printAllStudentsSortedByMarks(students,count);
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

    private static void addStudent(Scanner scanner,Student students[],int count ) {
        System.out.print("Enter Roll No: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        int marks = scanner.nextInt();

        students[count] = new Student(rollNo, name, marks);
        System.out.println("Student added successfully!");
    }

    private static void printStudentByRollNo(Scanner scanner,Student students[],int count ) {
        System.out.print("Enter Roll No: ");
        int searchRollNo = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (students[i].rollNo == searchRollNo) {
                System.out.println(students[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    private static void printAllStudentsSortedByMarks(Student students[],int count ) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].marks < students[j + 1].marks) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("Students sorted by marks:");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }
}