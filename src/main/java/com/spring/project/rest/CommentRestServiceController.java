package com.spring.project.rest;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.BL.IBookService;
import com.spring.project.BL.ICommentService;
import com.spring.project.Data.Book;
import com.spring.project.Data.Comment;

@RestController
@RequestMapping("/service")
public class CommentRestServiceController {
	@Autowired
	private ICommentService commentService;
	
	@Autowired
	private IBookService bookService;
	
	public CommentRestServiceController() {
	}
		
	@RequestMapping(value="/comments", method=RequestMethod.GET)
    public ResponseEntity<List<Comment>> getComments(HttpServletRequest request) {
        if(request.getParameter("id")!=null)
        {
        return new ResponseEntity<List<Comment>>(commentService.findAll(request.getParameter("id")), HttpStatus.OK);
        }
        return null;
    }
	
	@RequestMapping(value="/comment/add", method=RequestMethod.GET)
    public void postComment(HttpServletRequest request) {
        if(request.getParameter("id")!=null)
        {
        	Book b = bookService.find(request.getParameter("id"));
        	Comment c = new Comment();
        	c.setBook(b);
        	c.setCommenterEmail(request.getParameter("email"));
        	c.setCommenterName(request.getParameter("name"));
        	c.setContenu(request.getParameter("content"));
        	c.setCommentDate(new Date(new Date().getTime()));
        	commentService.add(c);
        }
        return;
    }
}
