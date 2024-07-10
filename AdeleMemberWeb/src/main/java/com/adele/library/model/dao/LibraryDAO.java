package com.adele.library.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adele.book.model.vo.Book;
import com.adele.library.model.vo.Library;
import com.adele.member.model.vo.Member;


public class LibraryDAO {

	public List<Library> selectList(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT LEASE_NO, BOOK_NO, BOOK_NAME, BOOK_WRITER, BOOK_PRICE, PUBLISHER, GENRE, "
				+ "MEMBER_ID, MEMBER_NAME, AGE, ADDRESS, GENDER, ENROLL_DATE, LEASE_DATE, RETURN_DATE "
				+ "FROM LIBRARY "
				+ "JOIN BOOK USING(BOOK_NO) "
				+ "JOIN MEMBER USER_ID=MEMBER_ID";
		
		pstmt = conn.prepareStatement(query);
		rset = pstmt.executeQuery();
		ArrayList<Library> result = new ArrayList<>();
		while(rset.next()) {
			result.add(rsetToLibrary(rset));
		}
		rset.close();
		pstmt.close();
		return result;
	}

	public Library selectOne(String userId, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT LEASE_NO, BOOK_NO, BOOK_NAME, BOOK_WRITER, BOOK_PRICE, PUBLISHER, GENRE, "
				+ "MEMBER_ID, MEMBER_NAME, AGE, ADDRESS, GENDER, ENROLL_DATE, LEASE_DATE, RETURN_DATE "
				+ "FROM LIBRARY "
				+ "JOIN BOOK USING(BOOK_NO) "
				+ "JOIN MEMBER USER_ID=MEMBER_ID "
				+ "WHERE USER_ID = ?";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, userId);
		rset = pstmt.executeQuery();
		Library result = null;
		if(rset.next()) {
			result = rsetToLibrary(rset);
		}
		rset.close();
		pstmt.close();
		return result;
	}

	public Library selectOneByName(String bookName, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT LEASE_NO, BOOK_NO, BOOK_NAME, BOOK_WRITER, BOOK_PRICE, PUBLISHER, GENRE, "
				+ "MEMBER_ID, MEMBER_NAME, AGE, ADDRESS, GENDER, ENROLL_DATE, LEASE_DATE, RETURN_DATE "
				+ "FROM LIBRARY "
				+ "JOIN BOOK USING(BOOK_NO) "
				+ "JOIN MEMBER USER_ID=MEMBER_ID "
				+ "WHERE BOOK_NAME LIKE '%' || ? || '%'";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, bookName);
		rset = pstmt.executeQuery();
		Library result = null;
		if(rset.next()) {
			result = rsetToLibrary(rset);
		}
		rset.close();
		pstmt.close();
		return result;
	}

	public int insertLibrary(Library library, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO LIBRARY VALUES(SEQ_LEASE_NO.NEXTVAL, ?, ?, SYSDATE, SYSDATE)";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, library.getBookNo());
		pstmt.setString(2, library.getUserId());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	
	private Library rsetToLibrary(ResultSet rset) throws SQLException {
		Library library = new Library();
		library.setLeaseNo(rset.getInt("LEASE_NO"));
		
		library.setBookNo(rset.getInt("BOOK_NO"));
		Book book = new Book();
		book.setBookNo(rset.getInt("BOOK_NO"));
		book.setBookName(rset.getString("BOOK_NAME"));
		book.setBookWriter(rset.getString("BOOK_WRITER"));
		book.setBookPrice(rset.getInt("BOOK_PRICE"));
		book.setPublisher(rset.getString("PUBLISHER"));
		book.setGenre(rset.getString("GENRE"));
		library.setBook(book);
		
		library.setUserId(rset.getString("MEMBER_ID"));
		Member user = new Member();
		user.setMemberId(rset.getString("MEMBER_ID"));
		user.setMemberName(rset.getString("MEMBER_NAME"));
		user.setAge(rset.getInt("AGE"));
		user.setAddress(rset.getString("ADDRESS"));
		library.setUser(user);
		
		library.setLeaseDate(rset.getDate("LEASE_DATE"));
		library.setReturnDate(rset.getDate("RETURN_DATE"));
		return library;
	}
}
