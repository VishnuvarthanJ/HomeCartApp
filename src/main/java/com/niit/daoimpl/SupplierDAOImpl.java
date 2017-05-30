package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.SupplierDAO;
import com.niit.domain.Supplier;




@Repository("supplierDAO")          
@Transactional
public class SupplierDAOImpl implements SupplierDAO{

@Autowired private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
		
	}
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
		
	}

	public List<Supplier> list() {
		
		return getCurrentSession().createQuery("from Supplier").list();
	}

	public boolean save(Supplier supplier) {
		try{
			getCurrentSession().save(supplier);
			
		}catch(Exception ex){
	
			ex.printStackTrace();
			return false;
	}
		return true;
	}

	public boolean update(Supplier supplier){
		try{
			getCurrentSession().update(supplier);
			
		}catch(Exception ex){
			ex.printStackTrace();
	
			return false;
	}
		return true;
	}

	public boolean delete(String id) {
		try{
			getCurrentSession().delete(getSupplierByID(id));
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
	}
		return true;
	}

	public Supplier getSupplierByID(String id) {
		//select*from Supplier where id=?
		
		return (Supplier) getCurrentSession().get(Supplier.class, id);
	}

	public Supplier getSupplierByName(String name) {
		/*getCurrentSession().createQuerry("from Supplier where name=?").setString(0,name).uniqueResult();
		return null; */
		
		Query query=getCurrentSession().createQuery("from Supplier where name =?");
		query.setString(0, name);
		
		return(Supplier) query.uniqueResult();
	}

}