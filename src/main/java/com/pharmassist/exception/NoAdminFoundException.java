package com.pharmassist.exception;

@SuppressWarnings("serial")
public class NoAdminFoundException extends RuntimeException{
	private final String message;

	public NoAdminFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
