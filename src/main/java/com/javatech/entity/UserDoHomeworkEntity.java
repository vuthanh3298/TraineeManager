package com.javatech.entity;

import com.javatech.anotatiton.Column;
import com.javatech.anotatiton.Table;

@Table("user_do_homework")
public class UserDoHomeworkEntity extends CommonEntity{
	@Column("user_id")
	private Integer userId;
	@Column("deadline_id")
	private Integer deadlineId;
	@Column("is_register")
	private Boolean isRegister;
	@Column("url_homework")
	private String urlHomework;
	
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
	public Boolean getIsRegister() {
		return isRegister;
	}
	public void setIsRegister(Boolean isRegister) {
		this.isRegister = isRegister;
	}
	public String getUrlHomework() {
		return urlHomework;
	}
	public void setUrlHomework(String urlHomework) {
		this.urlHomework = urlHomework;
	}
	
	
	

}
