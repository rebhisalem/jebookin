package com.spring.project.Repo.DAL;

import com.spring.project.Data.Author;

public interface RepositoryAuthorInterface {
	public void add(Author obj);
    public Author find(String id);
    public void delete(Author obj);
    public void update(Author obj);
}
