package com.spring.project.BL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.Data.Customer;
import com.spring.project.Data.Order;
import com.spring.project.Repo.DAL.RepositoryCustomerInterface;
import com.spring.project.Repo.DAL.RepositoryOrderInterface;

@Service("customerService")
@Transactional
public class CustomerService implements ICustomerService {
	@Autowired
	RepositoryCustomerInterface customerrepo;
	
	@Autowired
	RepositoryOrderInterface orderrepo;

	@Override
	public void add(Customer obj) {
		customerrepo.add(obj);

	}
	
	@Override
	public boolean login(String login, String pwd) {
		return customerrepo.login(login, pwd);

	}
	
	@Override
	public List<Customer> find(String login) {
		return customerrepo.findByColumn("login",login);

	}
	
	@Override
	public void register(String login, String pwd, String firstname, String lastname, String phone, String email) {
		Customer c = new Customer();
		c.setEmail(email);
		c.setFirstname(firstname);
		c.setLastname(lastname);
		c.setPhone(phone);
		c.setPassword(pwd);
		c.setLogin(login);
		customerrepo.add(c);
	}
	
	@Override
	public boolean exist(String login, String email){
		if(customerrepo.findByColumn("login", login).isEmpty() && customerrepo.findByColumn("email", email).isEmpty()) return false;
		return true;
		
	}

	@Override
	public boolean exist(String login) {
		if(customerrepo.findByColumn("login", login).isEmpty()) return false;
		return true;
		
	}
	
	@Override
	public void addOrder(Order o, String login){
		orderrepo.add(o);
		this.find(login).get(0).getCustomerOrders().add(o);
	}
	
}
