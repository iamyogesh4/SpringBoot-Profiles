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

//@Repository("oracleDAO")
//@Profile({"uat","prod"})
public class ImplOracleEmployeeDAO implements IEmployeeDao {
	
	
private final static String GET_EMPLOYEE_DETAILS_BASED_ON_DESIGNATION= "SELECT ENO, ENAME,ESAL,EADD ,EDESIGNATION ,EHIKE FROM EMPLOYEE WHERE EDESIGNATION IN (?,?,?)";
	
	
	@Autowired
	private DataSource ds;



	@Override
	public List<Employee> getEmployeebyDesignation(String design1, String design2, String design3) throws Exception {
		
		

		List<Employee> list = null;
		
		try(Connection con = ds.getConnection();PreparedStatement ps = con.prepareStatement(GET_EMPLOYEE_DETAILS_BASED_ON_DESIGNATION);){
		
		              //set the values for preparedsttment query 
		            
		                  ps.setString(1, design1);
				         ps.setString(2, design2);
				        ps.setString(3, design3);
				        
				        //Now get the result from database 
				        
				        try(ResultSet rs=ps.executeQuery();)
				        {
				        	list= new ArrayList<Employee>();
				        	
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
            catch (SQLException se) {
				
            	 se.printStackTrace();
            	 
            	 throw se;
            	
			}
            catch (Exception e) {
			    
            	 e.printStackTrace();
            	 throw e;
			}
		
		
		
		return list;
	}


	

}
