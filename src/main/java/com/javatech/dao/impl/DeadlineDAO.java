package com.javatech.dao.impl;
import java.util.List;

import com.javatech.dao.IDeadlineDAO;
import com.javatech.model.DeadlineModel;

public class DeadlineDAO extends GenreicDAO<DeadlineModel> implements IDeadlineDAO {

	@Override
	public List<DeadlineModel> findAll() {
		String sql = "select * from deadline where status = 1";
		return query(sql, new DeadlineModel());
	}

	@Override
	public Integer save(DeadlineModel deadlineModel) {
		String sql = "INSERT INTO `dbjeejspservlet`.`deadline`"
				+ "(`title`, `content`, `to_classes`, `due_date`, `is_register`, `year`, `week`, "
				+ "`status`, `created_date`, `modified_date`, `created_by`, `modified_by`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?);";
		return insert(sql, deadlineModel.getTitle(), deadlineModel.getContent(), deadlineModel.getToClass(),
				deadlineModel.getDueDate(),deadlineModel.getIsRegister(),deadlineModel.getYear(),deadlineModel.getWeek(),
				deadlineModel.getStatus(), deadlineModel.getCreatedDate(), deadlineModel.getModifiedDate(),
				deadlineModel.getCreatedBy(), deadlineModel.getModifiedBy());

	}

	@Override
	public DeadlineModel findOne(Integer id) {
		return findOne("deadline", new DeadlineModel(), id);
	}
}
