package com.javatech.dao2;

import com.javatech.entity.ThongTinDangKyLichEntity;

public class ThongTinDangKyLichDAO extends CommonDao<ThongTinDangKyLichEntity>{
	/*
	SELECT * 
	FROM 
	user_register_schedule as urs, (select id, username from users) as u
	where u.id=urs.user_id;
	*/
	public Object selectAllAddName( Integer status) {
		//String sql = "SELECT * FROM user_register_schedule as urs, (select id, username from users) as u where u.id=urs.user_id and status = ?";
		String sql = "SELECT urs.*, u.username, c.name as 'class_name', u.class_id  FROM user_register_schedule as urs,"
				+ "  (select id, username, class_id from users) as u,"
				+ " (select id, name from classes) as c  "
				+ " where urs.user_id = u.id "
				+ " and u.class_id = c.id"
				+ " and status = ?";
		return selecList(sql, status);
	}
	
	public Object selectAllAddName( Integer status, String weekInYear) {
		//String sql = "SELECT * FROM user_register_schedule as urs, (select id, username from users) as u where u.id=urs.user_id and status = ?";
		String sql = "SELECT urs.*, u.username, c.name as 'class_name', u.class_id  FROM user_register_schedule as urs,"
				+ "  (select id, username, class_id from users) as u,"
				+ " (select id, name from classes) as c  "
				+ " where urs.user_id = u.id "
				+ " and u.class_id = c.id"
				+ " and status = ?"
				+ " and week_in_year = ?";
		return selecList(sql, status, weekInYear);
	}

	public Object findByIdUser(Integer status, Integer userId) {
		String sql = "select *from user_register_schedule where status =? and user_id=?";
		return selecList(sql, status, userId);
	}
	
}
