package com.pharmassist.exception;

@SuppressWarnings("serial")
public class PatientNotFoundException extends RuntimeException{
	private final String message;

	public PatientNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
