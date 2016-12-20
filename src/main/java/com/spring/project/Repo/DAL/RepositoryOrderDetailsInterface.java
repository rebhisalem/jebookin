package com.spring.project.Repo.DAL;

import com.spring.project.Data.OrderDetails;

public interface RepositoryOrderDetailsInterface {
	public void add(OrderDetails obj);
    public OrderDetails find(String id);
    public void delete(OrderDetails obj);
    public void update(OrderDetails obj);
}
