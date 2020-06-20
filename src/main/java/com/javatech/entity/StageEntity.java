package com.javatech.entity;

import com.javatech.anotatiton.Column;
import com.javatech.anotatiton.Table;

@Table("stage")
public class StageEntity extends CommonEntity {
	@Column("courses_id")
	private Integer coursesId;	
	@Column("name")
	private String name;
	@Column("description")
	private String description;
	@Column("note")
	private String note;
	
	public Integer getCoursesId() {
		return coursesId;
	}
	public void setCoursesId(Integer coursesId) {
		this.coursesId = coursesId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
