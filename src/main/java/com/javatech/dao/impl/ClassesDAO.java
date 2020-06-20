package com.javatech.dao.impl;

import java.util.List;

import com.javatech.dao.IClassesDAO;
import com.javatech.model.ClassesModel;

public class ClassesDAO extends GenreicDAO<ClassesModel>  implements IClassesDAO{

	@Override
	public List<ClassesModel> findAll() {
		String sql = "select * from classes";
		return query(sql, new ClassesModel());
	}

}
