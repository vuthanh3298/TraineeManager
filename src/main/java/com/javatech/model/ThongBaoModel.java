package com.javatech.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThongBaoModel extends AbstractModel<ThongBaoModel> implements IRowMapper<ThongBaoModel> {
	private String title;
	private String content;
	private String toClass;
	private int status;
	public String getToClass() {
		return toClass;
	}
	public void setToClass(String toClass) {
		this.toClass = toClass;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
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
	
	@Override
	public ThongBaoModel mapRow(ResultSet resultSet) {
		try {
			ThongBaoModel thongBao = new ThongBaoModel();
			thongBao.setId(resultSet.getInt("id"));
			thongBao.setTitle(resultSet.getString("title"));
			thongBao.setContent(resultSet.getString("content"));
			thongBao.setToClass(resultSet.getString("to_classes"));
			thongBao.setStatus(resultSet.getInt("status"));
			thongBao.setCreatedDate(resultSet.getTimestamp("created_date"));
			thongBao.setModifiedDate(resultSet.getTimestamp("modified_date"));
			thongBao.setCreatedBy(resultSet.getInt("created_by"));
			thongBao.setModifiedBy(resultSet.getInt("modified_by"));
			return thongBao;
		} catch (SQLException e) {
			return null;
		}	
	}

}
