package edu.ubb.uma.domain.model;

import javax.persistence.Entity;

@Entity
public class Course extends BaseEntity{
	
	private String name;
	private String teacher;
	private int credit;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
}
