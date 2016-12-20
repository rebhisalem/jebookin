package com.spring.project.rest;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.BL.IBookService;
import com.spring.project.Data.Book;

@RestController
@RequestMapping("/service")
public class BookRestServiceController {
	@Autowired
	private IBookService bookService;
	
	public BookRestServiceController() {
	}
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
    public ResponseEntity<List<Book>> books() {
		List<Book> books = bookService.findAll();
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
	
	@RequestMapping(value="/books/themes", method=RequestMethod.GET)
    public ResponseEntity<List<List<String>>> themes() {
		List<List<String>> themes = bookService.findAllThemes();
        return new ResponseEntity<List<List<String>>>(themes, HttpStatus.OK);
    }
	
	@RequestMapping(value="/books/cat", method=RequestMethod.GET)
    public ResponseEntity<List<Book>> booksByTheme(HttpServletRequest request) {
		if(request.getParameter("cat")!=null)
        {
		List<Book> books2 = bookService.rechercheTheme(request.getParameter("cat"));
		
        return new ResponseEntity<List<Book>>(books2, HttpStatus.OK);
        }
		return null;
    }
	
	@RequestMapping(value="/books/title", method=RequestMethod.GET)
    public ResponseEntity<List<Book>> booksByTitle(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("search")!=null)
        {
		List<Book> books2 = bookService.rechercheRapide(request.getParameter("search"));
		
        return new ResponseEntity<List<Book>>(books2, HttpStatus.OK);
        }
		return null;
    }
	
	@RequestMapping(value="/books/featured", method=RequestMethod.GET)
    public ResponseEntity<List<Book>> booksFeatured() {
		List<Book> books2 = bookService.meilleuresVentes();
        return new ResponseEntity<List<Book>>(books2, HttpStatus.OK);
    }
	
	@RequestMapping(value="/books/recent", method=RequestMethod.GET)
    public ResponseEntity<List<Book>> booksRecent() {
		List<Book> books2 = bookService.lesPlusRecents();
        return new ResponseEntity<List<Book>>(books2, HttpStatus.OK);
    }
     
     
    @RequestMapping(value="/book", method=RequestMethod.GET)
    public ResponseEntity<Book> book(HttpServletRequest request) {
        if(request.getParameter("id")!=null)
        {
        return new ResponseEntity<Book>(bookService.find(request.getParameter("id")), HttpStatus.OK);
        }
        return null;
    }
}
