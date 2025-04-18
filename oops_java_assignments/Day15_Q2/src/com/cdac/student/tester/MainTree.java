package com.cdac.student.tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.cdac.student.entity.Student;
import com.cdac.student.entity.StudentKey;
import com.cdac.student.menu.MenuChoices;

public class MainTree {
	
	
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<StudentKey, Student> students = new TreeMap<StudentKey, Student>();
		MenuChoices.DataEntry(students);
		
		while(true) {
			System.out.println("\n________________STUDENT______________");
			System.out.println("\nPress 1 to Add Student");
            System.out.println("Press 2 to Find Student");
            System.out.println("Press 3 to Print All Students");
            System.out.println("Print 4 to edit an element");
            System.out.println("Press 5 to Exit");
            int choice = scanner.nextInt();
            switch (choice) {
			case 1:
				MenuChoices.addStudents(scanner, students);
				break;
			case 2:
				MenuChoices.printStudent(students.get( MenuChoices.findStudent(scanner, students)));
				break;
			case 3:
				MenuChoices.printStudents(students);
				break;
			case 4:
				MenuChoices.editElement(scanner, students);
				break;
			case 5:
				System.out.println("Exiting the Menu.....");
				return;
			default:
				System.err.println("Invlid Choice");
				break;
			}
		}
		
		
		
		
		
		

	}

	

}
