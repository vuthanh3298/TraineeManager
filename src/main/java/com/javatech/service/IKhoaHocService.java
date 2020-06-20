package com.javatech.service;

import java.util.List;

import com.javatech.model.KhoaHocModel;

public interface IKhoaHocService {
	List<KhoaHocModel> findAll();
	KhoaHocModel findOne(Integer id);
}
