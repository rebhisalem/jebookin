package com.spring.project.BL;

import java.util.List;

import com.spring.project.Data.Comment;
import com.spring.project.Data.Customer;

public interface ICommentService {
	public void add(Comment obj);
	public Customer findCustomer(String id);
	public List<Comment> findAll(String id);
}
