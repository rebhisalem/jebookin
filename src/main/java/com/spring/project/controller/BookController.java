package com.spring.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class BookController {

	@RequestMapping(value="/books") 
	public String Books ()
	{
		return "books.jsp" ;
		
	}
	
	@RequestMapping(value="/books/{id}") 
	public String Book (@PathVariable("id") String id)
	{
		return "book.jsp?id="+id;
		
	}
	@RequestMapping(value="/books/cat/{id}") 
	public String BookByTheme (@PathVariable("id") String id)
	{
		return "books.jsp?cat="+id;
		
	}
	
	@RequestMapping(value="/books/results") 
	public String BookByTitle ()
	{
		return "results.jsp";
		
	}
}
