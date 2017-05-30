package com.niit.JUnitTestcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.domain.User;



public class UserTestCase 
{

	@Autowired  static AnnotationConfigApplicationContext context;
	
@Autowired  static UserDAO  userDAO;
	
	@Autowired  static User user;

	
	
	
	//The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case
	 * and will execute only once
	 */
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
		userDAO =  (UserDAO)context.getBean("userDAO");
		
		//get the user from context
		
		user = (User)context.getBean("user");
		
	}
	
	@Test
	public void createUserTestCase()
		{
		user.setId("110");
		user.setContact("12345");
		user.setName("Bisht");
		user.setPassword("1234567");
		user.setRole("ROLE_USER");
		
		boolean flag =  userDAO.save(user);
		System.out.println("");
		
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createUserTestCase",true,flag);
		
	}
	
}
