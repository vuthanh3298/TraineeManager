package com.javatech.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.javatech.dao.IClassDAO;
import com.javatech.model.ClassModel;
import com.javatech.service.IClassService;

public class ClassService implements IClassService{
	
	@Inject
	IClassDAO classDAO;
	
	@Override
	public List<ClassModel> findAll() {
		return classDAO.findAll();
	}

	@Override
	public Integer insertUserIntoClass(Integer userId, Integer classId) {
		return classDAO.insertUserIntoClass(userId, classId);
	}

	@Override
	public List<ClassModel> findByCourse(Integer courseId) {
		return classDAO.findByCourse(courseId);
	}

	@Override
	public Boolean delClass(Integer id) {
		return classDAO.delClass(id);
	}

	@Override
	public boolean update(ClassModel classModel) {
		return classDAO.update(classModel);
	}
	
}
