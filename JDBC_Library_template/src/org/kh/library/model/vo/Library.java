package org.kh.library.model.vo;

import java.sql.Date;

public class Library {
	private int leaseNo;
	private int bookNo;
	private Book book;
	private String userId;
	private Customer user;
	private Date leaseDate;
	private Date returnDate;
	public int getLeaseNo() {
		return leaseNo;
	}
	public void setLeaseNo(int leaseNo) {
		this.leaseNo = leaseNo;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Customer getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
	public Date getLeaseDate() {
		return leaseDate;
	}
	public void setLeaseDate(Date leaseDate) {
		this.leaseDate = leaseDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	@Override
	public String toString() {
		return "Library [leaseNo=" + leaseNo + ", bookNo=" + bookNo + ", userId=" + userId + ", leaseDate=" + leaseDate
				+ ", returnDate=" + returnDate + "]";
	}
	
	
}
