package com.spring.project.Repo.DAL;

import java.util.List;

import com.spring.project.Data.Book;

public interface RepositoryBookInterface {
	public void add(Book obj);
    public Book find(String id);
    public List<Book> findAll();
    public void delete(Book obj);
    public void update(Book obj);
    public List<String> findAllThemes();
}
