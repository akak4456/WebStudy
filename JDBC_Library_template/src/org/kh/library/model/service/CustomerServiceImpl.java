package org.kh.library.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.library.common.JDBCTemplate;
import org.kh.library.model.dao.CustomerStoreImpl;
import org.kh.library.model.vo.Customer;

public class CustomerServiceImpl implements CustomerService {

	CustomerStoreImpl cStore;
	
	public CustomerServiceImpl() {
		cStore = new CustomerStoreImpl();
	}
	
	@Override
	public ArrayList<Customer> selectAllCustomer() {
		Connection conn = null;
		ArrayList<Customer> result = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = cStore.selectAllCustomer(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Customer selectNameSearch(String CName) {
		Connection conn = null;
		Customer result = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = cStore.selectNameSearch(CName, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Customer selectIdSearch(String CId) {
		Connection conn = null;
		Customer result = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = cStore.selectIdSearch(CId, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int insertCustomer(Customer customer) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = cStore.insertCustomer(customer, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int updateCustomer(Customer customer) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = cStore.updateCustomer(customer, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int deleteCustomer(String CId) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = cStore.deleteCustomer(CId, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
