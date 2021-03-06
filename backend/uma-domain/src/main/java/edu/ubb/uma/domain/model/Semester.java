package edu.ubb.uma.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Semester extends BaseEntity{
	private Long userId;
	private String name;
	@OneToMany(fetch = FetchType.EAGER, cascade={CascadeType.ALL}) @JoinColumn (name="semesterId")
	private List<Course> courses;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}