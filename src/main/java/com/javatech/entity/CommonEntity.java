package com.javatech.entity;

import java.sql.Timestamp;

import com.javatech.anotatiton.Column;
import com.javatech.anotatiton.CommonTable;
import com.javatech.anotatiton.Id;

@CommonTable
public class CommonEntity {
	@Id
	@Column("id")
	Integer id;
	
	@Column("status")
	Integer status;
	
	@Column("created_date")
	Timestamp createdDate;
	
	@Column("modified_date")
	Timestamp modifiedDate;
	
	@Column("created_by")
	Integer createdBy;
	
	@Column("modified_by")
	Integer modifiedBy;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
}
