package com.javatech.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DeadlineModel extends AbstractModel<DeadlineModel> implements IRowMapper<DeadlineModel> {
	private String title;
	private String content;
	private String toClass;
	private Timestamp dueDate;
	private Boolean isRegister;
	private String weekInYear;
	//private int year;
	//private int week;
	
	private int status;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getToClass() {
		return toClass;
	}
	public void setToClass(String toClass) {
		this.toClass = toClass;
	}
	public Timestamp getDueDate() {
		return dueDate;
	}
	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}
	
	public Boolean getIsRegister() {
		return isRegister;
	}
	public void setIsRegister(Boolean isRegister) {
		this.isRegister = isRegister;
	}
	public String getWeekInYear() {
		return weekInYear;
	}
	public void setWeekInYear(String WeekInYear) {
		this.weekInYear = WeekInYear;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public DeadlineModel mapRow(ResultSet resultSet) {
		try {
			DeadlineModel deadline = new DeadlineModel();
			deadline.setId(resultSet.getInt("id"));
			deadline.setTitle(resultSet.getString("title"));
			deadline.setContent(resultSet.getString("content"));
			deadline.setToClass(resultSet.getString("to_classes"));
			deadline.setDueDate(resultSet.getTimestamp("due_date"));
			deadline.setIsRegister(resultSet.getBoolean("is_register"));
			deadline.setWeekInYear(resultSet.getString("week_in_year"));
			deadline.setStatus(resultSet.getInt("status"));
			deadline.setCreatedDate(resultSet.getTimestamp("created_date"));
			deadline.setModifiedDate(resultSet.getTimestamp("modified_date"));
			deadline.setCreatedBy(resultSet.getInt("created_by"));
			deadline.setModifiedBy(resultSet.getInt("modified_by"));
			return deadline;
		} catch (SQLException e) {
			return null;
		}	
	}
}
