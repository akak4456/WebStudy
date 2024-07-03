package org.kh.library.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.library.model.vo.Book;

public interface BookStore {

	public ArrayList<Book> selectAllBook(Connection conn) throws SQLException;
	public Book selectBookOne(int bookNo, Connection conn) throws SQLException;
	public int insertBook(Book book, Connection conn) throws SQLException;
	public int deleteBook(int bookNo, Connection conn) throws SQLException;
	
}
