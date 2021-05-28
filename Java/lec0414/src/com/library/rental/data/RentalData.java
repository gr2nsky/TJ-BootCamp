package com.library.rental.data;

public class RentalData {
	
	int studentNo;
	int bookNo;
	int retalDate;
	int returnDate;
	public RentalData(int studentNo, int bookNo, int retalDate, int returnDate) {
		super();
		this.studentNo = studentNo;
		this.bookNo = bookNo;
		this.retalDate = retalDate;
		this.returnDate = returnDate;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public int getRetalDate() {
		return retalDate;
	}
	public void setRetalDate(int retalDate) {
		this.retalDate = retalDate;
	}
	public int getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(int returnDate) {
		this.returnDate = returnDate;
	}
	
	
}
