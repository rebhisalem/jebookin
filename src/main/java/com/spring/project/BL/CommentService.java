package com.spring.project.BL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.Data.Book;
import com.spring.project.Data.Comment;
import com.spring.project.Data.Customer;
import com.spring.project.Repo.DAL.RepositoryCommentInterface;
@Service("commentService")
@Transactional
public class CommentService implements ICommentService{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private RepositoryCommentInterface repositoryComment;
	  
		public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	    public SessionFactory getSessionFactory() {
	        if (sessionFactory == null)
	            throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
	        return sessionFactory;
	    }
		
	@Override
	public List<Comment> findAll(String id) {
		//Book b = (Book) getSessionFactory().getCurrentSession().createCriteria(Book.class).add(Restrictions.eq("bookID", id)).uniqueResult();
		List<Comment> comments = (List<Comment>) getSessionFactory().getCurrentSession().createQuery("select c from Comment c where c.book.bookID="+id).list();
		System.out.println(comments);
	    return comments;
	
	}
	
	@Override
	public Customer findCustomer(String id) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Customer.class);
		Customer b = (Customer)criteria.add(Restrictions.eq("customerID",id)).uniqueResult();
		return b;
	
	}
	
	@Override
	public void add(Comment obj) {
		repositoryComment.add(obj);
		
	}


}
