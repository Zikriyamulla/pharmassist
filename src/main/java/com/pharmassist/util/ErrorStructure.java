package com.pharmassist.util;

public class ErrorStructure <T>{
	private int status;
	private String message;
	private T rootCouse;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getRootCouse() {
		return rootCouse;
	}
	public void setRootCouse(T rootCouse) {
		this.rootCouse = rootCouse;
	}
	public static <T>ErrorStructure<T> create(int status, String message, T rootCouse) {
		ErrorStructure<T> error=new ErrorStructure<T>();
		error.setStatus(status);
		error.setMessage(message);
		error.setRootCouse(rootCouse);
		return error;
	}
}
