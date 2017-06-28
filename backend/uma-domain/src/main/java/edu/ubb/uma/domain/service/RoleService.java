package edu.ubb.uma.domain.service;

import javax.ejb.Remote;

import edu.ubb.uma.domain.model.Role;

@Remote
public interface RoleService extends AbstractService<Role> {

	public static final String BEAN_NAME = "ejb/RoleService";
	
}
