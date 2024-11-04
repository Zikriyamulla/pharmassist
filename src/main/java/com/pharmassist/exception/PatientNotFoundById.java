package com.pharmassist.exception;

@SuppressWarnings("serial")
public class PatientNotFoundById extends RuntimeException{
	private final String message;

	public PatientNotFoundById(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
