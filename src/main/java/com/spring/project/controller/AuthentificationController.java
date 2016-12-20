package com.spring.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AuthentificationController {

	@RequestMapping(value="/login") 
	public String Login ()
	{
		return "login.jsp" ;
		
	}
	
	@RequestMapping(value="/logout") 
	public String Logout ()
	{
		return "logout.jsp" ;
		
	}
	
	@RequestMapping(value="/register") 
	public String Register ()
	{
		return "register.jsp" ;
		
	}
	
}
