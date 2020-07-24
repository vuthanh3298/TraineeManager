package com.javatech.service;

import java.util.List;

import com.javatech.model.ClassModel;

public interface IClassService {
	List<ClassModel> findAll();
	List<ClassModel> findByCourse(Integer courseId);
	Integer insertUserIntoClass(Integer userId, Integer classId);
	Boolean delClass(Integer id);
	boolean update(ClassModel classModel);
}
