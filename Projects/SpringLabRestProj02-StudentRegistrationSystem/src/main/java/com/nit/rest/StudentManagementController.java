package com.nit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.Student;

@RestController
@RequestMapping("/student")
public class StudentManagementController {

	@GetMapping("/getStudents")
	public ResponseEntity<String> getStudent(){
		return new ResponseEntity<String>("All students fetch",HttpStatus.OK);
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student student){
		return new ResponseEntity<String>("Student added"+student.toString(),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<String> updateStudent(){
		return new ResponseEntity<String>("Student updated successfully",HttpStatus.OK);
	}
}
