package com.spring.project.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="\"carte_bancaire\"")
public class CarteBancaire {

	@Id
	private int numero;
	private String type;
	private Date dateValidite;
	@OneToOne(cascade=CascadeType.ALL)
	private Customer customer;
	
		//getters and setters
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateValidite() {
		return dateValidite;
	}
	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
