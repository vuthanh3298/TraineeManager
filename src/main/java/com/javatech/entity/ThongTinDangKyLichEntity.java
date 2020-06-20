package com.javatech.entity;

import com.javatech.anotatiton.Column;
import com.javatech.anotatiton.Table;

@Table("user_register_schedule")
public class ThongTinDangKyLichEntity extends CommonEntity{
	
	@Column("user_id")
	private Integer userId;
	@Column("deadline_id")
	private Integer deadlineId;
	@Column("week_in_year")
	private String weekInYear;
	@Column("schedule")
	private String schedule;//C2-S2-C3...
	@Column("username")
	private String username;
	@Column("class_name")
	private String className;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getDeadlineId() {
		return deadlineId;
	}
	public void setDeadlineId(Integer deadlineId) {
		this.deadlineId = deadlineId;
	}
	public String getWeekInYear() {
		return weekInYear;
	}
	public void setWeekInYear(String weekInYear) {
		this.weekInYear = weekInYear;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
