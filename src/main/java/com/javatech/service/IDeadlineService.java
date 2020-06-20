package com.javatech.service;

import java.util.List;

import com.javatech.model.DeadlineModel;

public interface IDeadlineService {
	List<DeadlineModel> findAll();
	Integer createDeadline(DeadlineModel deadlineModel);
	DeadlineModel findOne(Integer id);
	Integer update(DeadlineModel model);
	Boolean deleteDeadline(Integer id);
	List<DeadlineModel> findByClass(String classDeadline);
}
