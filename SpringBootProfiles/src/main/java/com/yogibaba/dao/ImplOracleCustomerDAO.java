package com.yogibaba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogibaba.model.Customer;

@Repository("oracust_Dao")
public class ImplOracleCustomerDAO implements ICustomerDAO {

	

	private final static String GET_CUSTOMER_DETAILS ="SELECT CUSTOMERID ,CUSTOMERNAME ,CUSTOMERCITY,CUSTMERAGE,CUSTOMERCONTACT FROM CUSTOMER WHERE  CUSTOMERID IN(?)";

	@Autowired
	private DataSource ds;
	
	@Override
	public Customer getCustomerDetails(int id) throws Exception {

		 Customer customer = new Customer();

		try (Connection con =ds.getConnection(); PreparedStatement ps =con.prepareStatement(GET_CUSTOMER_DETAILS);) {

			ps.setInt(1, id);
		

			try (ResultSet rs = ps.executeQuery();) {
				
				System.out.println("Connection Establish::");

				
				  while(rs.next()) {
				  
				 
				  customer.setCustomerId(rs.getInt(1));
				  customer.setCustomerName(rs.getString(2));
				  customer.setCustomerCity(rs.getString(3));
				  customer.setCustomerAge(rs.getInt(4));
				  customer.setCustomerContact(rs.getLong(5));
				  
				  
				  
				  }
				 

			}

		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return customer;
	}

}
