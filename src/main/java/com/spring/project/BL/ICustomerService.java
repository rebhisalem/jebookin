package com.spring.project.BL;

import java.util.List;

import com.spring.project.Data.Customer;
import com.spring.project.Data.Order;

public interface ICustomerService {
	public void add(Customer obj);

	public boolean login(String login, String pwd);

	public void register(String login, String pwd, String firstname, String lastname, String phone, String email);

	boolean exist(String login, String email);

	public boolean exist(String parameter);

	public List<Customer> find(String login);

	void addOrder(Order o, String login);
   

}
