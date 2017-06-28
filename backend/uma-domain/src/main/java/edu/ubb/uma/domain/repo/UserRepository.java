package edu.ubb.uma.domain.repo;

import javax.ejb.Local;

import edu.ubb.uma.domain.model.User;

@Local
public interface UserRepository extends AbstractRepository<User>{
	
	public static final String BEAN_NAME = "ejb/UserRepository";
	
	public boolean authenticate(User user);
}