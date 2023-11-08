package com.yogibaba.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yogibaba.controller.CustomerController;
import com.yogibaba.model.Customer;
@Component("main")
public class Main implements CommandLineRunner {

	@Autowired
	private CustomerController controller;
	@Override
	public void run(String... args) throws Exception {
		
		try {
		
		Customer cust = controller.proceedCustomerID(101);
		
		System.out.println(cust+ " ");
		
		
		}
		
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
