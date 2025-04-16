package com.cdac.acts.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cdac.acts.bank.exception.AccountNotFoundException;
import com.cdac.acts.bank.exception.DateOfOpeingException;
import com.cdac.acts.bank.exception.MinBalanceException;
import com.cdac.acts.dateutils.DateUtils;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Account> accountList = new CopyOnWriteArrayList<Account>();
		try {
		while(true) {
			System.out.println("Enter your choice"
					+ "\n1.	Add Account"
					+ "\n2.	Print all accounts"
					+ "\n3.	Print Account Details"
					+ "\n4. 	Transfer Funds"
					+ "\n5. 	Rmove Account"
					+ "\n6. 	Apply Interst");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addAccount(accountList, sc);
				break;
			case 2:
				printAll(accountList);
				break;
			case 3:
				System.out.println(findAccount(sc, accountList));
				break;
			case 4:
				transferFunds(sc, accountList);
				break;
			case 5:
				removeAccount(sc, accountList);
				break;
			case 6:
				applyInterst(sc, accountList);
				break;
			case 7:
				Collections.sort(accountList);
				break;
			case 8:
				Collections.sort(accountList,new Comparator<Account>() {
					
					@Override
					public int compare(Account a1,Account a2) {
						return a2.getDateOfOpening().compareTo(a1.getDateOfOpening());
					}
				});
			case 0:
				System.out.println("Exiting the menu");
				return;
			default:
				System.err.println("Invalid Choice");
				return;
			}
		}}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
}
	
	private static void applyInterst(Scanner sc,List<Account> accounts) throws Exception{
		try{
			System.out.println("Enter Account deatils ");
		
		Account acc = findAccount(sc, accounts);
		if(acc.getClass() != SavingAccount.class) {
			throw new Exception("Account Type is not Saving Type");
		 }
		
		SavingAccount sacc = (SavingAccount)acc;
		sacc.applyInterst();
		System.out.println("Applied Intreast");
		}catch(Exception e) {
			throw e;
		}
		
	}
	
	private static void removeAccount(Scanner sc,List<Account> accounts) throws AccountNotFoundException{
		System.out.println("Enter Account number");
		long accNo = sc.nextLong();
		for(Account acc: accounts) {
			if(acc.getAccNo() ==accNo ) {
				accounts.remove(acc);
			}
		}
		throw new AccountNotFoundException("No Account Found");
	}
	
	private static void transferFunds(Scanner sc,List<Account> accounts) {
		try {
			System.out.println("Enter From Account ");
			Account fromAccout = findAccount(sc, accounts);
			
			System.out.println("Enter To Account ");
			Long toAcc = sc.nextLong();
			Account toAccout = findAccount(sc, accounts);
			
			System.out.println("Enter Amount to transfer");
			double amount = sc.nextDouble();
			
			
			if(amount<0) {
				throw new Exception("Negative Amount");
			}
			
			
			if(fromAccout.getBalance()<1000 || amount >fromAccout.getBalance()) {
				throw new MinBalanceException("Balance is Low");
			}
			
			double deduct = fromAccout.getBalance()-amount;
			double credit = toAccout.getBalance()+amount;
			
			fromAccout.setBalance(deduct);
			toAccout.setBalance(credit);
			System.out.println("Amout Transferd Succesfully");
		} catch (Exception  e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static void printAll(List<Account> accountList) {
		for(Account acc: accountList) {
			System.out.println(acc);
		}
		
	}
	
	private static Account findAccount(Scanner sc,List<Account> accountList) throws AccountNotFoundException {	
			 System.out.println("Enter Account Number");
			 long accNo = sc.nextLong();
			  for(Account acc: accountList) {
				  if(acc.getAccNo() ==accNo) {
					  return  acc;
				  }  
			  }
			  throw new AccountNotFoundException("Accout NUMber not fout");
	}
	
	private static void addAccount(List<Account> accounts, Scanner sc) {
		
		try {
			System.out.println("Enter Account Details");
			
			System.out.println("Enter Account Type"
					+ "\n1.Saving Account"
					+ "\n2.CurrentAccount");
			int choice = sc.nextInt();
			
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
			
			if(choice>2 || choice<1) {
				throw new Exception("Invalid Choice");
			}
			
			if(1==choice) {
				accounts.add(new SavingAccount(name, formatDate,balance));
				return;
			}
			
			if(2==choice) {
				accounts.add(new CurrentAccount(name, formatDate,balance));
				return;
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}	
		
	}
}