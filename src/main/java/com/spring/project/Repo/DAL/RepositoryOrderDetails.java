package com.spring.project.Repo.DAL;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.Data.OrderDetails;
import com.spring.project.genericdao.DAL.GenericDaoImpl;
@Transactional
@Repository("OrderDetailsDao")
public class RepositoryOrderDetails implements RepositoryOrderDetailsInterface{

	private GenericDaoImpl<OrderDetails> dao;
	
//	public RepositoryOrderDetails() {
//		dao = new GenericDaoImpl<OrderDetails>(OrderDetails.class);
//	}
//	
	@Autowired
    public void setDao(GenericDaoImpl<OrderDetails> svc){
        this.dao=svc;
    }
	public void add(OrderDetails obj) {
		dao.save(obj);
	}

	public OrderDetails find(String id) {
		return dao.find(id);
	}
	
	public List<OrderDetails> findByColumn(String column, String value) {
		return dao.findByColumn(column, value, OrderDetails.class);
	}

	public void delete(OrderDetails obj) {
		dao.delete(obj);
		
	}

	public void update(OrderDetails obj) {
		dao.saveOrUpdate(obj);
	}

}
