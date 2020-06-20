package com.javatech.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.javatech.dao.IClassesDAO;
import com.javatech.model.ClassesModel;
import com.javatech.service.IClassesService;

public class ClassesService implements IClassesService{
	@Inject
	IClassesDAO classesService;
	@Override
	public List<ClassesModel> findAll() {
		return classesService.findAll();
	}

}
