package com.spring.project.BL;

import java.util.List;
import java.util.Set;

import com.spring.project.Data.Author;
import com.spring.project.Data.Book;

public interface IBookService {
	public List<Book> meilleuresVentes();
	public List<Book> rechercheRapide(String title);
	public List<Book> rechercheAvancee(String title, String auteurName);
	public List<Book> lesPlusRecents();
	public List<Book> rechercheTheme(String theme);
	public List<Book> PrixDecroissant();
	public List<Book> PrixCroissant();
	
	public void add(Book obj);
	public List<Book> findAll();
	public Book find(String id);
	public Set<Author> findAuthors(String id);
	public List<List<String>> findAllThemes();
	void update(Book obj);
}
