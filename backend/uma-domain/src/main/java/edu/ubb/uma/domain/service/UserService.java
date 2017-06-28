package edu.ubb.uma.domain.service;

import javax.ejb.Remote;

import edu.ubb.uma.domain.model.User;

@Remote
public interface UserService extends AbstractService<User> {
	
	public static final String BEAN_NAME = "ejb/UserService";
	
	public boolean authenticate(User user);
	
}
