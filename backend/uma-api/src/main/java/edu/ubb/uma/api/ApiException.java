package edu.ubb.uma.api;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApiException(String message, Exception cause){
		super(message, cause);
	}
}
