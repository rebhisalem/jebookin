package com.spring.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CartController {

	@RequestMapping(value="/books/cart") 
	public String Cart ()
	{
		return "cart.jsp" ;
		
	}
	
}
