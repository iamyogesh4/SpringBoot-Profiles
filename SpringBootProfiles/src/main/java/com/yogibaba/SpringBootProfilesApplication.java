package com.yogibaba;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.yogibaba.controller.EmployeeController;
import com.yogibaba.model.Employee;

import ch.qos.logback.core.spi.LifeCycle;

@SpringBootApplication
public class SpringBootProfilesApplication {

	public static void main(String[] args) {
	ApplicationContext ctx = 	SpringApplication.run(SpringBootProfilesApplication.class, args);
	
	EmployeeController obj = ctx.getBean("empController",EmployeeController.class);
	
	   
	try 
	{
		
		List<Employee> list = obj.processEmployeeDetails("Pune", "Mumbai", "Hyd");
		
		
		list.forEach(emp->{
			
			System.out.println(emp+ " ");
		});
		
		
	}
	
	catch (Exception e) {
	  e.printStackTrace();
	  
	  
	}
	
	
	((ConfigurableApplicationContext) ctx).close();
	}

}
