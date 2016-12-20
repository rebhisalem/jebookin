package com.spring.project.Data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "author")

public class Author implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6976431353461826958L;

	@Id
	@Column(name = "authorID", nullable=false)
	private String authorID;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "url")
	private String url;
	
	public Author() {
		super();
	}

	public Author(String id, String firstname, String lastname) {
		super();
		this.authorID = id;
		this.firstname = firstname;
		this.lastname = lastname;
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

	public String getAuthorID() {
		return authorID;
	}

	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Author [authorID=" + authorID + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}
}
