package com.javatech.dao;

import java.util.List;

import com.javatech.model.DeadlineModel;

public interface IDeadlineDAO {
	
	List<DeadlineModel> findAll();

	Integer save(DeadlineModel deadlineModel);

	DeadlineModel findOne(Integer id);

	Integer update(DeadlineModel model);

	Boolean deleteDeadline(Integer id);

	List<DeadlineModel> findByClass(String classDeadline);


}
