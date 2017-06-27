package edu.ubb.uma.api;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

import edu.ubb.uma.api.dto.RoleDTO;


@Local
public interface RoleResource {
	
	public static final String BEAN_NAME = "ejb/RoleResource";
	
	Response findById(Long id) throws ApiException;
	
	Response findAll() throws ApiException;
	
	Response save(RoleDTO role) throws ApiException;
	
	Response delete(Long id) throws ApiException;
	
	Response update(Long id, RoleDTO role) throws ApiException;
}
