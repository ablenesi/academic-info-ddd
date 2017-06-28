package edu.ubb.uma.api;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

@Local
public interface MockResource {
	public static final String BEAN_NAME = "ejb/MockResource";
	
	Response mockEverything() throws ApiException;

}
