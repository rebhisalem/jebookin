package com.spring.project.Repo.DAL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.Data.Book;
import com.spring.project.genericdao.DAL.GenericDaoImpl;

//@Repository("BookDao")
@Repository("repositoryBook")
@Transactional
public class RepositoryBook implements RepositoryBookInterface{
	@Autowired
	private GenericDaoImpl<Book> dao;
	

	
    public void setDao(GenericDaoImpl<Book> svc){
        this.dao=svc;
    }

	public void add(Book obj) {
		dao.save(obj);
	}
	public Book find(String id) {
		return dao.find(id);
	}
	
	public List<Book> findByColumn(String column, String value) {
		return dao.findByColumn(column, value, Book.class);
	}
	
	public List<Book> findAll() {
		return dao.findAll(Book.class);
	}

	public List<String> findAllThemes() {
		return dao.findAllThemes(Book.class);
	}
	
	public void delete(Book obj) {
		dao.delete(obj);
		
	}

	public void update(Book obj) {
		dao.saveOrUpdate(obj);
	}



}
