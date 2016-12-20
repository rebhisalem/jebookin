package com.spring.project.Repo.DAL;

import java.util.List;

import com.spring.project.Data.Customer;

public interface RepositoryCustomerInterface {
	public void add(Customer obj);
    public Customer find(String id);
    public void delete(Customer obj);
    public void update(Customer obj);
    public boolean login(String login, String pwd);
    public List<Customer> findByColumn(String column, String value);
}
