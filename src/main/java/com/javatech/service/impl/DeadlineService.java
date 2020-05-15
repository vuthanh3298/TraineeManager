package com.javatech.service.impl;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.javatech.dao.IDeadlineDAO;
import com.javatech.dao.impl.DeadlineDAO;
import com.javatech.model.DeadlineModel;
import com.javatech.service.IDeadlineService;

public class DeadlineService implements IDeadlineService{
	@Inject
	IDeadlineDAO deadlineDAO;
	public DeadlineService() {
		deadlineDAO =new DeadlineDAO();
	}
	public List<DeadlineModel> findAll() {
		return deadlineDAO.findAll();
	}
	@Override
	public Integer createDeadline(DeadlineModel deadlineModel) {
		deadlineModel.setStatus(1);
		Date now = new Date();
		Timestamp timestamp = new Timestamp(now.getTime());
		deadlineModel.setCreatedDate(timestamp);
		return deadlineDAO.save(deadlineModel);
	}
	@Override
	public DeadlineModel findOne(Integer id) {
		return deadlineDAO.findOne(id);
	}
}
