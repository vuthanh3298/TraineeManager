package com.javatech.entity;

import com.javatech.anotatiton.Column;
import com.javatech.anotatiton.Table;

@Table("notifications")
public class ThongBaoEntity extends CommonEntity{
	@Column("title")
	private String title;
	@Column("content")
	private String content;
	@Column("to_classes")
	private String toClass;
	
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

	
	
}
