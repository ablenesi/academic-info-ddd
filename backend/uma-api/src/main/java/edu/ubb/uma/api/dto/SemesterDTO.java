package edu.ubb.uma.api.dto;

import java.util.List;

public class SemesterDTO {
	
	private Long id;
	private Long userId;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CourseDTO> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
	}
	private List<CourseDTO> courses;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
