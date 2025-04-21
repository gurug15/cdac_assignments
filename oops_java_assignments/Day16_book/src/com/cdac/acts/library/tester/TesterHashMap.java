package com.cdac.acts.library.tester;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Scanner;

import com.cdac.acts.library.Book;
import com.cdac.acts.library.BookType;
import com.cdac.acts.library.binary.FileUtilData;
import com.cdac.acts.library.validation.BookNotFoundException;

public class TesterHashMap {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 Map<String, Book> libraray = FileUtilData.readBookData();

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
				e.printStackTrace();
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
            Book book = new Book(title, bookType, price, publishedDate, authorName, quantity);
            libraray.put(title,book);
            FileUtilData.writeOneBookData(title, book);
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
		//FileUtilData.WriteBookData(libraray);
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
