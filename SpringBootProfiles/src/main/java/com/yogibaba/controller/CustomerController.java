package com.yogibaba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yogibaba.model.Customer;
import com.yogibaba.service.ICustomerService;

@Controller("customerController")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	
	public Customer proceedCustomerID(int id) throws Exception
	{
		
		Customer customer = customerService.getCustomerDetailsByID(id);
	
		
		
		return customer;
		
	}
	
	

}
