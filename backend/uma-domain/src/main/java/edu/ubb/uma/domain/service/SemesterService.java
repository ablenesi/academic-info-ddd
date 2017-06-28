package edu.ubb.uma.domain.service;

import java.util.List;

import javax.ejb.Remote;

import edu.ubb.uma.domain.model.Semester;

@Remote
public interface SemesterService {
	
	public static final String BEAN_NAME = "ejb/SemesterService";
	
	List<Semester> findSemestersByUserId(Long id);
}
