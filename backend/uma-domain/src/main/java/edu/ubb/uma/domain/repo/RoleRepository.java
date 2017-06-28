package edu.ubb.uma.domain.repo;

import javax.ejb.Local;

import edu.ubb.uma.domain.model.Role;

@Local
public interface RoleRepository extends AbstractRepository<Role> {
	
	public static final String BEAN_NAME = "ejb/RoleRepository";

}
