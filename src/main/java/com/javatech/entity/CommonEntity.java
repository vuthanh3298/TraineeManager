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
	Timestamp createDate;
	
	@Column("modified_date")
	Timestamp modifiedDate;
	
	@Column("created_by")
	Integer createBy;
	
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

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
