package com.pharmassist.exception;

@SuppressWarnings("serial")
public class NoPatientFoundException extends RuntimeException{
	private final String message;

	public NoPatientFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
