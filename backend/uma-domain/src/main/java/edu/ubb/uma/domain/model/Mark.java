package edu.ubb.uma.domain.model;

import javax.persistence.Entity;

@Entity
public class Mark extends BaseEntity{
	
	private Long userId;
	private Long courseId;
	private int mark;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
}