package com.pharmassist.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pharmassist.exception.NoMedicineFoundException;
import com.pharmassist.util.AppResponseBuilder;
import com.pharmassist.util.ErrorStructure;
@RestControllerAdvice
public class MedicinExceptionHandler {
	private final AppResponseBuilder responseBuilder;

	public MedicinExceptionHandler(AppResponseBuilder responseBuilder) {
		super();
		this.responseBuilder = responseBuilder;
	}
	@ExceptionHandler(NoMedicineFoundException.class)
	public ResponseEntity<ErrorStructure<String>> handleNoMedicineFoundException(NoMedicineFoundException ex){
		return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"Medicines  not found in request reiteria");
		
	}

}
