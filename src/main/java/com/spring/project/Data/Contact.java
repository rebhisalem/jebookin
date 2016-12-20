package com.spring.project.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "contact")
public class Contact  implements Serializable{

	@Id
	@Column(name = "contactID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int contactID;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String subject;
	@Column
	private String msg;
	@Temporal(TemporalType.DATE)
	private Date contact_date;
	
	public int getContactID() {
		return contactID;
	}
	public void setContactID(int contactID) {
		this.contactID = contactID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getContact_date() {
		return contact_date;
	}
	public void setContact_date(Date contact_date) {
		this.contact_date = contact_date;
	}
	public Contact() {
		super();
	}
	
	
}
