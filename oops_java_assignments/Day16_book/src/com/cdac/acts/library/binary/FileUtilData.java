package com.cdac.acts.library.binary;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.cdac.acts.library.Book;
import com.cdac.acts.library.BookType;

public class FileUtilData {

    // ✅ Directory should end with "/"
    private static final String fileDir = "C:/Users/gurug/OneDrive/Desktop/Java-Workspaace/";
    private static final String fileName = "books.dat";
    private static final File file = new File(fileDir + fileName);

    private FileUtilData() {}

    // ✅ Write all books to file (appending)
    public static void writeBookData(Map<String, Book> books) {
        try {
            // Ensure the directory exists
            File dir = new File(fileDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            try (FileOutputStream dataFile = new FileOutputStream(file, true);
                 DataOutputStream writeToFile = new DataOutputStream(new BufferedOutputStream(dataFile))) {

                for (Map.Entry<String, Book> entry : books.entrySet()) {
                    writeToFile.writeUTF(entry.getKey());
                    Book book = entry.getValue();
                    writeToFile.writeUTF(book.getTitle());
                    writeToFile.writeUTF(book.getBookType().name());
                    writeToFile.writeDouble(book.getPrice());                        // ✅ Write as double
                    writeToFile.writeUTF(book.getPublishedDate().toString());
                    writeToFile.writeUTF(book.getAuthorName());
                    writeToFile.writeInt(book.getQuantity());                        // ✅ Write as int
                }

                writeToFile.flush(); // ✅ Force write

            }
        } catch (IOException e) {
            System.err.println("Error writing book data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ✅ Write a single book entry
    public static void writeOneBookData(String key, Book book) {
        try {
            File dir = new File(fileDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            try (FileOutputStream dataFile = new FileOutputStream(file, true);
                 DataOutputStream writeToFile = new DataOutputStream(new BufferedOutputStream(dataFile))) {

                writeToFile.writeUTF(key);
                writeToFile.writeUTF(book.getTitle());
                writeToFile.writeUTF(book.getBookType().name());
                writeToFile.writeDouble(book.getPrice());
                writeToFile.writeUTF(book.getPublishedDate().toString());
                writeToFile.writeUTF(book.getAuthorName());
                writeToFile.writeInt(book.getQuantity());

                writeToFile.flush();
            }

        } catch (IOException e) {
            System.err.println("Error writing one book: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ✅ Read books from file
    public static Map<String, Book> readBookData() {
        Map<String, Book> books = new HashMap<>();

        // If file doesn't exist, just return empty map
        if (!file.exists()) {
            System.out.println("No existing data file found.");
            return books;
        }

        try (FileInputStream dataFile = new FileInputStream(file);
             DataInputStream readFromFile = new DataInputStream(new BufferedInputStream(dataFile))) {

            while (true) {
                try {
                    String key = readFromFile.readUTF();
                    String title = readFromFile.readUTF();
                    BookType bookType = BookType.valueOf(readFromFile.readUTF());
                    double price = readFromFile.readDouble();
                    LocalDate date = LocalDate.parse(readFromFile.readUTF());
                    String author = readFromFile.readUTF();
                    int quantity = readFromFile.readInt();

                    books.put(key, new Book(title, bookType, price, date, author, quantity));
                } catch (EOFException eof) {
                    break; // ✅ End of file reached
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading book data: " + e.getMessage());
            e.printStackTrace();
        }

        return books;
    }
}
