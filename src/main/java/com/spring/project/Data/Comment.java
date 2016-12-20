package com.spring.project.Data;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Comment {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long commentId;
	@Column
	private String contenu;
	@Column
	private Date CommentDate;
	@Column
	private String CommenterName;
	@Column
	private String CommenterEmail;
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	private Book book;
	public Long getCommentId() {
		return commentId;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getCommenterName() {
		return CommenterName;
	}

	public String getCommenterEmail() {
		return CommenterEmail;
	}

	public void setCommenterEmail(String commenterEmail) {
		CommenterEmail = commenterEmail;
	}

	public void setCommenterName(String commenterName) {
		CommenterName = commenterName;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getCommentDate() {
		return CommentDate;
	}
	public void setCommentDate(Date commentDate) {
		CommentDate = commentDate;
	}
	
}
