package com.yogibaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogibaba.dao.ICustomerDAO;
import com.yogibaba.model.Customer;

@Service("Cust_Service")
public class ImplCustomerService implements ICustomerService {

	@Autowired
	private ICustomerDAO customerdao;
	
	@Override
	public Customer getCustomerDetailsByID(int id) throws Exception {
		
	   Customer customer = customerdao.getCustomerDetails(id);
		return customer;
	}

}
