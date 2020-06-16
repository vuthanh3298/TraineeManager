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
	
}
