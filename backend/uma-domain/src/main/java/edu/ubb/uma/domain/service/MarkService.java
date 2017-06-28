package edu.ubb.uma.domain.service;

import javax.ejb.Remote;

import edu.ubb.uma.domain.model.Mark;

@Remote
public interface MarkService extends AbstractService<Mark>{
	
	public static final String BEAN_NAME = "ejb/MarkService";
	
	public Mark findByUserCourse(Long user, Long course);
}
