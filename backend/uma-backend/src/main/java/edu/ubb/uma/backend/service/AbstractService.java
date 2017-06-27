package edu.ubb.uma.backend.service;

import java.util.List;

public interface AbstractService<T> {
	
	T findById(Long id) throws ServiceException;
	
	List<T> findAll() throws ServiceException;
	
	void save(T data) throws ServiceException;
	
	void delete(Long id) throws ServiceException;
	
	void update(T data) throws ServiceException;

}
