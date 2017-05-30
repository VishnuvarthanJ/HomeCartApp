package com.niit.JUnitTestcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.domain.Supplier;

public class SupplierTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static SupplierDAO supplierDAO;
	@Autowired static Supplier supplier;

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	supplierDAO = (SupplierDAO) context.getBean("supplierDAO");	
	supplier =(Supplier) context.getBean("supplier");
	
	
	
	}
	@Test
	public void createSupplierTestCase()
	{
		supplier.setId("1");
		supplier.setName("Jainsons");
		supplier.setDescription("Large Collection of Home Appliances");
		
		boolean flag =  supplierDAO.save(supplier);
		
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createSupplierTestCase",true,flag);
		
	}
	@Test
	public void updateSupplierTestCase()
	{
		supplier.setId("6");
		supplier.setName("Sri Meenakshi FanHouse");
		supplier.setDescription("Large Collection of Home Appliances");
		
		boolean flag =  supplierDAO.update(supplier);
		
		
		
		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("updateSupplierTestCase",true,flag);
		
	}
	
	@Test
	public void listAllSupplierTestCase()
	{
		int actualSize = supplierDAO.list().size();
		assertEquals(6, actualSize);
	} 
	
	
	/**@Test
	public void getAllCategoriesTestCase()
	{
		List<Supplier> categories = supplierDAO.list();
		
		assertEquals(10,categories.size());
		
	}
**/
}
