package com.spring.project.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.metamodel.Type.PersistenceType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "book")
public class Book implements Serializable{

	/**
	 * 
	 */
	@Id
	@Column(name = "bookID", nullable=false)
	private String bookID;
	private static final long serialVersionUID = 6939654653182412624L;

	private String title;
	@Temporal(TemporalType.DATE)
	private Date publish_date;
	@Column
	private int nbCopieVendu ;
	@Column
	private int stock ;
	@Column
	private double prix ; 
	@Column
	private String theme ;
	@Column(length = 65535,columnDefinition="Text")
	private String description ;
	@Column 
	private String url ;
	@JsonIgnore
	@OneToMany(mappedBy="book",cascade=CascadeType.ALL)
	private List<Comment> commentaires;
	
	public List<Comment> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Comment> commentaires) {
		this.commentaires = commentaires;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTheme() {
		return theme;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookID() {
		return bookID;
	}
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "book_author", joinColumns = {@JoinColumn(name = "bookID")}, inverseJoinColumns = { @JoinColumn(name = "authorID") })
	private Set<Author> authors = new HashSet<Author>();
	@JsonIgnore
	public Set<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	
	@Column(name = "publish_date")
	@Temporal(javax.persistence.TemporalType.DATE)
	public Date getPublish_date() {
		return publish_date;
	}
	public Book() {
	}

	public Book(String id, String title, Date publish_date) {
		this.bookID = id;
		this.title = title;
		this.publish_date = publish_date;
	}
	public Book(String id, String title, Date publish_date,int nb, double prix, String theme) {
		this.bookID = id;
		this.title = title;
		this.publish_date = publish_date;
		this.nbCopieVendu=nb;
		this.prix = prix; 
		this.theme = theme ; 
	}

	public Book(String title, Date publish_date, int nbCopieVendu, double prix, String theme, String url,
			String bookID) {
		super();
		this.title = title;
		this.publish_date = publish_date;
		this.nbCopieVendu = nbCopieVendu;
		this.prix = prix;
		this.theme = theme;
		this.url = url;
		this.bookID = bookID;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}



	

	public int getNbCopieVendu() {
		return nbCopieVendu;
	}

	public void setNbCopieVendu(int nbCopieVendu) {
		this.nbCopieVendu = nbCopieVendu;
	}

	@Override
	public String toString() {
		return "Book [id=" + bookID + ", title=" + title + ", publish_date="
				+ publish_date + "]";
	}
	
	
}
