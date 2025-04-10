package com.acts;
import java.time.LocalDate;
import java.util.Arrays;
//import java.time.LocalDate;
import java.util.Date;

import com.acts.student.Student;
import com.cdac.acts.person.Address;
public class Main {
		
	private static void sortDate(Student sarr[]) {
		if (sarr == null || sarr.length < 2) {
	        return; // No need to sort
	    }
		for(int i=0;i<sarr.length;i++) {
			for(int j=0;j<sarr.length-1-i;j++) {
				boolean x = sarr[j].getDate().isAfter(sarr[j+1].getDate());
				if (x){
					Student temp = sarr[j];
					sarr[j] = sarr[j+1];
					sarr[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//Student stu = new Student("xyz",LocalDate.now());
		//System.out.println(LocalDate.now().toEpochDay());
//		Date todaysDate = new Date(2025, 4, 10);
//		System.out.println(new Date(2021,3,23));
//		if(todaysDate.after(new Date(2025, 4, 9))) {
//			System.out.println("true");
//		}
		Student[] students = new Student[10];
		
				Address addr = new Address("","",41108);
//        // Populate the array with sample data
//        students[0] = new Student("Alice", new Date(2000 - 1900, 0, 15)); // Jan 15, 2000
//        students[1] = new Student("Bob", new Date(1999 - 1900, 1, 20));  // Feb 20, 1999
//        students[2] = new Student("Charlie", new Date(2001 - 1900, 2, 10)); // Mar 10, 2001
//        students[3] = new Student("Diana", new Date(1998 - 1900, 3, 25)); // Apr 25, 1998
//        students[4] = new Student("Evan", new Date(1997 - 1900, 4, 5));  // May 5, 1997
//        students[5] = new Student("Fiona", new Date(2003 - 1900, 5, 18)); // Jun 18, 2003
//        students[6] = new Student("George", new Date(2002 - 1900, 6, 30)); // Jul 30, 2002
//        students[7] = new Student("Hannah", new Date(2001 - 1900, 7, 12)); // Aug 12, 2001
//        students[8] = new Student("Ian", new Date(1996 - 1900, 8, 9));  // Sep 9, 1996
//        students[9] = new Student("Julia", new Date(1995 - 1900, 9, 31)); // Oct 31, 1995
		students[0] = new Student("Alice", LocalDate.of(2000, 1, 15),addr); // Jan 15, 2000
        students[1] = new Student("Bob", LocalDate.of(1999, 2, 20),addr);   // Feb 20, 1999
        students[2] = new Student("Charlie", LocalDate.of(2001, 3, 10),addr); // Mar 10, 2001
        students[3] = new Student("Diana", LocalDate.of(1998, 4, 25),addr); // Apr 25, 1998
        students[4] = new Student("Evan", LocalDate.of(1997, 5, 5),addr);   // May 5, 1997
        students[5] = new Student("Fiona", LocalDate.of(2003, 6, 18),addr); // Jun 18, 2003
        students[6] = new Student("George", LocalDate.of(2002, 7, 30),addr); // Jul 30, 2002
        students[7] = new Student("Hannah", LocalDate.of(2001, 8, 12),addr); // Aug 12, 2001
        students[8] = new Student("Ian", LocalDate.of(1996, 9, 9),addr);    // Sep 9, 1996
        students[9] = new Student("Julia", LocalDate.of(1995, 10, 31),addr);
        
        System.out.println(Arrays.toString(students));
        sortDate(students);
        System.out.println(Arrays.toString(students));
	}
}
