package com.javatech.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.javatech.dao.IThongBaoDAO;
import com.javatech.dao.impl.ThongBaoDAO;
import com.javatech.model.ThongBaoModel;
import com.javatech.service.IThongBaoService;

public class ThongBaoService implements IThongBaoService{
	@Inject
	IThongBaoDAO thongBaoDAO;
	public ThongBaoService() {
		thongBaoDAO = new ThongBaoDAO();
	}
	public List<ThongBaoModel> findAll() {
		return thongBaoDAO.findAll();
	}
	@Override
	public Integer createThongBao(ThongBaoModel thongBaoModel) {
		thongBaoModel.setStatus(1);
		Date now = new Date();
		Timestamp timestamp = new Timestamp(now.getTime());
		thongBaoModel.setCreatedDate(timestamp);
		
		return thongBaoDAO.save(thongBaoModel);
	}
	@Override
	public ThongBaoModel findOne(Integer id) {
		return thongBaoDAO.findOne(id);
	}
	@Override
	public Integer update(ThongBaoModel model) {
		Date now = new Date();
		Timestamp timestamp = new Timestamp(now.getTime());
		model.setModifiedDate(timestamp);
		
		return thongBaoDAO.update(model);
	}
	@Override
	public Boolean deleteThongBao(Integer id) {
		return thongBaoDAO.deleteThongBao(id);
	}
	
	public List<ThongBaoModel> findByClass(String clazz){
		if(clazz.equals("Tất cả")) {
			return findAll();
		}
		return thongBaoDAO.findByClass(clazz);
	}

}
