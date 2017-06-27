package edu.ubb.uma.backend.service;

import javax.ejb.Remote;

import edu.ubb.uma.backend.model.User;

@Remote
public interface UserService extends AbstractService<User> {
	
	public static final String BEAN_NAME = "ejb/UserService";
	
	public boolean authenticate(User user);
	
}
