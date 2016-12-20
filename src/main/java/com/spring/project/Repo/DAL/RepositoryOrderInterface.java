package com.spring.project.Repo.DAL;

import com.spring.project.Data.Order;

public interface RepositoryOrderInterface {
	public void add(Order obj);
    public Order find(String id);
    public void delete(Order obj);
    public void update(Order obj);
}
