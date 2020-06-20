package com.javatech.service;

import java.util.List;

import com.javatech.model.ThongBaoModel;

public interface IThongBaoService {

	List<ThongBaoModel> findAll();
	Integer createThongBao(ThongBaoModel thongBaoModel);
	ThongBaoModel findOne(Integer id);
	Integer update(ThongBaoModel model);
	Boolean deleteThongBao(Integer id);
	List<ThongBaoModel> findByClass(String clazz);

}
