package edu.ubb.uma.domain.service;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ServiceException(String message, Exception cause){
		super(message, cause);
	}

}
