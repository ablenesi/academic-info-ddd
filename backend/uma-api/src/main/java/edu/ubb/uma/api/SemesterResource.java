package edu.ubb.uma.api;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

@Local
public interface SemesterResource {
	public static final String BEAN_NAME = "ejb/SemesterResource";
	
	Response findByUser() throws ApiException;
}
