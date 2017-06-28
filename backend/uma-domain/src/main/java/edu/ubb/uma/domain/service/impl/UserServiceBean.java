package edu.ubb.uma.domain.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.uma.domain.model.User;
import edu.ubb.uma.domain.repo.RepositoryException;
import edu.ubb.uma.domain.repo.UserRepository;
import edu.ubb.uma.domain.service.ServiceException;
import edu.ubb.uma.domain.service.UserService;

@Stateless(mappedName = UserService.BEAN_NAME)
public class UserServiceBean implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceBean.class);

	@EJB
	private UserRepository userRepository;

	@Override
	public User findById(Long id) throws ServiceException {
		try {
			return userRepository.findById(id);
		} catch (RepositoryException e) {
			LOG.error("FindById failed", e);
			throw new ServiceException("FindById failed", e);
		}
	}

	@Override
	public List<User> findAll() throws ServiceException {
		try {
			return userRepository.findAll();
		} catch (RepositoryException e) {
			LOG.error("FindAll failed", e);
			throw new ServiceException("FindAll failed", e);
		}
	}

	@Override
	public void save(User user) throws ServiceException {
		LOG.info("creating user {" + user + "}");
		try {
			userRepository.save(user);
		} catch (RepositoryException e) {
			LOG.error("Save failed", e);
			throw new ServiceException("Save failed", e);
		}
	}

	@Override
	public void delete(Long id) throws ServiceException {
		LOG.info("Deleting user with id: " + id);
		try {
			userRepository.delete(id);
		} catch (RepositoryException e) {
			LOG.error("Save failed", e);
			throw new ServiceException("Save failed", e);
		}
		
	}

	@Override
	public void update(User user) throws ServiceException {
		LOG.info("Updateing user: {" + user + "}");
		try{
			userRepository.update(user);
		} catch (RepositoryException e) {
			LOG.error("Update failed", e);
			throw new ServiceException("Update failed", e);
		}	
	}

	@Override
	public User authenticate(User user) {
		return userRepository.authenticate(user);
	}

}
