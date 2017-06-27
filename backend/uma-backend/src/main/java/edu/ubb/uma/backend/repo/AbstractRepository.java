package edu.ubb.uma.backend.repo;

import java.util.List;

public interface AbstractRepository<T> {

	T findById(Long id) throws RepositoryException;
	
	List<T> findAll() throws RepositoryException;
	
	void save(T data) throws RepositoryException;
	
	void delete(Long id) throws RepositoryException;
	
	void update(T data) throws RepositoryException;
}
