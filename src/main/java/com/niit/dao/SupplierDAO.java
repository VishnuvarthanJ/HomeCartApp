package com.niit.dao;

import java.util.List;

import com.niit.domain.Supplier;

public interface SupplierDAO {
	//get all the categories
		public List<Supplier> list();
		
		//create category
		
		public boolean save(Supplier product);
		
		//update category
		public boolean update(Supplier product);
		
		
		//delete category
		public boolean delete(String id);
		
		
		//get category by id 
		public Supplier getSupplierByID(String id);
		
		
		//get category by name 
		public Supplier getSupplierByName(String name);
	

}