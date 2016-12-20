package com.spring.project.BL;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.Data.Author;
import com.spring.project.Data.Book;
import com.spring.project.Repo.DAL.RepositoryBookInterface;
@Service("bookService")
@Transactional
public class BookService implements IBookService{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private RepositoryBookInterface repositoryBook;
	  
		public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	    public SessionFactory getSessionFactory() {
	        if (sessionFactory == null)
	            throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
	        return sessionFactory;
	    }
	@Override
	public List<Book> meilleuresVentes() {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Book.class);
		criteria.addOrder(Order.desc("nbCopieVendu"))
				.setMaxResults(4);
		List<Book > list = (List<Book >)criteria.list();
		return list;
	}
	

	@Override
	public List<Book> rechercheRapide(String title) {
		Query query = sessionFactory.getCurrentSession().createQuery("select b from Book b where b.title like :x");
		query.setParameter("x", "%"+title+"%");
		return (List<Book>)query.list();
	}
	@Override
	public List<Book> rechercheTheme(String theme) {
		Query query = sessionFactory.getCurrentSession().createQuery("select b from Book b where b.theme like :x");
		query.setParameter("x", "%"+theme+"%");
		return (List<Book>)query.list();
	}


	@Override
	public List<Book> rechercheAvancee(String title, String authorName) {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Book.class);
		criteria.add(Restrictions.eq("title",title));
		Criteria criteria2 = criteria.createCriteria("authors");
		criteria2.add(Restrictions.eq("nom", authorName));
		return (List<Book>)criteria.list();
	}

	@Override
	public List<Book> lesPlusRecents() {
		
			Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Book.class);
			criteria.addOrder(Order.desc("publish_date"))
					.setMaxResults(4);
			return (List<Book>)criteria.list();
	
	}
	@Override
	public List<Book> PrixDecroissant() {
		
		List books = getSessionFactory().getCurrentSession().createCriteria(Book.class)
			    .addOrder( Order.desc("prix") )
			    .setMaxResults(50)
			    .list();
			    return books;
	}
	@Override
	public List<Book> PrixCroissant() {
		List books = getSessionFactory().getCurrentSession().createCriteria(Book.class)
			    .addOrder( Order.asc("prix") )
			    .setMaxResults(50)
			    .list();
			    return books;
	
	}
	
	@Override
	public List<Book> findAll() {
		List books = getSessionFactory().getCurrentSession().createCriteria(Book.class)
			    .addOrder( Order.asc("prix") )
			    .list();
			    return books;
	
	}
	
	@Override
	public Book find(String id) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Book.class);
		Book b = (Book)criteria.add(Restrictions.eq("bookID",id)).uniqueResult();
		b.setAuthors(b.getAuthors());
		return b;
	
	}
	
	@Override
	public Set<Author> findAuthors(String id) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Book.class);
		Book b = (Book)criteria.add(Restrictions.eq("bookID",id)).uniqueResult();
		return b.getAuthors();
	
	}
	
	@Override
	public void add(Book obj) {
		repositoryBook.add(obj);
		
	}
	
	@Override
	public void update(Book obj) {
		repositoryBook.update(obj);
		
	}
	@Override
	public List<List<String>> findAllThemes() {
		List<String> list = repositoryBook.findAllThemes();
		List<List<String>> result = new ArrayList<>();
		List<String> newlist = new ArrayList<>();
		for (int i=0; i<list.size(); i++){
			if(i%4==0 && i>0){
				result.add(newlist);
				newlist = new ArrayList<>();
			}
			newlist.add(list.get(i));
		}
		result.add(newlist);
		return result;
	}


}
