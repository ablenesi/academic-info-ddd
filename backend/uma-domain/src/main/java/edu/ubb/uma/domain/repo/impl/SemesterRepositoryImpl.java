package edu.ubb.uma.domain.repo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.uma.domain.model.Semester;
import edu.ubb.uma.domain.model.User;
import edu.ubb.uma.domain.repo.RepositoryException;
import edu.ubb.uma.domain.repo.SemesterRepository;
import edu.ubb.uma.domain.repo.UserRepository;

@Stateless(mappedName = UserRepository.BEAN_NAME)
public class SemesterRepositoryImpl implements SemesterRepository{
	
	private static final String PERSISTENCE_UNIT_NAME = "umaPu";
	private static final Logger LOG = LoggerFactory.getLogger(SemesterRepositoryImpl.class);

	@PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
	EntityManager entityManager;

	@Override
	public Semester findById(Long id) throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Semester> findAll() throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Semester data) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Semester data) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Semester> findSemestersByUserId(Long id) {
		try {
			User user = entityManager.find(User.class, id);
			return user.getSemesters();
		} catch (IllegalArgumentException e) {
			LOG.error("FindById failed", e);
			throw new RepositoryException("FindById failed", e);
		}
	}

}
