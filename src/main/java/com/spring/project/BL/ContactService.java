package com.spring.project.BL;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.Data.Contact;
import com.spring.project.Repo.DAL.RepositoryContactInterface;
@Service("contactService")
@Transactional
public class ContactService implements IContactService{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private RepositoryContactInterface repositoryContact;
	  
		public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	    public SessionFactory getSessionFactory() {
	        if (sessionFactory == null)
	            throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
	        return sessionFactory;
	    }
		
	@Override
	public void add(Contact obj) {
		repositoryContact.add(obj);
	}


}
