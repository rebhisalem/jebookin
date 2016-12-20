package com.spring.project.Repo.DAL;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.Data.Book;
import com.spring.project.Data.Customer;
import com.spring.project.Data.Order;
import com.spring.project.genericdao.DAL.GenericDaoImpl;
@Transactional
@Repository("CustomerDao")
public class RepositoryCustomer implements RepositoryCustomerInterface{

	private GenericDaoImpl<Customer> dao;
	private GenericDaoImpl<Order> daoOrder;
	
//	public RepositoryCustomer() {
//		dao = new GenericDaoImpl<Customer>(Customer.class);
//		daoOrder = new GenericDaoImpl<Order>(Order.class);
//	}
	@Autowired
    public void setDao(GenericDaoImpl<Customer> svc){
        this.dao=svc;
    }
	
	public void add(Customer obj) {
		dao.save(obj);
	}

	public Customer find(String id) {
		return dao.find(id);
	}
	
	public List<Customer> findByColumn(String column, String value) {
		return dao.findByColumn(column, value, Customer.class);
	}
	
	public boolean login(String login, String pwd) {
		List<Customer> c = dao.findByColumn("login", login, Customer.class);
		if(c.isEmpty()) return false;
		if(c.get(0).getPassword().equals(pwd)) return true; else return false;
	}

	public void delete(Customer obj) {
//		List <Order> orders = daoOrder.findByColumn("customerID", obj.getCustomerID(), Order.class);
//		for (int i = 0; i < orders.size(); i++) {
//			daoOrder.delete(orders.get(i));
//		}
		dao.delete(obj);
	}

	public void update(Customer obj) {
		dao.saveOrUpdate(obj);
	}

}
