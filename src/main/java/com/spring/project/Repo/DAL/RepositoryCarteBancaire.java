package com.spring.project.Repo.DAL;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.Data.CarteBancaire;
import com.spring.project.genericdao.DAL.GenericDaoImpl;
@Transactional
@Repository("CarteBancaireDao")
public class RepositoryCarteBancaire implements RepositoryCarteBancaireInterface{
	
	private GenericDaoImpl<CarteBancaire> dao;

	@Autowired
    public void setDao(GenericDaoImpl<CarteBancaire> svc){
        this.dao=svc;
    }
	

	
	public void add(CarteBancaire obj) {
		dao.save(obj);
	}
	public CarteBancaire find(String id) {
		return dao.find(id);
	}
	
	public List<CarteBancaire> findByColumn(String column, String value) {
		return dao.findByColumn(column, value, CarteBancaire.class);
	}

	public void delete(CarteBancaire obj) {
		dao.delete(obj);
		
	}

	public void update(CarteBancaire obj) {
		dao.saveOrUpdate(obj);
	}

}



