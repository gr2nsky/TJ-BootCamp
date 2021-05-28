package com.library.data;

public class Book {
	int bookNo;
	int quantity;
	String name;
	String author;
	String publisher;
	public Book(int bookNo, int quantity, String name, String author, String publisher) {
		super();
		this.bookNo = bookNo;
		this.quantity = quantity;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setQuantity(int bookNo) {
		this.bookNo = bookNo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setBookNo(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
}
