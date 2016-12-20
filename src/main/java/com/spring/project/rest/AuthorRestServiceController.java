package com.spring.project.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.BL.IAuthorService;
import com.spring.project.Data.Author;
@RestController
@RequestMapping("/service")
public class AuthorRestServiceController {
	@Autowired
	private IAuthorService authorService;
	
	public AuthorRestServiceController() {
	}
	
	@RequestMapping(value="/authors", method=RequestMethod.GET)
    public ResponseEntity<List<Author>> books() {
		List<Author> authors = authorService.findAll();
        return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
    }
	
	@RequestMapping(value="/author", method=RequestMethod.GET)
    public ResponseEntity<Author> author(HttpServletRequest request) {
        if(request.getParameter("id")!=null)
        {
        return new ResponseEntity<Author>(authorService.find(request.getParameter("id")), HttpStatus.OK);
        }
        return null;
    }
	
	@RequestMapping(value="/authorsB", method=RequestMethod.GET)
    public ResponseEntity<List<Author>> authorsB(HttpServletRequest request) {
        if(request.getParameter("id")!=null)
        {
        return new ResponseEntity<List<Author>>(authorService.findB(request.getParameter("id")), HttpStatus.OK);
        }
        return null;
    }
}
