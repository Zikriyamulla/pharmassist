package com.pharmassist.exception;

@SuppressWarnings("serial")
public class PharmacyNotFoundException extends RuntimeException {
	private final String message;

	public PharmacyNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
