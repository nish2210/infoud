package com.infoud.service;

import java.util.List;

import com.infoud.dao.CustomerDAO;

public class CustomerService {
	
	private CustomerDAO customerDao = new CustomerDAO();

	public List<Object> fetchAllOrdersInfo() {
		return customerDao.fetchAllOrdersInfo();
	}

}
