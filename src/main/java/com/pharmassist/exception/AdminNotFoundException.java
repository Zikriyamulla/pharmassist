package com.pharmassist.exception;

@SuppressWarnings("serial")
public class AdminNotFoundException extends RuntimeException{
	
	private final String message;

	public AdminNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
