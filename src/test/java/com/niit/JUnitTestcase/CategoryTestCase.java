package com.niit.JUnitTestcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.domain.Category;

public class CategoryTestCase {

	//bcoz we used Annotations @Repository, @Component, @Configuration
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static CategoryDAO categoryDAO;
	@Autowired static Category category;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO =(CategoryDAO) context.getBean("categoryDAO");
		category=(Category) context.getBean("category");
		
	}
	
	@Test
	public void createCategoryTestCase()
		{
		category.setId("123");
		category.setName("SuperBikes");
		category.setDescription("This Is a superbike");
		boolean flag =  categoryDAO.save(category);
		System.out.println("");
		
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createCategoryTestCase",true,flag);
		
	}
}