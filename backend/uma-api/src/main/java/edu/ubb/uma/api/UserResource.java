package edu.ubb.uma.api;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

import edu.ubb.uma.api.dto.UserDTO;
import edu.ubb.uma.domain.model.User;

@Local
public interface UserResource {
	
	public static final String BEAN_NAME = "ejb/UserResource";
	
	Response findById(Long id) throws ApiException;
	
	Response findAll() throws ApiException;
	
	Response save(UserDTO user) throws ApiException;
	
	Response delete(Long id) throws ApiException;
	
	Response update(Long id, UserDTO user) throws ApiException;
	
	Response login(UserDTO userDTO) throws ApiException;
	
	Response findSemestersByUserId(Long id) throws ApiException;
}
