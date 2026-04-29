package com.nit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.service.IDoctorManagementService;
import com.nit.vo.DoctorVo;

@RestController
@RequestMapping("/Doctor-api")
public class DoctorOperationRestController {
	
	@Autowired
	private IDoctorManagementService dm;

	@PostMapping("/registerDoctor")
	public ResponseEntity<String> saveDoctor(@RequestBody DoctorVo vo){
		
			return new ResponseEntity<String>(dm.registerDoctor(vo),HttpStatus.CREATED);
		
	}
	@PostMapping("/saveAll")
	public ResponseEntity<String> saveDoctor(@RequestBody List<DoctorVo> vo){
		
			return new ResponseEntity<String>(dm.registerDoctors(vo),HttpStatus.CREATED);	
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> showDoctorById(@PathVariable int id ){
			return new ResponseEntity<>(dm.showDoctorById(id),HttpStatus.OK);
	}
	
	@GetMapping("/showAllDoctors")
	public ResponseEntity<List<DoctorVo>> showAllDoctors(){
		return new ResponseEntity<>(dm.showAllDoctors(),HttpStatus.OK);
	}
	
	@PatchMapping("/hikeFeeById/{id}/{hp}")
	public ResponseEntity<String> hikeDoctorFeeById(@PathVariable int id,@PathVariable float hp){
			return new ResponseEntity<String>(dm.hikeDoctorFeeById(id, hp),HttpStatus.OK);
	}
	
	@PutMapping("/updateDoctorDetails")
	public ResponseEntity<String> updateDoctorDetails(@RequestBody DoctorVo vo){
			return new ResponseEntity<String>(dm.updateDocterDetails(vo),HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable int id){
		return new ResponseEntity<String>(dm.deleteDoctorbyId(id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteByFeeRange/{start}/{end}")
	public ResponseEntity<String> deleteDoctorsByFeeRange(@PathVariable float start,@PathVariable float end){
		return new ResponseEntity<String>(dm.deleteDoctorsByFeeRange(start, end),HttpStatus.OK);
		
	}
}
