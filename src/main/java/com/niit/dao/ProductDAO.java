package com.niit.dao;

import java.util.List;

import com.niit.domain.Product;

public interface ProductDAO {

	public boolean saveOrUpdate(Product product);



	// delete category
	public boolean delete(String id);

	public List<Product> list();

	public Product getProductById(String id);
	
	//get all products pertaining to particular category
	public List<Product> getAllProductsByCategoryId(String categoryId);
	public List<Product> getAllProductsBySupplierId(String supplierId);
	
	public Product getProductByName(String name);
	



	public Object listActiveProducts();



	public Object listActiveProductsByCategory(int i);



	public Object getLatestActiveProducts(int i);



	Product get(int productId);



	boolean add(Product product);



	boolean update(Product product);



	boolean delete(Product product);
	
}