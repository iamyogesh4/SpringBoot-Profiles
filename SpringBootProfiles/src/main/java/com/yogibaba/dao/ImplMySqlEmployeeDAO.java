package com.yogibaba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.yogibaba.model.Employee;
@Repository("sqlDAO")
//@Profile({"dev,test"})
public class ImplMySqlEmployeeDAO implements IEmployeeDao {
	
	private final static  String GET_EMPLOYEE_DETAILS= "SELECT ENO , ENAME , ESAL,EADD, EDESIGNATION , EHIKE FROM EMPLOYEE WHERE EDESIGNATION IN (?,?,?)";  

	@Autowired
	private DataSource ds;
	
	@Override
	public List<Employee> getEmployeebyDesignation(String design1, String design2, String design3) throws Exception {
		
	     List<Employee> list = new ArrayList();
	     
	     
	     try(Connection con = ds.getConnection();PreparedStatement ps = con.prepareStatement(GET_EMPLOYEE_DETAILS);)
	     {
	    	 
	    	 
	    	 try(ResultSet rs= ps.executeQuery();)
	    	 {
	    		
	    		 
	    		 while(rs.next()) 
	    		 {
	    			 Employee obj = new Employee();
	    			 
	    			 obj.setEno(rs.getInt(1));
	    			 obj.setEname(rs.getString(2));
	    			 obj.setEsal(rs.getInt(3));
	    			 obj.setEadd(rs.getString(4));
	    			 obj.setEdesignation(rs.getString(5));
	    			 obj.setEhike(rs.getInt(6));
	    			 
	    			 list.add(obj);
	    			 
	    			 
	    		 }
	    		 
	    	 
	    	 
	    	 }
	    	 
	    	
	    	 
	    	 
	    	 
	     }
	     
	     catch(SQLException se) 
	 	    {
	 	    	se.getStackTrace();
	 	    	
	 	    	throw se;
	 	   }
	     catch (Exception e) {
			
	    	 e.printStackTrace();
	    	 
	    	 throw e;
	      }
	   
	     
	     
	     
	     
	     
	     
	     return list;
		
		
	}

}
