package edu.ubb.uma.backend.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.uma.backend.model.Role;
import edu.ubb.uma.backend.repo.RepositoryException;
import edu.ubb.uma.backend.repo.RoleRepository;
import edu.ubb.uma.backend.service.RoleService;
import edu.ubb.uma.backend.service.ServiceException;

@Stateless(mappedName = RoleService.BEAN_NAME)
public class RolseServiceBean implements RoleService {
	
	private static final Logger LOG = LoggerFactory.getLogger(RolseServiceBean.class);

	@EJB
	private RoleRepository roleRepository;

	@Override
	public Role findById(Long id) throws ServiceException {
		try {
			return roleRepository.findById(id);
		} catch (RepositoryException e) {
			LOG.error("FindById failed", e);
			throw new ServiceException("FindById failed", e);
		}
	}

	@Override
	public List<Role> findAll() throws ServiceException {
		try {
			return roleRepository.findAll();
		} catch (RepositoryException e) {
			LOG.error("FindAll failed", e);
			throw new ServiceException("FindAll failed", e);
		}
	}

	@Override
	public void save(Role role) throws ServiceException {
		LOG.info("creating role {" + role + "}");
		try {
			roleRepository.save(role);
		} catch (RepositoryException e) {
			LOG.error("Save failed", e);
			throw new ServiceException("Save failed", e);
		}
	}

	@Override
	public void delete(Long id) throws ServiceException {
		LOG.info("Deleting user with id: " + id);
		try {
			roleRepository.delete(id);
		} catch (RepositoryException e) {
			LOG.error("Save failed", e);
			throw new ServiceException("Save failed", e);
		}
	}

	@Override
	public void update(Role role) throws ServiceException {
		LOG.info("Updateing user: {" + role + "}");
		try{
			roleRepository.update(role);
		} catch (RepositoryException e) {
			LOG.error("Update failed", e);
			throw new ServiceException("Update failed", e);
		}
	}

}
