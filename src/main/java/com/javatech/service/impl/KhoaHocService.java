package com.javatech.service.impl;
import java.util.List;

import javax.inject.Inject;

import com.javatech.dao.IKhoaHocDAO;
import com.javatech.model.KhoaHocModel;
import com.javatech.service.IKhoaHocService;

public class KhoaHocService implements IKhoaHocService {

	@Inject IKhoaHocDAO khoaHoc;
	
	@Override
	public List<KhoaHocModel> findAll() {
		return khoaHoc.findAll();
	}

	@Override
	public KhoaHocModel findOne(Integer id) {
		return khoaHoc.findOne(id);
	}

}
