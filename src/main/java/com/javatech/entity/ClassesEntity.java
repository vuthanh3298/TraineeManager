package com.javatech.entity;

import com.javatech.anotatiton.Column;
import com.javatech.anotatiton.Table;

@Table("classes")
public class ClassesEntity extends CommonEntity {
	@Column("name")
	private String name;
	@Column("course_id")
	private Integer courseId;
	@Column("is_done")
	private Boolean isDone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
}
