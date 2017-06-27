package edu.ubb.uma.backend.service;

import javax.ejb.Remote;

import edu.ubb.uma.backend.model.Role;

@Remote
public interface RoleService extends AbstractService<Role> {

	public static final String BEAN_NAME = "ejb/RoleService";
	
}
