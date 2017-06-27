package edu.ubb.uma.backend.repo;

import javax.ejb.Local;

import edu.ubb.uma.backend.model.User;

@Local
public interface UserRepository extends AbstractRepository<User>{
	
	public static final String BEAN_NAME = "ejb/UserRepository";
		
}
