package com.nit.exceptions;

public class DoctorNotFoundException extends RuntimeException{

	public DoctorNotFoundException(String msg) {
		super(msg);
	}
}
