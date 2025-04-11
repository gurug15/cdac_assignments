package com.cdac.acts.Main;

import java.time.LocalDate;
import java.util.Scanner;

import com.cdac.acts.account.Account;
import com.cdac.acts.account.CurrentAccount;
import com.cdac.acts.account.DepositAccount;
import com.cdac.acts.account.SavingAccount;
import com.cdac.acts.date.util.DateUtil;

public class Main {
	
	private static void createSavingAccount(Scanner sc,Account arr[],int count) {
		System.out.println("Enter Saving Account Details");
		System.out.print("Enter Account Name: ");
		String name = sc.next();
		System.out.print("Enter Date of Opening in format dd/MM/yyyy/: ");
		String textDate = sc.next();
		LocalDate date = DateUtil.textToDate(textDate,DateUtil.DD_MM_YYYY);
		System.out.print("Enter your Balance: ");
		double bal = sc.nextDouble();
		arr[count] = new SavingAccount(name,date,bal);
		
	}
	private static void createDepositAccount(Scanner sc,Account arr[],int count) {
		System.out.println("Enter Deposit Account Details");
		System.out.print("Enter Account Name: ");
		String name = sc.next();
		System.out.print("Enter Date of Opening in format dd/MM/yyyy/: ");
		String textDate = sc.next();
		LocalDate date = DateUtil.textToDate(textDate,DateUtil.DD_MM_YYYY);
		System.out.print("Enter your Balance: ");
		double bal = sc.nextDouble();
		arr[count] = new DepositAccount(name,date,bal);
		
	}
	private static void createCurrentAccount(Scanner sc,Account arr[],int count) {
		System.out.println("Enter Current Account Details");
		System.out.print("Enter Account Name: ");
		String name = sc.next();
		System.out.print("Enter Date of Opening in format dd/MM/yyyy/: ");
		String textDate = sc.next();
		LocalDate date = DateUtil.textToDate(textDate,DateUtil.DD_MM_YYYY);
		System.out.print("Enter your Balance: ");
		double bal = sc.nextDouble();
		arr[count] = new CurrentAccount(name,date,bal);
		
	}
	
	public static void ApplyInterst(Scanner sc,Account acc[],int count) {
		System.out.println("Enter account No to apply interest on:");
		long accNo = sc.nextLong();
		for(int i=0;i<count;i++) {
			
			if(acc[i].getAccountNumber() == accNo) {
				acc[i].applyInterest();		
				System.out.println(acc[i]);
				}
		}
		System.out.println("Interest applied Succesfully");
	}
	
	public static void printAccounts(Account acc[],int count) {
		for(Account a:acc) {
			if(a ==null) {
				return;
			}
			System.out.println(a);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account account[] = new Account[50];
		int count =0;
		while(true) {
			System.out.println("\nAccount Management System"
					+ "\n1.Create Saving Account"
					+ "\n2.Create Deposit Account"
					+ "\n3.Create Current Account"
					+ "\n4.Show All Accounts"
					+ "\n5.Apply Interest"
					+ "\n0.Exit the Menu"
					+ "\nEnter your Choice");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				createSavingAccount(sc, account, count);
				count++;
				break;
			case 2:
				createDepositAccount(sc, account, count);
				count++;
				break;
			case 3:
				createCurrentAccount(sc, account, count);
				count++;
				break;
			case 4:
//				System.out.println(Arrays.toString(account));
				printAccounts(account, count);
				break;
			case 5:
				ApplyInterst(sc, account, count);
				break;
			case 0:
				System.out.println("Exiting the Menu");
				return;
			default:
				System.out.println("Invalid input Exiting the menu");
				return;
			}
		
		}
		
		//sc.close();
	}

}
