package com.yogibaba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.yogibaba.dao.IEmployeeDao;
import com.yogibaba.model.Employee;

@Service("employeeService")
public class ImplEmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeDao edao;
	
	@Override
	public List<Employee> proceedEmployeeDetails(String design1, String design2, String design3) throws Exception {
	
		
		List<Employee> list = edao.getEmployeebyDesignation(design1, design2, design3);
		
		
		list.forEach(emp->
		{ 
			
			
			int result = emp.getEsal()+ (emp.getEsal() * emp.getEhike())/100;
			
			emp.setTotalSalAfterHike(result);
			
			
		});
		
		
		return list;
		
		
		
	}

}
