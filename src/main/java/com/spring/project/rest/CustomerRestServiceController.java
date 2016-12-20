package com.spring.project.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.BL.IBookService;
import com.spring.project.BL.ICustomerService;
import com.spring.project.Data.Book;
import com.spring.project.Data.Customer;
import com.spring.project.Data.Order;

@RestController
@RequestMapping("/service")
public class CustomerRestServiceController {
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IBookService bookService;

	public CustomerRestServiceController() {
	}
	
	@RequestMapping(value="/customer/login", method=RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> login(HttpServletRequest request) {
		if(request.getParameter("login")!=null && !request.getParameter("login").equals("") && request.getParameter("password")!=null && !request.getParameter("password").equals(""))
        {
			if(customerService.login(request.getParameter("login"), request.getParameter("password"))) return  new ResponseEntity<String>("{ \"response\" : \"\" }", HttpStatus.OK);
			else return new ResponseEntity<String>("{ \"response\" : \"Erreur de connexion\" }", HttpStatus.OK);
        }
		return  new ResponseEntity<String>("{ \"response\" : \"Un ou plusieurs champs vides!\" }", HttpStatus.OK);
    }
	
	@RequestMapping(value="/customer/register", method=RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> regster(HttpServletRequest request) {
		if(request.getParameter("login")!=null && !request.getParameter("login").equals("") && request.getParameter("password")!=null && !request.getParameter("password").equals("") && request.getParameter("firstname")!=null && !request.getParameter("firstname").equals("") && request.getParameter("lastname")!=null && !request.getParameter("lastname").equals("") && request.getParameter("email")!=null && !request.getParameter("email").equals("") && request.getParameter("phone")!=null && !request.getParameter("phone").equals(""))
        {
			if(customerService.exist(request.getParameter("login"), request.getParameter("email"))) return  new ResponseEntity<String>("{ \"response\" : \"Login ou email non disponible\" }", HttpStatus.OK);
			else{
				customerService.register(request.getParameter("login"), request.getParameter("password"), request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("phone"), request.getParameter("email"));
				return  new ResponseEntity<String>("{ \"response\" : \"\" }", HttpStatus.OK);
			}
        }
		
		return  new ResponseEntity<String>("{ \"response\" : \"Un ou plusieurs champs vides!\" }", HttpStatus.OK);
    }
	
	@RequestMapping(value="/customer/checkout", method=RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> checkout(HttpServletRequest request) {
		
		if(request.getParameter("login")!=null && !request.getParameter("login").equals("") && request.getParameter("products")!=null && !request.getParameter("products").equals("") && request.getParameter("quantities")!=null && !request.getParameter("quantities").equals(""))
        {
			if(!customerService.exist(request.getParameter("login"))) return  new ResponseEntity<String>("{ \"response\" : \"Ce client n'existe pas\" }", HttpStatus.OK);
			else{
				Customer c = customerService.find(request.getParameter("login")).get(0);
				String products = request.getParameter("products");
				String[] ps = products.split(",");
				
				String quantities = request.getParameter("quantities");
				String[] qs = quantities.split(",");
				Order o = new Order();
				o.setStatus("pending");
				customerService.addOrder(o, request.getParameter("login"));
				for(int i=0; i<ps.length; i++){
					Book b = bookService.find(ps[i]);
					b.setStock(b.getStock()-Integer.parseInt(qs[i]));
					b.setNbCopieVendu(b.getNbCopieVendu()+Integer.parseInt(qs[i]));
					bookService.update(b);
				}

				return  new ResponseEntity<String>("{ \"response\" : \"\" }", HttpStatus.OK);
			}
        }
		
		return  new ResponseEntity<String>("{ \"response\" : \"Un ou plusieurs champs vides!\" }", HttpStatus.OK);
    }
	
}
