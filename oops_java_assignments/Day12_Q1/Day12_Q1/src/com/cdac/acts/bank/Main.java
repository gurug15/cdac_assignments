package com.cdac.acts.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.cdac.acts.bank.exception.DateOfOpeingException;
import com.cdac.acts.dateutils.DateUtils;

public class Main {
	
	private static void addAccount(List<Account> accounts, Scanner sc) {
	
		try {
			System.out.println("Enter Account Details");
			System.out.println("Enter name:");
			String name = sc.next();
			System.out.println("Enter Date in dd-MM-yyyy format:");
			String date = sc.next();
			LocalDate formatDate = DateUtils.stringToDate(date);
			if(LocalDate.now().isBefore(formatDate)) {
				throw new DateOfOpeingException("Date is in Future");
			}
			System.out.println("Enter Balance: ");
			Double balance = sc.nextDouble();
			accounts.add(new Account(name, formatDate,balance));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}	
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Account> accountList = new ArrayList<Account>();
		
		while(true) {
			System.out.println("Enter your choice"
					+ "\n1.		Add Account"
					+ "\n2.		Print all accounts"
					+ "\n3.		Sort by account no desc"
					+ "\n4. 	Sort by accName"
					+ "\n5. 	Sort by Date of opening"
					+ "\n6. 	Sort by balance desc");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addAccount(accountList, sc);
				break;
			case 2:
				accountList.forEach(System.out::println);
				break;
			case 3:
				Collections.sort(accountList);
				break;
			case 4:
				Comparator<Account> nameComparator = new Comparator<Account>() { //anomomous
					
					@Override
					public int compare(Account o1, Account o2) {
						return o1.getAccName().compareTo(o2.getAccName());
					}
				};
				Collections.sort(accountList,nameComparator);
				break;
			case 5:
				Collections.sort(accountList,new Comparator<Account>() {
					@Override
					public int compare(Account a1,Account a2) {
						return a1.getDateOfOpening().compareTo(a2.getDateOfOpening());
					}
				});
				break;
			case 6:
				Collections.sort(accountList,new Comparator<Account>() {
					
					@Override
					public int compare(Account a1,Account a2) {
						return a2.getBalance().compareTo(a1.getBalance());
					}
				});
				break;
			case 0:
				System.out.println("Exiting the menu");
				return;
			default:
				System.err.println("Invalid Choice");
				return;
			}
		}
		
}
}