package com.niit.dao;

import java.util.List;

import com.niit.domain.Cart;

public interface CartDAO {
	
	public  boolean save(Cart my_Cart);

	public boolean update(Cart my_Cart);

	public List<Cart> list();

	public Cart get(String id);

}