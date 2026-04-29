package com.nit.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nit.exceptions.DoctorNotFoundException;

@RestControllerAdvice
public class DoctorOperationRestControllerAdvice {

	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleDNFE(DoctorNotFoundException dnfe){
		ErrorDetails ed=new ErrorDetails(LocalDateTime.now(), dnfe.getMessage(), "500-->Doctor Not found");
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllException(Exception e){
		ErrorDetails ed=new ErrorDetails(LocalDateTime.now(), e.getMessage(), "500-->Doctor Not found");
				return new ResponseEntity<ErrorDetails>(ed,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
