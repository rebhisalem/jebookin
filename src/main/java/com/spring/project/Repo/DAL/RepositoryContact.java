package com.spring.project.Repo.DAL;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.Data.Contact;
import com.spring.project.genericdao.DAL.GenericDaoImpl;
@Transactional
@Repository("ContactDao")
public class RepositoryContact implements RepositoryContactInterface{
	@Autowired
	private GenericDaoImpl<Contact> dao;
	

	
    public void setDao(GenericDaoImpl<Contact> svc){
        this.dao=svc;
    }

	public void add(Contact obj) {
		dao.save(obj);
	}

}
