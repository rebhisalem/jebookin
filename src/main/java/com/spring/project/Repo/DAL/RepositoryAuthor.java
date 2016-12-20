package com.spring.project.Repo.DAL;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.Data.Author;
import com.spring.project.Data.Book;
import com.spring.project.genericdao.DAL.GenericDaoImpl;

@Repository("AuthorDao")
@Transactional
public class RepositoryAuthor implements RepositoryAuthorInterface{
	@Autowired
	private GenericDaoImpl<Author> dao;

	
    public void setDao(GenericDaoImpl<Author> svc){
        this.dao=svc;
    }
	
	public void add(Author obj) {
		dao.save(obj);
	}

	public Author find(String id) {
		return dao.find(id);
	}

	public void delete(Author obj) {
	
		dao.delete(obj);
	}

	public void update(Author obj) {
		dao.saveOrUpdate(obj);
	}

}
