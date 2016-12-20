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

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1740931892979799712L;

	@Id
	@Column(name = "orderID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderID;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "order_date")
	private String order_date;
	
	public Order() {
		super();
	}

	public Order(int orderID, String status, String order_date) {
		super();
		this.orderID = orderID;
		this.status = status;
		this.order_date = order_date;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", status=" + status
				+ ", order_date=" + order_date
				+ "]";
	}
	
	
	
}
