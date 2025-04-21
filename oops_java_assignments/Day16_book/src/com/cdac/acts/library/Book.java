package com.cdac.acts.library;
import java.time.LocalDate;
import java.util.Date;

public class Book implements Comparable<Book>{
    private String title;
    private BookType bookType;
    private Double price;
    private LocalDate publishedDate; 
    private String authorName;
    private int quantity;

    public Book(String title, BookType bookType, Double price, LocalDate publishedDate2, String authorName, int quantity){
        this.title = title;
        this.bookType = bookType;
        this.price = price;
        this.publishedDate = publishedDate2;
        this.authorName = authorName;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", bookType=" + bookType +
                ", price=" + price +
                ", publishedDate=" + publishedDate +
                ", authorName='" + authorName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
    @Override
    public int compareTo(Book b) {
    	return this.title.compareTo(b.title);
    }
}

