package com.yogibaba.dao;
import com.yogibaba.model.*;
import java.util.*;

public interface IEmployeeDao {
	
	
	public List<Employee> getEmployeebyDesignation(String design1 , String design2, String design3) throws Exception;

	
	
}
