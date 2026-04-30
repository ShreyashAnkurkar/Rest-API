package com.nit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.service.IEmployeeManagementService;
import com.nit.vo.EmployeeVo;

@RestController
@RequestMapping("/employee-api")
public class EmployeeOperationsRestController {
    @Autowired 
	private IEmployeeManagementService es;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeVo vo){
		  
		try {
			return new ResponseEntity<String>(es.saveEmployee(vo),HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAllEmployees")
	public ResponseEntity<List<EmployeeVo>> findAllEmployees(){
		return new ResponseEntity<List<EmployeeVo>>(es.getAllEmployees(),HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findEmployeeById(@PathVariable int id){
		
		try {
			return new ResponseEntity<EmployeeVo>(es.getEmployeeById(id),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateEmployeeById/{id}")
	public ResponseEntity<String> updateEmployeeById(@PathVariable int id,@RequestBody EmployeeVo vo){
		try {
			return new ResponseEntity<String>(es.updateEmployee(id, vo),HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id){
		
		try {
			return new ResponseEntity<String>(es.deleteEmployee(id),HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
