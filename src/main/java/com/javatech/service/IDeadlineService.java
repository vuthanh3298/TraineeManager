package com.javatech.service;
import java.util.List;

import com.javatech.model.DeadlineModel;

public interface IDeadlineService {
	List<DeadlineModel> findAll();
	Integer createDeadline(DeadlineModel deadlineModel);
	DeadlineModel findOne(Integer id);
}
