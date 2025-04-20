package com.cdac.acts.jobboard.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.cdac.acts.jobboard.JobSeeker;
import com.cdac.acts.jobboard.util.DegreeEnum;
import com.cdac.acts.jobboard.validation.DateRelatedException;
import com.cdac.acts.jobboard.validation.PhoneNumberValidatoin;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
	        Set<JobSeeker> jobSeekerSet = new HashSet<>();
	        jobSeekerSet.add(new JobSeeker("Alice Johnson", "alice@gmail.com", "alice123", LocalDate.of(1999, 5, 20), LocalDate.of(2021, 6, 30), "9876543210", DegreeEnum.BTECH));
	        jobSeekerSet.add(new JobSeeker("Bob Smith", "bobsmith@yahoo.com", "bobPass", LocalDate.of(1998, 3, 15), LocalDate.of(2020, 7, 1), "9123456789", DegreeEnum.BCA));
	        jobSeekerSet.add(new JobSeeker("Bob Smith", "bobsmith@yahoo.com", "bobPass", LocalDate.of(1998, 3, 15), LocalDate.of(2020, 7, 1), "9123456789", DegreeEnum.BCA));
	        jobSeekerSet.add(new JobSeeker("Bob Smith", "bobsmith@yahoo.com", "bobPass", LocalDate.of(1998, 3, 15), LocalDate.of(2020, 7, 1), "9123456789", DegreeEnum.BCA));
	        jobSeekerSet.add(new JobSeeker("Bob Smith", "bobsmith@yahoo.com", "bobPass", LocalDate.of(1998, 3, 15), LocalDate.of(2020, 7, 1), "9123456789", DegreeEnum.BCA));
	        jobSeekerSet.add(new JobSeeker("Charlie Davis", "charlie.d@gmail.com", "charlie321", LocalDate.of(2000, 8, 10), LocalDate.of(2022, 5, 15), "9988776655", DegreeEnum.MCA));
	        jobSeekerSet.add(new JobSeeker("Diana Prince", "diana.p@gmail.com", "wonderwoman", LocalDate.of(1997, 1, 5), LocalDate.of(2019, 11, 20), "9090909090", DegreeEnum.MCA));
	        jobSeekerSet.add(new JobSeeker("Ethan Wright", "ethan.wright@outlook.com", "ethan@123", LocalDate.of(2001, 2, 28), LocalDate.of(2023, 4, 1), "9001122334", DegreeEnum.BTECH));

	        boolean exit = false;
	        while (!exit) {
	            System.out.println("\n====== Job Seeker Menu ======");
	            System.out.println("1. Add JobSeeker");
	            System.out.println("2. Update Email");
	            System.out.println("3. Get JobSeekers by Degree");
	            System.out.println("4. Sort by Email");
	            System.out.println("5. Sort by DOB");
	            System.out.println("6. Sort by Graduation Date");
	            System.out.println("7. Exit");
	            System.out.print("Enter your choice: ");

	            try {
	                int choice = Integer.parseInt(sc.nextLine());

	                switch (choice) {
	                    case 1 : addUser(sc, jobSeekerSet);
	                    			break;
	                    case 2 : {
	                        try {
	                            updateEmail(sc, jobSeekerSet);
	                        } catch (Exception e) {
	                            System.err.println(e.getMessage());
	                        }
	                    }
	                    break;
	                    case 3 : getDegreeUsers(sc, jobSeekerSet);
	                     	break;
	                    case 4 :sortAsPerEmail(jobSeekerSet);
	                    break;
	                    case 5 :sortAsPerDob(jobSeekerSet);
	                    break;
	                    case 6 :sortAsPerGradDate(jobSeekerSet);
	                    System.out.println(jobSeekerSet);
	                    break;
	                    case 7 : {
	                        System.out.println("Exiting...");
	                        exit = true;
	                    }
	                    break;
	                    default : System.out.println("Invalid choice! Try again.");
	                    break;
	                }
	            } catch (NumberFormatException e) {
	                System.err.println("Please enter a valid number!");
	            }
	        }

	    } catch (Exception e) {
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	    }
		
		
	}
	
	public static void addUser(Scanner sc,Set<JobSeeker> jobseeSet) {
		try {
			System.out.println("Enter JobSeeker Details");
			
			System.out.print("Enter name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter email: ");
	        String email = sc.nextLine();

	        System.out.print("Enter password: ");
	        String password = sc.nextLine();

	        System.out.print("Enter date of birth (yyyy-MM-dd): ");
	        LocalDate dob = LocalDate.parse(sc.nextLine());
	        if(dob.isAfter(LocalDate.now())) {
	        	throw new DateRelatedException("Date of birth is is in future");
	        }

	        System.out.print("Enter graduation date (yyyy-MM-dd): ");
	        LocalDate graduationDate = LocalDate.parse(sc.nextLine());
	        if(LocalDate.now().isBefore(graduationDate)) {
	        	throw new DateRelatedException("Graduation Date is in Future");
	        }
	        

	        String phoneNo;
	        while (true) {
	            System.out.print("Enter phone number (10 digits only): ");
	            phoneNo = sc.nextLine().trim();
	            if (phoneNo.matches("\\d{10}")) {
	                break;  // valid!
	            }
	            throw new PhoneNumberValidatoin("Invalid format. Please enter exactly 10 digits with no other characters.");
	        }

	        System.out.println("Available degrees: " + Arrays.toString(DegreeEnum.values()));
	        System.out.print("Enter degree (e.g. BACHELOR): ");
	        DegreeEnum degree = DegreeEnum.valueOf(sc.nextLine().toUpperCase());
	        
	        JobSeeker js = new JobSeeker(
	                name,
	                email,
	                password,
	                dob,
	                graduationDate,
	                phoneNo,
	                degree
	            );
	        
	        System.out.println("\nCreated JobSeeker:\n" + js);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static void updateEmail(Scanner sc,Set<JobSeeker> jobSeekers) throws Exception{
		System.out.print("Enter Previous  email: ");
        String previousEmail = sc.nextLine().trim();
        System.out.print("Enter new  email: ");
        String newEmail = sc.nextLine();
		for(JobSeeker person: jobSeekers) {
			if(person.getEmail().equals(previousEmail)) {
				person.setEmail(newEmail);
				System.out.println("Email Updated!!");
				return;
			}
		}
		throw new Exception("No email with that emailId");
	}
	
	private static void getDegreeUsers(Scanner sc,Set<JobSeeker> jobSeekers)  {
		System.out.println("Available degrees: " + Arrays.toString(DegreeEnum.values()));
        System.out.print("Enter degree (e.g: BTECH): ");
        DegreeEnum degree = DegreeEnum.valueOf(sc.nextLine().toUpperCase());
        
        
        for(JobSeeker seeker: jobSeekers) {
        	if(degree.equals(seeker.getDegree())) {
        		System.out.println(seeker);
        	}
        }
        
	}
	
	private static void 	sortAsPerEmail(Set<JobSeeker>jobSeekers) {
		List<JobSeeker> jobSeekersList = new ArrayList<JobSeeker>(jobSeekers);
		Collections.sort(jobSeekersList);
		System.out.println("\n--- JobSeekers Sorted by Graduation Date ---");
	    for (JobSeeker js : jobSeekersList) {
	        System.out.println(js);
	    }
	}
	
	private static void 	sortAsPerDob(Set<JobSeeker>jobSeekers) {
		List<JobSeeker> jobSeekersList = new ArrayList<JobSeeker>(jobSeekers);
		Collections.sort(jobSeekersList, new Comparator<JobSeeker>() {
			@Override
			public int compare(JobSeeker j1,JobSeeker j2) {
				return j1.getDob().compareTo(j2.getDob());
			}
		});
		System.out.println("\n--- JobSeekers Sorted by Graduation Date ---");
	    for (JobSeeker js : jobSeekersList) {
	        System.out.println(js);
	    }
	}
	
	private static void 	sortAsPerGradDate(Set<JobSeeker>jobSeekers) {
		List<JobSeeker> jobSeekersList = new ArrayList<JobSeeker>(jobSeekers);
		
		Collections.sort(jobSeekersList, new Comparator<JobSeeker>() {
			@Override
			public int compare(JobSeeker j1,JobSeeker j2) {
				return j1.getGraduationDate().compareTo(j2.getGraduationDate());
			}
		});
		
		System.out.println("\n--- JobSeekers Sorted by Graduation Date ---");
	    for (JobSeeker js : jobSeekersList) {
	        System.out.println(js);
	    }
	}
	

}
