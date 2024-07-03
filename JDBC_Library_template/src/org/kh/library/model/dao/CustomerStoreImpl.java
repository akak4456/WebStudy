package org.kh.library.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.kh.library.model.vo.Customer;

public class CustomerStoreImpl implements CustomerStore {

	@Override
	public ArrayList<Customer> selectAllCustomer(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM CUSTOMER";
		ArrayList<Customer> result = null;
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);
		result = new ArrayList<>();
		while(rset.next()) {
			result.add(rsetToCustomer(rset));
		}
		rset.close();
		stmt.close();
		return result;
	}

	@Override
	public Customer selectNameSearch(String CName, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM CUSTOMER WHERE USER_NAME LIKE '%' || ? || '%'";
		Customer result = null;
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, CName);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			result = rsetToCustomer(rset);
		}
		rset.close();
		pstmt.close();
		return result;
	}

	@Override
	public Customer selectIdSearch(String CId, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM CUSTOMER WHERE USER_ID = ?";
		Customer result = null;
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, CId);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			result = rsetToCustomer(rset);
		}
		rset.close();
		pstmt.close();
		return result;
	}

	@Override
	public int insertCustomer(Customer customer, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO customer VALUES (SEQ_CUSTOMER_NO.NEXTVAL,?,?,?,?,?,SYSDATE)";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, customer.getUserId());
		pstmt.setString(2, customer.getUserName());
		pstmt.setInt(3, customer.getUserAge());
		pstmt.setString(4, customer.getAddr());
		pstmt.setString(5, customer.getGender());
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	@Override
	public int updateCustomer(Customer customer, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE CUSTOMER SET USER_AGE = ?, ADDR = ?, GENDER = ? WHERE USER_ID = ?";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, customer.getUserAge());
		pstmt.setString(2, customer.getAddr());
		pstmt.setString(3, customer.getGender());
		pstmt.setString(4, customer.getUserId());
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	@Override
	public int deleteCustomer(String CId, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM CUSTOMER WHERE USER_ID = ?";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, CId);
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	
	private Customer rsetToCustomer(ResultSet rset) throws SQLException {
		Customer customer = new Customer();
		customer.setUserNo(rset.getInt("USER_NO"));
		customer.setUserId(rset.getString("USER_ID"));
		customer.setUserName(rset.getString("USER_NAME"));
		customer.setUserAge(rset.getInt("USER_AGE"));
		customer.setAddr(rset.getString("ADDR"));
		customer.setGender(rset.getString("GENDER"));
		customer.setEnrollDate(rset.getDate("ENROLL_DATE"));
		return customer;
	}

}
