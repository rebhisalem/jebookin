package com.spring.project.rest;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.BL.IContactService;
import com.spring.project.Data.Contact;

@RestController
@RequestMapping("/service")
public class ContactRestServiceController {
	@Autowired
	private IContactService contactService;
	
	public ContactRestServiceController() {
	}
		

	@RequestMapping(value="/contact", method=RequestMethod.GET)
    public ResponseEntity<String> postComment(HttpServletRequest request) {
        if(request.getParameter("name")!=null && !request.getParameter("name").equals("") && request.getParameter("email")!=null && !request.getParameter("email").equals("") && request.getParameter("subject")!=null && !request.getParameter("subject").equals("") && request.getParameter("msg")!=null && !request.getParameter("msg").equals(""))
        {
        	Contact c = new Contact();
        	c.setEmail(request.getParameter("email"));
        	c.setName(request.getParameter("name"));
        	c.setSubject(request.getParameter("subject"));
        	c.setMsg(request.getParameter("msg"));
        	c.setContact_date(new Date(new Date().getTime()));
        	contactService.add(c);
        	return  new ResponseEntity<String>("{ \"response\" : \"Merci pour nous contacter, nous vous conterons le plus tot possible.\" }", HttpStatus.OK);
        }
        else{
        	return  new ResponseEntity<String>("{ \"response\" : \"Un ou plusieurs champs vides!\" }", HttpStatus.OK);
        }
    }
}
