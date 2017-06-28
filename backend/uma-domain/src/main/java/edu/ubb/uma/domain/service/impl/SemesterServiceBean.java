package edu.ubb.uma.domain.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.uma.domain.model.Semester;
import edu.ubb.uma.domain.repo.RepositoryException;
import edu.ubb.uma.domain.repo.SemesterRepository;
import edu.ubb.uma.domain.repo.UserRepository;
import edu.ubb.uma.domain.service.SemesterService;
import edu.ubb.uma.domain.service.ServiceException;
import edu.ubb.uma.domain.service.UserService;

@Stateless(mappedName = SemesterService.BEAN_NAME)
public class SemesterServiceBean implements SemesterService{
	
	private static final Logger LOG = LoggerFactory.getLogger(SemesterServiceBean.class);
	
	@EJB
	private SemesterRepository semesterRepository;

	@Override
	public List<Semester> findSemestersByUserId(Long id) {
		try {
			return semesterRepository.findSemestersByUserId(id);
		} catch (RepositoryException e) {
			LOG.error("findSemestersByUserId failed", e);
			throw new ServiceException("findSemestersByUserId failed", e);
		}
	}

}
