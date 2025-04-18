package com.cdac.loaders;

import java.awt.print.Book;
import java.sql.Date;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println(" App Class loader     "+Main.class.getClassLoader());
		System.out.println(" Platform class loader         "+Main.class.getClassLoader().getParent());
		System.out.println(" BootStrap class loader    "+Main.class.getClassLoader().getParent().getParent());
		System.out.println("Book  Class loader     "+Book.class.getClassLoader());
		System.out.println("SQL Date Platform class loader         "+Date.class.getClassLoader());
		System.out.println(" BootStrap class loader    "+Main.class.getClassLoader().getParent().getParent());
		System.out.println("BootStrap lang: " + LocalDate.class.getClassLoader());

	}

}
