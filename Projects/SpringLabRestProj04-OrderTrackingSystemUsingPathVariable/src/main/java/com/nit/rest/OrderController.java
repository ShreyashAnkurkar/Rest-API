package com.nit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.service.OrderService;

@RestController
@RequestMapping("/order-api")
public class OrderController {

	@Autowired
	private OrderService os;
	
	@GetMapping("/getStatus/{id}")
	public ResponseEntity<String> getStatus(@PathVariable int id){
		
		return new ResponseEntity<String>(os.getStatus(id),HttpStatus.OK);
	}
}
