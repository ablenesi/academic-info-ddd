package edu.ubb.uma.backend.repo;

import javax.ejb.Local;

import edu.ubb.uma.backend.model.Role;

@Local
public interface RoleRepository extends AbstractRepository<Role> {
	
	public static final String BEAN_NAME = "ejb/RoleRepository";

}
