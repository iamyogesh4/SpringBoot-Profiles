package com.yogibaba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.yogibaba.model.Employee;
import com.yogibaba.service.IEmployeeService;

@Controller("empController")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService eservice;
	
	public List<Employee> processEmployeeDetails(String s1, String design2 , String design3) throws Exception
	{
		
		List<Employee> list = eservice.proceedEmployeeDetails(design3, design2, design3);
		
		return list;
		
		
	}
	
	

}
