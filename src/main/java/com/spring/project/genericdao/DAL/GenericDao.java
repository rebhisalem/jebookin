package com.spring.project.genericdao.DAL;

import java.util.List;

public interface GenericDao<T> {
	public void save(T obj);
    public T find(String id);
    public List<T> findByColumn(String column, String value, Class<T> myclass);
    public List<T> findAll(Class<T> myclass);
    public void delete(T obj);
    public void saveOrUpdate(T obj);
    public List<String> findAllThemes(Class<T> myclass) ;
}
