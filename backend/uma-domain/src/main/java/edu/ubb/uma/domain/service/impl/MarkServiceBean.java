package edu.ubb.uma.domain.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.ubb.uma.domain.model.Mark;
import edu.ubb.uma.domain.repo.MarkRepository;
import edu.ubb.uma.domain.repo.RepositoryException;
import edu.ubb.uma.domain.repo.UserRepository;
import edu.ubb.uma.domain.service.MarkService;
import edu.ubb.uma.domain.service.MockService;
import edu.ubb.uma.domain.service.ServiceException;

@Stateless(mappedName = MarkService.BEAN_NAME)
public class MarkServiceBean implements MarkService{
	
	@EJB
	private MarkRepository markRepo;

	@Override
	public Mark findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mark> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Mark data) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Mark data) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mark findByUserCourse(Long user, Long course) {
		try {
			return markRepo.findByUserCourse(user, course);
		} catch (RepositoryException e) {
			throw new ServiceException("FindById failed", e);
		}
	}


}
