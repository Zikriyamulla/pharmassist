package com.pharmassist.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pharmassist.exception.AdminNotFoundException;
import com.pharmassist.exception.NoAdminFoundException;
import com.pharmassist.util.AppResponseBuilder;
import com.pharmassist.util.ErrorStructure;

@RestControllerAdvice
public class AdminExceptionHandler {
	private final AppResponseBuilder responseBuilder;

	public AdminExceptionHandler(AppResponseBuilder responseBuilder) {
		super();
		this.responseBuilder = responseBuilder;
	}
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ErrorStructure<String>> handleAdminNotFoundById(AdminNotFoundException ex){
		return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Admin not found by id");
	}
	@ExceptionHandler(NoAdminFoundException.class)
	public <T>ResponseEntity<ErrorStructure<String>> handleNoUserFound(NoAdminFoundException ex){
		return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"Admins not found in request reiteria");
		
	}

}
