package edu.ubb.uma.domain.repo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.uma.domain.model.User;
import edu.ubb.uma.domain.repo.RepositoryException;
import edu.ubb.uma.domain.repo.UserRepository;

@Stateless(mappedName = UserRepository.BEAN_NAME)
public class UserRepositoryImpl implements UserRepository {

	private static final String PERSISTENCE_UNIT_NAME = "umaPu";
	private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

	@PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
	EntityManager entityManager;

	@Override
	public User findById(Long id) throws RepositoryException {
		try {
			return entityManager.find(User.class, id);
		} catch (IllegalArgumentException e) {
			LOG.error("FindById failed", e);
			throw new RepositoryException("FindById failed", e);
		}
	}

	@Override
	public List<User> findAll() throws RepositoryException {
		try {
			return entityManager.createNamedQuery("findAll", User.class).getResultList();
		} catch (PersistenceException e) {
			LOG.error("FindAll failed", e);
			throw new RepositoryException("FindAll failed", e);
		}
	}

	@Override
	@Transactional
	public void save(User user) throws RepositoryException {
		try {
			entityManager.persist(user);
			entityManager.flush();
		} catch (IllegalArgumentException | EntityExistsException e) {
			LOG.error("Save failed", e);
			throw new RepositoryException("Save failed", e);
		}
	}

	@Override
	@Transactional
	public void delete(Long id) throws RepositoryException {
		User user = findById(id);
		try {
			entityManager.remove(user);
			entityManager.flush();
		} catch (IllegalArgumentException e) {
			LOG.error("Delete failed", e);
			throw new RepositoryException("Delete failed", e);
		}
	}

	@Override
	@Transactional
	public void update(User user) throws RepositoryException {
		
		// Modify fields that should be updated
		User persistedUser = findById(user.getId());
		persistedUser.setUserName(user.getUserName());
		persistedUser.setFullName(user.getFullName());		
		persistedUser.setPassWord(user.getPassWord());
		persistedUser.setEmail(user.getEmail());
		persistedUser.setAdress(user.getAdress());
		
		try {			
			entityManager.refresh(user);
			entityManager.flush();
		} catch (EntityNotFoundException | IllegalArgumentException  e) {
			LOG.error("Update failed", e);
			throw new RepositoryException("Update failed", e);
		}	
	}

	@Override
	public User findByEmail(User user) {
		Query query = entityManager.createQuery("SELECT u From User u WHERE u.email = :email")
				.setParameter("email", user.getEmail());
		
		LOG.info("authenticating");
		
		List<User> users = query.getResultList();
		
		if(!users.isEmpty()){
			return users.get(0);
		}
		else{
			return null;
		}
	}

}
