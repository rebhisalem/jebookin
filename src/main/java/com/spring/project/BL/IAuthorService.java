package com.spring.project.BL;

import java.util.List;

import com.spring.project.Data.Author;

public interface IAuthorService {
	public void add(Author obj);
	public List<Author> findAll();
	public Author find(String id);
	List<Author> findB(String id);
}
