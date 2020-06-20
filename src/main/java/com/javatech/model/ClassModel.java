package com.javatech.model;

import java.sql.ResultSet;

public class ClassModel extends AbstractModel<ClassModel> implements IRowMapper<ClassModel> {
	
	private String name;
	private Integer courseId;
	private Integer isDone;
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
	public Integer getIsDone() {
		return isDone;
	}
	public void setIsDone(Integer isDone) {
		this.isDone = isDone;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public ClassModel mapRow(ResultSet rs) {
		try {
			ClassModel classModel = new ClassModel();
			classModel.setId(rs.getInt("id"));
			classModel.setName(rs.getString("name"));
			classModel.setCourseId(rs.getInt("course_id"));
			classModel.setIsDone(rs.getInt("is_done"));
			classModel.setStatus(rs.getInt("status"));
			return classModel;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}
	
}
