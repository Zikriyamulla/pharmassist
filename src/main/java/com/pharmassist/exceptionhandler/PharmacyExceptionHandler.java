package com.pharmassist.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.pharmassist.exception.NoPharmacyFoundException;
import com.pharmassist.exception.PharmacyNotFoundException;
import com.pharmassist.util.AppResponseBuilder;
import com.pharmassist.util.ErrorStructure;

@RestControllerAdvice
public class PharmacyExceptionHandler {
	private final AppResponseBuilder responseBuilder;

	public PharmacyExceptionHandler(AppResponseBuilder responseBuilder) {
		super();
		this.responseBuilder = responseBuilder;
	}
	@ExceptionHandler(PharmacyNotFoundException.class)
	public ResponseEntity<ErrorStructure<String>> handlePharmacyNotFoundById(PharmacyNotFoundException ex){
		return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Pharmacy not found by id");
	}
	
	@ExceptionHandler(NoPharmacyFoundException.class)
	public <T>ResponseEntity<ErrorStructure<String>> handleNoPharmacyFound(NoPharmacyFoundException ex){
		return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"Pharmacies not found in request creiteria");
		
	}
	

}
