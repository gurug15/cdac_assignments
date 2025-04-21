package com.cdac.acts.library.tester;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.cdac.acts.library.Book;
import com.cdac.acts.library.BookType;
import com.cdac.acts.library.validation.BookNotFoundException;

public class TesterLinkedHashMap {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 Map<String, Book> libraray = new LinkedHashMap<String, Book>();
		 
			    libraray.put("Book1", new Book("Book1", BookType.FICTION, 300.50, LocalDate.of(2020, 5, 15), "Author1", 5));
			    libraray.put("Book2", new Book("Book2", BookType.NON_FICTION, 450.00, LocalDate.of(2018, 7, 10), "Author2", 10));
			    libraray.put("Book3", new Book("Book3", BookType.SCIENCE, 350.75, LocalDate.of(2019, 12, 20), "Author3", 8));
			    libraray.put("Book4", new Book("Book4", BookType.HISTORY, 250.30, LocalDate.of(2021, 6, 1), "Author4", 15));
			    libraray.put("Book5", new Book("Book5", BookType.FANTASY, 500.20, LocalDate.of(2022, 3, 12), "Author5", 3));
			    libraray.put("Book6", new Book("Book6", BookType.FICTION, 300.00, LocalDate.of(2020, 1, 8), "Author6", 12));
			    libraray.put("Book7", new Book("Book7", BookType.NON_FICTION, 400.50, LocalDate.of(2017, 9, 25), "Author7", 9));
			    libraray.put("Book8", new Book("Book8", BookType.SCIENCE, 375.10, LocalDate.of(2019, 10, 14), "Author8", 6));
			    libraray.put("Book9", new Book("Book9", BookType.FANTASY, 600.00, LocalDate.of(2021, 11, 5), "Author9", 7));
			    libraray.put("Book10", new Book("Book10", BookType.HISTORY, 280.75, LocalDate.of(2020, 4, 18), "Author10", 4));
		 int choice;

	        try {
	        	do {
		            System.out.println("\nMenus:");
		            System.out.println("1. Add book");
		            System.out.println("2. Display all books");
		            System.out.println("3. Allot book to student (quantity -1)");
		            System.out.println("4. Take book return (quantity +1)");
		            System.out.println("5. Remove book");
		            System.out.println("6. Exit");
		            System.out.print("Enter your choice: ");
		            choice = scanner.nextInt();
		            scanner.nextLine(); // Consume newline

		            switch (choice) {
		                case 1 : addBook(scanner,libraray);
		                break;
		                case 2 :displayAllBooks(libraray);
		                break;
		                case 3: allotBookToStudent(scanner, libraray);
		                break;
		                case 4: takeBookReturn(scanner, libraray);
		                break;
		                case 5 : removeBook(scanner, libraray);
		                break;
		                case 6 :
		                	System.out.println("Exiting the system. Goodbye!");
		                	return;
		                default :
		                	System.out.println("Invalid choice! Please try again.");
		                	break;
		            }
		        } while (choice != 6);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
	}

	
	
	public static Book addBook(Scanner scanner,Map<String, Book> libraray ) {
      
       DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

       try {
           // Input book details
           System.out.print("Enter title: ");
           String title = scanner.nextLine();

           System.out.print("Enter book type (FICTION, NON_FICTION, SCIENCE, HISTORY, FANTASY, OTHER): ");
           BookType bookType = BookType.valueOf(scanner.nextLine().toUpperCase());
           

           System.out.print("Enter price: ");
           double price = Double.parseDouble(scanner.nextLine());

           System.out.print("Enter published date (yyyy-MM-dd): ");
           LocalDate publishedDate = LocalDate.parse(scanner.nextLine(), dateFormatter);

           System.out.print("Enter author name: ");
           String authorName = scanner.nextLine();

           System.out.print("Enter quantity: ");
           int quantity = Integer.parseInt(scanner.nextLine());

           // Create and return the Book object
           libraray.put(title,new Book(title, bookType, price, publishedDate, authorName, quantity));

       } catch (DateTimeParseException e) {
           System.out.println("Invalid date format! Please use yyyy-MM-dd.");
       } catch (IllegalArgumentException e) {
           System.out.println("Invalid book type! Please use one of the listed values.");
       }

       return null; // Return null if there was an error
   }
	
	private static void displayAllBooks(Map<String, Book> libraray) {
		for(Book book: libraray.values()) {
			System.out.println(book);
		}
	}
	public static void allotBookToStudent(Scanner sc,Map<String, Book> library) throws Exception{
		System.out.print("Enter the title of the book to allot: ");
	    String title =sc.nextLine();
	    Book book = library.get(title);

	    if (book != null) {
	        if (book.getQuantity() > 0) {
	            book.setQuantity(book.getQuantity() - 1);
	            System.out.println("Book allotted successfully! Remaining quantity: " + book.getQuantity());
	        } else {
	            throw new Exception("Book is out of stock!");
	        }
	    } else {
	        throw new Exception("Book not found!");
	    }
	}
	public static void takeBookReturn(Scanner sc,Map<String, Book> library) throws Exception{
		System.out.print("Enter the title of the book to return: ");
	    String title =sc.nextLine();
	    Book book = library.get(title);

	    if (book != null) {
	            book.setQuantity(book.getQuantity() +1);
	            System.out.println("Book allotted successfully! Remaining quantity: " + book.getQuantity());
	        } else {
	        throw new Exception("Book not found!");
	    }
	}
	public static void removeBook(Scanner sc,Map<String, Book> library) throws BookNotFoundException {
		System.out.println("Enter Book Title to Delete:");
		String title = sc.next();
		if(library.containsKey(title)) {
			library.remove(title);
			return;
		}
		
		throw new BookNotFoundException();
	}

}
