package com.nit.rest;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/season-api")
public class SeasonFinderOperationsRestController {

	@GetMapping("/showseason")
	public ResponseEntity<String> getSeasonName(){
		
		LocalDate l=LocalDate.now();
		int m=l.getMonthValue();
		String seasonName=null;
		
		
		if(m>3 && m<=6)	{
			seasonName="Summer season";
		}else if(m>6 && m<=9) {
			seasonName="Rainny season";
		}else {
			seasonName="winter Season";
		}
		
		return new ResponseEntity<String>(seasonName,HttpStatus.OK);
			
	}
}
