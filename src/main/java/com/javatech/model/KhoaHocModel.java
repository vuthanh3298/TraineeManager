package com.javatech.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class KhoaHocModel extends AbstractModel<KhoaHocModel> implements IRowMapper<KhoaHocModel>{
	private String name;
	private Timestamp startTime;
	private Timestamp endTime;
	private String description;
	private String note;
	private boolean status;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public KhoaHocModel mapRow(ResultSet rs) {
		try {
			KhoaHocModel khoaHoc = new KhoaHocModel();
			khoaHoc.setName(rs.getString("name"));
			khoaHoc.setDescription(rs.getString("description"));
			khoaHoc.setStartTime(rs.getTimestamp("start_time"));
			khoaHoc.setEndTime(rs.getTimestamp("end_time"));
			khoaHoc.setNote(rs.getString("note"));
			khoaHoc.setStatus(rs.getBoolean("status"));
			khoaHoc.setRs(rs);
			return khoaHoc;
		} catch (SQLException e) {
			return null;
		}
	}
}
