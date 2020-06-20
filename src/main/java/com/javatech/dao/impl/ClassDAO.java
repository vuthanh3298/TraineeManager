package com.javatech.dao.impl;

import java.util.List;

import com.javatech.dao.IClassDAO;
import com.javatech.model.ClassModel;
import com.javatech.model.IRowMapper;

public class ClassDAO extends GenreicDAO<ClassModel> implements IClassDAO{

	@Override
	public List<ClassModel> findAll() {
		String sql = "SELECT * FROM classes";
		List<ClassModel> classes = query(sql, new ClassModel());
		return classes;
	}

}
