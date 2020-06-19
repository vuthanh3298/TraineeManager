package com.javatech.dao;

import java.util.List;

import com.javatech.model.ClassModel;

public interface IClassDAO extends GenericDAO<ClassModel>{
	List<ClassModel> findAll();
}
