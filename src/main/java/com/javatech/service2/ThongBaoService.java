package com.javatech.service2;

import java.util.List;

import javax.inject.Inject;

import com.javatech.dao2.ThongBaoDAO;
import com.javatech.entity.ThongBaoEntity;

public class ThongBaoService {
	@Inject
	ThongBaoDAO thongBaoDAO;

	public List<ThongBaoEntity> findAll(Integer status) {
		return thongBaoDAO.selectAll(status);
	}
	public Integer createThongBao(ThongBaoEntity thongBao) {
		thongBao.setStatus(1);
		return thongBaoDAO.insertOne(thongBao);
	}
	
	public ThongBaoEntity findOne(Integer id) {
		return thongBaoDAO.selectOne(id);
	}

	public Integer update(ThongBaoEntity thongBao) {
		return thongBaoDAO.updateOne(thongBao);
	}

	public Integer deleteThongBao(ThongBaoEntity thongBao) {
		thongBao.setStatus(-1);
		return thongBaoDAO.updateOne(thongBao);
	}

	//
	public List<ThongBaoEntity> findByClass(String userName, String password) {
		return thongBaoDAO.selecList(userName, password);
	}



	
}
