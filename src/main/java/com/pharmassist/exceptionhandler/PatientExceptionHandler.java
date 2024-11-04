package com.pharmassist.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pharmassist.exception.NoPatientFoundException;
import com.pharmassist.exception.PatientNotFoundException;
import com.pharmassist.util.AppResponseBuilder;
import com.pharmassist.util.ErrorStructure;


@RestControllerAdvice
public class PatientExceptionHandler {
	private final AppResponseBuilder responseBuilder;

	public PatientExceptionHandler(AppResponseBuilder responseBuilder) {
		super();
		this.responseBuilder = responseBuilder;
	}
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ErrorStructure<String>> handlePatientNotFoundException(PatientNotFoundException ex){
		return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Patient not found by id");
		
	}
	@ExceptionHandler(NoPatientFoundException.class)
	public ResponseEntity<ErrorStructure<String>> handleNoPatientFoundException(NoPatientFoundException ex){
		return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Patients not found in request creiteria");
		
	}

}
