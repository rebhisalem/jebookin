package com.spring.project.Data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7987540281303780424L;

	@Id
	@Column(name = "customerID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerID;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	private String login ;
	private String password ;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@JsonIgnore
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "customer_order", joinColumns = { @JoinColumn(name = "customerID") }, inverseJoinColumns = { @JoinColumn(name = "orderID") })
	private Set<Order> customerOrders;
	public Set<Order> getCustomerOrders() {
		return this.customerOrders;
	}
	
	public void setCustomerOrders(Set<Order> customerOrders) {
		this.customerOrders = customerOrders;
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Customer(int customerID, String firstname, String lastname,
			String email, String phone) {
		super();
		this.customerID = customerID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phone=" + phone + "]";
	}
		
}
