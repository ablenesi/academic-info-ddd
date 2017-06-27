package edu.ubb.uma.backend.repo;

public class RepositoryException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public RepositoryException(String message, Exception cause){
		super(message, cause);
	}

}
