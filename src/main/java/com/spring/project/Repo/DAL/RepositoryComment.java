package com.spring.project.Repo.DAL;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.Data.Comment;
import com.spring.project.genericdao.DAL.GenericDaoImpl;
@Transactional
@Repository("CommentDao")
public class RepositoryComment implements RepositoryCommentInterface{
	@Autowired
	private GenericDaoImpl<Comment> dao;
	

	
    public void setDao(GenericDaoImpl<Comment> svc){
        this.dao=svc;
    }

	public void add(Comment obj) {
		dao.save(obj);
	}
	public Comment find(String id) {
		return dao.find(id);
	}
	
	public List<Comment> findByColumn(String column, String value) {
		return dao.findByColumn(column, value, Comment.class);
	}

	public void delete(Comment obj) {
		dao.delete(obj);
		
	}

	public void update(Comment obj) {
		dao.saveOrUpdate(obj);
	}


}
