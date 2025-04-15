package com.cdac.acts.assignment1;


import java.util.Scanner;


import com.cdac.acts.assignment1.bank.Account;
import com.cdac.acts.assignment1.bank.CurrentAccount;
import com.cdac.acts.assignment1.bank.FixedDeposit;
import com.cdac.acts.assignment1.bank.SavingAccount;
import com.cdac.acts.assignment1.exception.MinBalException;

import com.cdac.acts.assignment1.inter.AccountTypeEnum;



public class Main {
	static Account ac=null;
	private static void createSavingAccount(Scanner sc,Account arr[],int count) {
		System.out.println("Enter Current Account Details");
		System.out.print("Enter Account Name: ");
		String name = sc.next();
		System.out.print("Enter your Balance: ");
		double bal = sc.nextDouble();
		arr[count] = new CurrentAccount(name,bal,AccountTypeEnum.SA);

	}
	private static void createFixedDAccount(Scanner sc,Account arr[],int count) {
		System.out.println("Enter Current Account Details");
		System.out.print("Enter Account Name: ");
		String name = sc.next();
		System.out.print("Enter your Balance: ");
		double bal = sc.nextDouble();
		arr[count] = new FixedDeposit(name,bal,AccountTypeEnum.FD);

	}
	private static void createCurrentAccount(Scanner sc,Account arr[],int count) {
		System.out.println("Enter Current Account Details");
		System.out.print("Enter Account Name: ");
		String name = sc.next();
		System.out.print("Enter your Balance: ");
		double bal = sc.nextDouble();
		arr[count] = new CurrentAccount(name,bal,AccountTypeEnum.CA);

	}

	public static void withdrawAmount(Scanner sc,Account acc[],int count) {
		System.out.println("Enter account No to withDraw amount from :");
		long accNo = sc.nextLong();
		System.out.println("Enter Amount :");
		double amount = sc.nextDouble();
		if (acc == null || acc.length < 1) {
	        System.out.println("NO accounts");
	        return;
	    }
		for(int i=0;i<count;i++) {
			if(acc[i].getAccNo() != accNo || acc[i].getAccType() == AccountTypeEnum.FD) {
				System.out.println("Cant withDraw from this account or no accont with this accNO");
			}
			if(acc[i].getAccNo() == accNo && acc[i].getAccType() == AccountTypeEnum.CA) {
				CurrentAccount withd = (CurrentAccount)acc[i];
				try {
					withd.withdraw(amount);
					System.out.println("Withdrawn Amount Succesfully");
				}catch(MinBalException e) {
					System.out.print("Error: ");
					e.getMessage();
				}
			}
			if(acc[i].getAccNo() == accNo && acc[i].getAccType() == AccountTypeEnum.SA) {
				
				try {
					acc[i].withdraw(amount);
					System.out.println("Withdrawn Amount Succesfully");
				}catch(MinBalException e) {
					System.out.print(e.getMessage());
					
				}
			}
		}

	}

	public static void printAccounts(Account acc[]) {
		System.out.printf("\n%-15s %-15s %-15s %-15s","Account No","Acc Name","Acc Balance","Acc type");
		for(Account a:acc) {
			if(a ==null) {
				return;
			}
			System.out.printf("\n%-15d %-15s %-15.2f %-15s",a.getAccNo(),a.getName(),a.getBalance(),a.getAccType().getValue());
		}
	}


	private static String ShowMaturedBalance(Scanner sc,Account acc[],int count) {
		System.out.print("Enter Account Number: ");
		long accNO = sc.nextLong();
		System.out.println("Enter Number of years: ");
		double years = sc.nextDouble();
		for(int i=0;i<count;i++) {
			if(acc[i].getAccNo() == accNO && acc[i].getAccType()!=AccountTypeEnum.CA) {
				System.out.println("FD SA");
				if(acc[i].getClass() == FixedDeposit.class) {
					FixedDeposit fd = (FixedDeposit)acc[i];
					fd.calculateMaturityAmount(years);
					return "Matured FD Account Balance: " + fd.getBalance();
				}
				if(acc[i].getClass() == SavingAccount.class) {
					SavingAccount sa = (SavingAccount)acc[i];
					sa.calculateMaturityAmount(years);
					return "Matured FD Account Balance: " + sa.getBalance();
				}
				//    			if(acc[i].getAccType()== AccountTypeEnum.FD) {
				//    				FixedDeposit fd = (FixedDeposit)acc[i];
				//    				fd.calculateMaturityAmount(years);
				//    				return "Matured FD Account Balance: " + fd.getBalance();
				//    				}
				//    			if(acc[i].getAccType()== AccountTypeEnum.SA) {
				//    				SavingAccount sa = (SavingAccount)acc[i];
				//    				sa.calculateMaturityAmount(years);
				//    				return "Matured FD Account Balance: " + sa.getBalance();
				//    			}
			}
		}

		return "Account Type is not FD/SA";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account account[] = new Account[50];
		int count =0;
		while(true) {
			System.out.println("\nAccount Management System"
					+ "\n1.Create Saving Account"
					+ "\n2.Create Fixed Deposit Account"
					+ "\n3.Create Current Account"
					+ "\n4.Show All Accounts"
					+ "\n5.Apply Interest"
					+ "\n6.Withdraw ampount"
					+ "\n0.Exit the Menu"
					+ "\nEnter your Choice");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				createSavingAccount(sc, account, count);
				count++;
				break;
			case 2:
				createFixedDAccount(sc, account, count);
				count++;
				break;
			case 3:
				createCurrentAccount(sc, account, count);
				count++;
				break;
			case 4:
				//				System.out.println(Arrays.toString(account));
				printAccounts(account);
				break;
			case 5:
				ShowMaturedBalance(sc, account, count);
				break;
			case 6:
				withdrawAmount(sc, account, count);
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


