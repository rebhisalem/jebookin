package com.spring.project.genericdao.DAL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDaoImpl<T> implements GenericDao<T> {

	private Class<T> type;
	@Autowired
	private SessionFactory sessionFactory;

	public GenericDaoImpl() {
		super();
	}

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
		return sessionFactory;
	}

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

	public GenericDaoImpl(Class<T> type) {

		this.type = type;
	}

	public void save(T obj) {
		getSessionFactory().getCurrentSession().save(obj);
		getSessionFactory().getCurrentSession().flush();

	}

	@SuppressWarnings("unchecked")
	public T find(String id) {
		T obj = (T) getSessionFactory().getCurrentSession().get(getType(), id);
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List<T> findByColumn(String column, String value, Class<T> myclass) {

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(myclass);
		List<T> list = criteria.add(Restrictions.eq(column, value)).list();

		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> myclass) {

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(myclass);
		List<T> list = criteria.list();

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<String> findAllThemes( Class<T> originclass) {

		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery("select distinct theme from book order by theme asc");
		List<T> list = query.list();

		return (List<String>) list;
	}

	public void delete(T obj) {

		getSessionFactory().getCurrentSession().delete(obj);

	}

	public void saveOrUpdate(T obj) {

		getSessionFactory().getCurrentSession().saveOrUpdate(obj);
		getSessionFactory().getCurrentSession().flush();

	}
}