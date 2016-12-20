package com.spring.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
	@RequestMapping(value="/index") 
	public String index ()
	{
		return "index.jsp" ;
		
	}

	@RequestMapping(value="/") 
	public String index2 ()
	{
		return "index.jsp" ;
		
	}
	
	@RequestMapping(value="/contact")
	public String contact(){
		return "contact.jsp";
	}
	
	
}
