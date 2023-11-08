package com.yogibaba.service;

import java.util.List;

import com.yogibaba.model.Customer;

public interface ICustomerService {
	
	public Customer getCustomerDetailsByID(int id) throws Exception;

}
