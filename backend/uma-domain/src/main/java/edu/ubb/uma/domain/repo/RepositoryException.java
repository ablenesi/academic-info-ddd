package edu.ubb.uma.domain.repo;

public class RepositoryException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public RepositoryException(String message, Exception cause){
		super(message, cause);
	}

}
