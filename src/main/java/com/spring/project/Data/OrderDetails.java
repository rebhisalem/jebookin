package com.spring.project.Data;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_details")
public class OrderDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderDetails(int quantity) {
		super();
		this.quantity = quantity;
	}

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	private Order order;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	private Book b;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "prix")
	private double prix;

	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetails [quantity=" + quantity+"]";
	}
	
	
}
