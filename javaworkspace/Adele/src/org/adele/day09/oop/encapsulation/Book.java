package org.adele.day09.oop.encapsulation;

public class Book {
	
	public static void main(String [] args) {
		// 필드에 직접 접근(옳지않음)
//		Book book = new Book();
//		book.title="춘향뎐";
//		book.author = "작자미상";
		// 생성자를 통해서 초기화
		Book book = new Book("춘향뎐", "작자미상");
		
		//setter() 메서드를 이용한 초기화
		Book bookbook = new Book();
		bookbook.setTitle("춘향뎐");
		bookbook.setAuthor("작자미상");
	}
	
	private String title;
	private String author;
	
	public Book() {
		this("", "");
	}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	// 멤버필드			
	// 제목				bookTitle
	// 가격				bookPrice
	// 저자				bookAuthor
	// 카테고리			category
	// 출판사			publisher
	// 출판날짜			publishingDate
//	String title;
//	int price;
//	String author;
//	String category;
//	String publisher;
//	String publishingDate;
	
	// 멤버메소드
	// 빌려주다, 팔리다, 입고되다(등록), ...
}
