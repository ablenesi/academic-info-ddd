package edu.ubb.uma.domain.repo;

import java.util.List;

import javax.ejb.Local;

import edu.ubb.uma.domain.model.Semester;

@Local
public interface SemesterRepository extends AbstractRepository<Semester> {
	
	public static final String BEAN_NAME = "ejb/SemesterRepository";

	public List<Semester> findSemestersByUserId(Long id);
}
