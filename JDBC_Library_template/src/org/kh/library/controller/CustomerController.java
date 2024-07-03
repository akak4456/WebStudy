package org.kh.library.controller;

import java.util.ArrayList;

import org.kh.library.model.service.CustomerServiceImpl;
import org.kh.library.model.vo.Customer;

public class CustomerController implements CustomerControllerI {

	CustomerServiceImpl cService;
	
	public CustomerController() {
		cService = new CustomerServiceImpl();
	}
	
	@Override
	public ArrayList<Customer> selectAllCustomer() {
		ArrayList<Customer> result = cService.selectAllCustomer();
		return result;
	}

	@Override
	public Customer selectNameSearch(String CName) {
		Customer result = cService.selectNameSearch(CName);
		return result;
	}

	@Override
	public Customer selectIdSearch(String CId) {
		Customer result = cService.selectIdSearch(CId);
		return result;
	}

	@Override
	public int insertCustomer(Customer customer) {
		int result = cService.insertCustomer(customer);
		return result;
	}

	@Override
	public int updateCustomer(Customer customer) {
		int result = cService.updateCustomer(customer);
		return result;
	}

	@Override
	public int deleteCustomer(String CId) {
		int result = cService.deleteCustomer(CId);
		return result;
	}

}
