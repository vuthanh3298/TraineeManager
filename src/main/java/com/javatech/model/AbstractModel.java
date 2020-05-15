package com.javatech.model;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class AbstractModel<T> {

	private Integer id;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private Integer createdBy;
	private Integer modifiedBy;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public void setRs(ResultSet rs) {
		try {
			this.setId(rs.getInt("id"));
			this.setCreatedDate(rs.getTimestamp("created_date"));
			this.setModifiedDate(rs.getTimestamp("modified_date"));
			this.setCreatedBy(rs.getInt("created_by"));
			this.setModifiedBy(rs.getInt("modified_by"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
