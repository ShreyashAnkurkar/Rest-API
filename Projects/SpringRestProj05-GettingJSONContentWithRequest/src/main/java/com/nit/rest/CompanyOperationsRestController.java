package com.nit.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.Company;
import com.nit.model.Employee;

@RestController
@RequestMapping("/company-api")
public class CompanyOperationsRestController {

	@PostMapping("/addCompany")
	public ResponseEntity<String> addCompany(@RequestBody Company company){
		System.out.println("CompanyOperationsRestController.addCompany() Data-->"+company);
		return new ResponseEntity<String>("Company Added successfully::"+company,HttpStatus.CREATED);
	}
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		System.out.println("CompanyOperationsRestController.addEmployee() Data-->"+employee);
		return new ResponseEntity<String>("Employee Added successfully::"+employee,HttpStatus.CREATED);
	}
	
	@PostMapping("/regester-companies")
	public ResponseEntity<String> registerMultipleCompanies(@RequestBody List<Company> list){
      System.out.println("CompanyOperationsRestController.registerMultipleCompanies()");
		return new ResponseEntity<String>(list.size()+"Companies added:: "+list,HttpStatus.CREATED);
	}
}
