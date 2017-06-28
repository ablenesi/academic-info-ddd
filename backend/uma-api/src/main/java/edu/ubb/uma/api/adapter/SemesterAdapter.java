package edu.ubb.uma.api.adapter;

import java.util.ArrayList;
import java.util.List;

import edu.ubb.uma.api.dto.SemesterDTO;
import edu.ubb.uma.domain.model.Semester;

public class SemesterAdapter {
	
	public static SemesterDTO fromSemester(Semester semester){
		if(semester == null){
			return null;
		}
		SemesterDTO semesterDTO = new SemesterDTO();
		semesterDTO.setId(semester.getId());
		semesterDTO.setUserId(semester.getUserId());
		semesterDTO.setName(semester.getName());
		semesterDTO.setCourses(CourseAdapter.fromList(semester.getCourses()));  
		return semesterDTO;
	}

	public static List<SemesterDTO> fromList(List<Semester> semesters){
		if(semesters==null || semesters.size()==0){
			return new ArrayList<>();
		}
		List<SemesterDTO> semesterDTOs =  new ArrayList<>(semesters.size());
		for(Semester semester : semesters){
			semesterDTOs.add(fromSemester(semester));
		}			
		return semesterDTOs;
	}
}
