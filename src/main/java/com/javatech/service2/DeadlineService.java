package com.javatech.service2;

import java.util.List;

import javax.inject.Inject;

import com.javatech.dao2.DeadlineDAO;
import com.javatech.entity.DeadlineEntity;

public class DeadlineService {
	@Inject
	DeadlineDAO deadlineDAO;
	
	public List<DeadlineEntity> findAll(Integer status) {
		return deadlineDAO.selectAll(status);
	}
	
	public Integer createDeadline(DeadlineEntity deadline) {
		deadline.setStatus(1);
		return deadlineDAO.insertOne(deadline);
	}
	
	public DeadlineEntity findOne(Integer id) {
		return deadlineDAO.selectOne(id);
	}
	
	public Integer update(DeadlineEntity model) {
		return deadlineDAO.updateOne(model);
	}
	
	public Integer deleteDeadline(DeadlineEntity model) {
		model.setStatus(-1);
		return deadlineDAO.updateOne(model);
	}
	
	public List<DeadlineEntity> findByClass(String classDeadline) {
		if(classDeadline.equals("Tất cả")) {
			return findAll(1);
		}
		return deadlineDAO.selecList(classDeadline);
	}
}
