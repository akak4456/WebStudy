package org.kh.library.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.kh.library.model.vo.Book;

public class BookStoreImpl implements BookStore {

	@Override
	public ArrayList<Book> selectAllBook(Connection conn) throws SQLException {
		Statement stmt = null;
		ArrayList<Book> result = null;
		ResultSet rset = null;
		String query = "SELECT * FROM BOOK";
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);
		result = new ArrayList<>();
		while(rset.next()) {
			result.add(rsetToBook(rset));
		}
		rset.close();
		stmt.close();
		return result;
	}

	@Override
	public Book selectBookOne(int bookNo, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Book result = null;
		String query = "SELECT * FROM BOOK WHERE BOOK_NO = ?";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, bookNo);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			result = rsetToBook(rset);
		}
		
		rset.close();
		pstmt.close();
		return result;
	}

	@Override
	public int insertBook(Book book, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO BOOK VALUES(SEQ_BOOK_NO.NEXTVAL, ?, ?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getBookWriter());
		pstmt.setInt(3, book.getBookPrice());
		pstmt.setString(4, book.getPublisher());
		pstmt.setString(5, book.getGenre());
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	@Override
	public int deleteBook(int bookNo, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM BOOK WHERE BOOK_NO = ?";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, bookNo);
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	private Book rsetToBook(ResultSet rset) throws SQLException {
		Book book = new Book();
		book.setBookNo(rset.getInt("BOOK_NO"));
		book.setBookName(rset.getString("BOOK_NAME"));
		book.setBookWriter(rset.getString("BOOK_WRITER"));
		book.setBookPrice(rset.getInt("BOOK_PRICE"));
		book.setPublisher(rset.getString("PUBLISHER"));
		book.setGenre(rset.getString("GENRE"));
		return book;
	}
}
