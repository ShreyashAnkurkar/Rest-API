package com.nit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationRestController {

	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer() {
		System.out.println("CustomerOperationRestController.saveCustomer()");
		return new ResponseEntity<String>("Customer Saved", HttpStatus.CREATED);
	}
	
	@GetMapping("/retrive")
	public ResponseEntity<String> getCustomer(){
		return new ResponseEntity<String>("customer name:Shreyash",HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String>updateCustomer(){
		return new ResponseEntity<String>("Customer Updated successyfully",HttpStatus.OK);
	}
	
	@PatchMapping("/updateEmail")
	public ResponseEntity<String> updateCustomerByEmail(){
		return new ResponseEntity<String>("customer Email Updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> removeCustomer(){
		return new ResponseEntity<String>("customer record deleted",HttpStatus.OK);
	}
}
