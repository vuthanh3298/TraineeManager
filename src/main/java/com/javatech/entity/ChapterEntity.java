package com.javatech.entity;

import com.javatech.anotatiton.Column;
import com.javatech.anotatiton.Table;

@Table("chapter")
public class ChapterEntity extends CommonEntity{
	@Column("stage_id")
	private String stageId;
	@Column("name")
	private String name;
	@Column("_index")
	private String index;
	@Column("stage_name")
	private String stageName;
	@Column("content")
	private String content;
	
	public String getStageId() {
		return stageId;
	}
	public void setStageId(String stageId) {
		this.stageId = stageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
