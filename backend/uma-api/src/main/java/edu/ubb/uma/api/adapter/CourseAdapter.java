package edu.ubb.uma.api.adapter;

import java.util.ArrayList;
import java.util.List;

import edu.ubb.uma.api.dto.CourseDTO;

import edu.ubb.uma.domain.model.Course;


public class CourseAdapter {
	
	public static CourseDTO fromCourse(Course course){
		if(course == null){
			return null;
		}
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setId(course.getId());
		courseDTO.setSemesterId(course.getSemesterId());
		courseDTO.setName(course.getName());
		courseDTO.setTeacher(course.getTeacher());
		courseDTO.setCredit(course.getCredit());
	
		return courseDTO;
	}

	public static List<CourseDTO> fromList(List<Course> curses){
		if(curses==null || curses.size()==0){
			return new ArrayList<>();
		}
		List<CourseDTO> courseDTOs =  new ArrayList<>(curses.size());
		for(Course course : curses){
			courseDTOs.add(fromCourse(course));
		}			
		return courseDTOs;
	}
}
