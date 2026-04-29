package com.nit.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.Company;
import com.nit.model.Employee;

@RestController
@RequestMapping("/company-api")
public class CompanyOperationsRestController {

	@GetMapping("/companyDetails")
	public ResponseEntity<Company> getCompanyDetails(){
		return new ResponseEntity<Company>(new Company(11,"HCLTech","HYD"),HttpStatus.OK);
	}
	
	@GetMapping("/employeeDetails")
	public ResponseEntity<Employee> getEmployeeDetails(){
		Employee emp=new Employee(101,"Shreyash",new String[] {"Vedant","Vesh","Yash","Vinay"},true,List.of("vedu","veshu","yashu","vinu"),Set.of(122334233234L,334456677L,55667788L,9875654L),
				                       Map.of("AadharNo","12345432","Pan","EJIPA1234"),new Company(11,"HCLTech","Hyd"));
		
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@GetMapping("/allcompanies")
	public ResponseEntity<List<Company>> getAllCompanies(){
		return new ResponseEntity<List<Company>>(List.of(new Company(101,"HCL","HYD"),new Company(102,"TCS","Pune"),new Company(103,"Google","Chennai")),HttpStatus.OK);
	}
	
	
	
	
	
	
}
