package com.cdac.student.menu;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.cdac.student.entity.Student;
import com.cdac.student.entity.StudentKey;

public class MenuChoices {
	
	private MenuChoices() {
		
	}
	
	public static void addStudents(Scanner scanner,Map<StudentKey, Student> students) {
		

        // Input for StudentKey fields
        System.out.println("Enter standard: ");
        Integer standard = scanner.nextInt();

        System.out.println("Enter division: ");
        String division = scanner.next();

        System.out.println("Enter roll number: ");
        Integer rollNo = scanner.nextInt();
        
        // Input for Student fields
        System.out.println("Enter name: ");
        String name = scanner.next();

        // Create Student object
       Student s1 = new Student(standard, division, rollNo, name);
       students.put(s1.getKey(), s1);
	}
	
	public static StudentKey findStudent(Scanner sc,Map<StudentKey,Student> students) {
	
		System.out.println("Enter standard: ");
        Integer standard = sc.nextInt();

        System.out.println("Enter division: ");
        String division = sc.next();

        System.out.println("Enter roll number: ");
        Integer rollNo = sc.nextInt();
		
		
		for(StudentKey key : students.keySet()) {
			
			if(key.getStandard().equals(standard) && key.getDivision().equals(division) && key.getRollNo().equals(rollNo)) {
				return key;
			}
			
		}
		
		return null;
		
	}
	
	public static void DataEntry(Map<StudentKey,Student> students) {
		 Student stu = new Student(10, "A", 1, "Rahul");
		 students.put(stu.getKey(), stu);
	      
		 	stu = new Student(10, "A", 2, "Priya");
	        students.put(stu.getKey(), stu);

	        stu = new Student(10, "B", 1, "Arjun");
	        students.put(stu.getKey(), stu);

	        stu = new Student(10, "B", 2, "Meera");
	        students.put(stu.getKey(), stu);

	        stu = new Student(11, "A", 3, "Ananya");
	        students.put(stu.getKey(), stu);

	        stu = new Student(11, "A", 1, "Kunal");
	        students.put(stu.getKey(), stu);

	        stu = new Student(11, "B", 4, "Shreya");
	        students.put(stu.getKey(), stu);

	        stu = new Student(11, "B", 5, "Varun");
	        students.put(stu.getKey(), stu);

	        stu = new Student(12, "A", 6, "Aditi");
	        students.put(stu.getKey(), stu);

	        stu = new Student(12, "A", 8, "Rohan");
	        students.put(stu.getKey(), stu);

//	        StudentKey key10 = new StudentKey(12, "A", 2);
//	        students.put(key10, new Student(key10, 12, "A", 2, "Rohan"));
//	      
//	        
//	        StudentKey key11 = new StudentKey(12, "A", 2);
//	        students.put(key11, new Student(key11, 12, "A", 2, "Rohan"));
	}
	
	
	public static void printStudents(Map<StudentKey,Student> students) {
		System.out.printf("%-95s  %-100s ","Key","Value");
		for(Map.Entry<StudentKey, Student> entry: students.entrySet()) {
			
			System.out.printf("\n%-70s  %-100s ",entry.getKey(),entry.getValue());
		}
	}
	public static void printStudent(Student student) {	
			System.out.printf("\n%-70s  %-100s ",student.getKey(),student);
		
	}
	
	public static void editElement(Scanner sc,Map<StudentKey,Student> students) {
		StudentKey key = findStudent(sc, students);
		//Student stu = students.get(key);
		key.setDivision("B");
		

		
		//stu.setDivision("B");
		System.out.println("changed Divison");
	}

}
