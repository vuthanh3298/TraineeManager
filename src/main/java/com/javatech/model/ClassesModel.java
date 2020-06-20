package com.javatech.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassesModel extends AbstractModel<ClassesModel> implements IRowMapper<ClassesModel>{

	private String name;
	private Integer courseId;
	private Boolean isDone;
	private Integer status;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Override
	public ClassesModel mapRow(ResultSet resultSet) {
		try {
			ClassesModel classes = new ClassesModel();
			classes.setId(resultSet.getInt("id"));
			classes.setName(resultSet.getString("name"));
			classes.setCourseId(resultSet.getInt("course_id"));
			classes.setIsDone(resultSet.getBoolean("is_done"));
			classes.setStatus(resultSet.getInt("status"));
			classes.setStatus(resultSet.getInt("status"));
			classes.setCreatedDate(resultSet.getTimestamp("created_date"));
			classes.setModifiedDate(resultSet.getTimestamp("modified_date"));
			classes.setCreatedBy(resultSet.getInt("created_by"));
			classes.setModifiedBy(resultSet.getInt("modified_by"));
			return classes;
		} catch (SQLException e) {
			return null;
		}	
	}
}
