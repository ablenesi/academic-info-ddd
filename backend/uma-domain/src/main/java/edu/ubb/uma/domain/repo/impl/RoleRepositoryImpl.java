package edu.ubb.uma.domain.repo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.uma.domain.model.Role;
import edu.ubb.uma.domain.repo.RepositoryException;
import edu.ubb.uma.domain.repo.RoleRepository;

@Stateless(mappedName = RoleRepository.BEAN_NAME)
public class RoleRepositoryImpl implements RoleRepository{
	

	private static final String PERSISTENCE_UNIT_NAME = "umaPu";
	private static final Logger LOG = LoggerFactory.getLogger(RoleRepositoryImpl.class);

	@PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
	EntityManager entityManager;


	@Override
	public Role findById(Long id) throws RepositoryException {
		try {
			return entityManager.find(Role.class, id);
		} catch (IllegalArgumentException e) {
			LOG.error("FindById failed", e);
			throw new RepositoryException("FindById failed", e);
		}
	}

	@Override
	public List<Role> findAll() throws RepositoryException {
		try {
			return entityManager.createNamedQuery("findAllRole", Role.class).getResultList();
		} catch (PersistenceException e) {
			LOG.error("FindAll failed", e);
			throw new RepositoryException("FindAll failed", e);
		}
	}

	@Override
	public void save(Role role) throws RepositoryException {
		try {
			entityManager.persist(role);
			entityManager.flush();
		} catch (IllegalArgumentException | EntityExistsException e) {
			LOG.error("Save failed", e);
			throw new RepositoryException("Save failed", e);
		}		
	}

	@Override
	public void delete(Long id) throws RepositoryException {
		Role role = findById(id);
		try {
			entityManager.remove(role);
			entityManager.flush();
		} catch (IllegalArgumentException e) {
			LOG.error("Delete failed", e);
			throw new RepositoryException("Delete failed", e);
		}	
	}

	@Override
	public void update(Role role) throws RepositoryException {		
		Role persistedRole = findById(role.getId());
		persistedRole.setRole(role.getRole());
		persistedRole.setDescription(role.getDescription());		
				
		try {			
			entityManager.refresh(role);
			entityManager.flush();
		} catch (EntityNotFoundException | IllegalArgumentException  e) {
			LOG.error("Update failed", e);
			throw new RepositoryException("Update failed", e);
		}
	}

}
