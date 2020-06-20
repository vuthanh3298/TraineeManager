package com.javatech.service2;

import javax.inject.Inject;

import com.javatech.dao2.ClassesDAO;

public class ClassesService {
	@Inject
	ClassesDAO classesDAO;

	public Object findAll() {
		return classesDAO.selectAll(1);
	}

}
