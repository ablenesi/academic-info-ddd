package edu.ubb.uma.domain.service;

import javax.ejb.Remote;

@Remote
public interface MockService {
	
	public static final String BEAN_NAME = "ejb/MockService";
	
	public void mockEverything();

}
