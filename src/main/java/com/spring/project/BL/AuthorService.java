package com.spring.project.BL;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.Data.Author;
import com.spring.project.Data.Book;
import com.spring.project.Repo.DAL.RepositoryAuthorInterface;
@Service("authorService")
@Transactional
public class AuthorService implements IAuthorService{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private RepositoryAuthorInterface repositoryAuthor;
	  
		public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	    public SessionFactory getSessionFactory() {
	        if (sessionFactory == null)
	            throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
	        return sessionFactory;
	    }
	
	@Override
	public List<Author> findAll() {
		List authors = getSessionFactory().getCurrentSession().createCriteria(Author.class)
			    .addOrder( Order.asc("firstname") )
			    .list();
			    return authors;
	
	}
	
	@Override
	public Author find(String id) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Author.class);
		Author b = (Author)criteria.add(Restrictions.eq("authorID",id)).uniqueResult();
		return b;
	
	}
	
	@Override
	public List<Author> findB(String id) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Book.class);
		Book b = (Book)criteria.add(Restrictions.eq("bookID",id)).uniqueResult();
		Set<Author> authors = b.getAuthors();
		List<Author> as = new ArrayList<>();
		for (Author s : authors) {
			Author a = this.find(s.getAuthorID());
			as.add(a);
		}
		return as;
	
	}
	
	@Override
	public void add(Author obj) {
		repositoryAuthor.add(obj);
		
	}


}
