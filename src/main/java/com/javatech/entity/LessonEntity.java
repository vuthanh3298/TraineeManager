package com.javatech.entity;

import com.javatech.anotatiton.Column;
import com.javatech.anotatiton.Table;

@Table("lesson")
public class LessonEntity extends CommonEntity {
	@Column("name")
	private String name;
	@Column("stage_id")
	private Integer stageId;
	@Column("stage_name")
	private String stageName;
	@Column("num_of_student")
	private Integer numOfStudent;
	@Column("room_id")
	private Integer roomId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStageId() {
		return stageId;
	}
	public void setStageId(Integer stageId) {
		this.stageId = stageId;
	}
	public Integer getNumOfStudent() {
		return numOfStudent;
	}
	public void setNumOfStudent(Integer numOfStudent) {
		this.numOfStudent = numOfStudent;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
}
