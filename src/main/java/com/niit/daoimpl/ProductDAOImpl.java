package com.niit.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDAO;
import com.niit.domain.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Getting the single product based on id
	 */
	public Product get(int productId) {

		return (Product) sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
	}

	/**
	 * Get the List of All Category
	 */

	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	/**
	 * Insert Product
	 */
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Update Product
	 */

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Delete Product
	 */

	public boolean delete(Product product) {
		try {
			product.setActive(false);
			// call the update method
			return this.update(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Product> listActiveProducts() {

		String selectActiveProducts = "FROM Product WHERE active = :active";

		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {

		String selectActiveProductsCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";

		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsCategory, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();

	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active = :active ORDER_BY_id", Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

	public boolean saveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getAllProductsByCategoryId(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getAllProductsBySupplierId(String supplierId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
