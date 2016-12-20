package com.spring.project.Repo.DAL;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.Data.Book;
import com.spring.project.Data.Order;
import com.spring.project.genericdao.DAL.GenericDaoImpl;
@Transactional
@Repository("OrderDao")
public class RepositoryOrder implements RepositoryOrderInterface{

	private GenericDaoImpl<Order> dao;
	
//	public RepositoryOrder() {
//		dao = new GenericDaoImpl<Order>(Order.class);
//	}
	@Autowired
    public void setDao(GenericDaoImpl<Order> svc){
        this.dao=svc;
    }
	public void add(Order obj) {
		dao.save(obj);
	}

	public Order find(String id) {
		return dao.find(id);
	}
	
	public List<Order> findByColumn(String column, String value) {
		return dao.findByColumn(column, value, Order.class);
	}

	public void delete(Order obj) {
		dao.delete(obj);
		
	}

	public void update(Order obj) {
		dao.saveOrUpdate(obj);
	}

}
