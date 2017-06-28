package edu.ubb.uma.domain.repo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.ubb.uma.domain.model.Mark;
import edu.ubb.uma.domain.model.User;
import edu.ubb.uma.domain.repo.MarkRepository;
import edu.ubb.uma.domain.repo.RepositoryException;
import edu.ubb.uma.domain.repo.UserRepository;

@Stateless(mappedName = UserRepository.BEAN_NAME)
public class MarkRepositoryImpl implements MarkRepository{
	
	private static final String PERSISTENCE_UNIT_NAME = "umaPu";

	@PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
	EntityManager entityManager;

	@Override
	public Mark findById(Long id) throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Mark findByUserCourse(Long userId, Long courseId) {
		try{
			Query query = entityManager.createQuery("SELECT m From Mark m WHERE m.userId = :userId AND m.courseId = :courseId")
					.setParameter("userId", userId)
					.setParameter("courseId", courseId);
			
			List<Mark> list= query.getResultList();
			if(!list.isEmpty()){
				return list.get(0);
			}
			else{
				return null;
			}
		}
		
		catch (IllegalArgumentException | EntityExistsException e) {
			throw new RepositoryException("findByUserCourse failed", e);
		}
		
		
	}
	

	@Override
	public List<Mark> findAll() throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Mark data) throws RepositoryException {
		try {
			entityManager.persist(data);
			entityManager.flush();
		} catch (IllegalArgumentException | EntityExistsException e) {
			throw new RepositoryException("Save failed", e);
		}
		
	}

	@Override
	public void delete(Long id) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Mark data) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

}
