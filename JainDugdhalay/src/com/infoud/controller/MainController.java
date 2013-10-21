package com.infoud.controller;

import java.util.List;

import com.infoud.service.CustomerService;

public class MainController {
	private CustomerService customerService = new CustomerService();

	public List<Object> fetchAllOrdersInfo() {
		return customerService.fetchAllOrdersInfo();
	}

}
