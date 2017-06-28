package edu.ubb.uma.domain.repo;

import javax.ejb.Local;

import edu.ubb.uma.domain.model.Mark;

@Local
public interface MarkRepository extends AbstractRepository<Mark>{

	public static final String BEAN_NAME = "ejb/MarkRepository";
	
	public Mark findByUserCourse(Long userId, Long courseId);
	
	
}