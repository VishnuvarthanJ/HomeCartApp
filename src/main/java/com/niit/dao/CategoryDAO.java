package com.niit.dao;

import java.util.List;

import com.niit.domain.Category;

public interface CategoryDAO
{
	
	
	//get all the categories
	public List<Category> list();
	
	//create category
	
	public boolean save(Category category);
	
	//update category
	public boolean update(Category category);
	
	
	//delete category
	public boolean delete(String id);
	
	
	//get category by id 
	public Category getCategoryByID(String id);
	
	
	//get category by name 
	public Category getCategoryByName(String name);
	
	
}