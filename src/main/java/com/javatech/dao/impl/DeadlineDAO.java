package com.javatech.dao.impl;

import java.util.List;

import com.javatech.dao.IDeadlineDAO;
import com.javatech.model.DeadlineModel;

public class DeadlineDAO extends GenreicDAO<DeadlineModel> implements IDeadlineDAO {

	@Override
	public List<DeadlineModel> findAll() {
		String sql = "select * from deadline where status= 1 order by modified_date desc";
		return query(sql, new DeadlineModel());
	}
	@Override
	public Integer save(DeadlineModel deadlineModel) {
		String sql = "INSERT INTO deadline"
				+ "(title, content, to_classes, due_date, is_register, week_in_year, "
				+ "status, created_date, modified_date, created_by, modified_by) "
				+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?);";
		int IsRegister =0;
		System.out.println(deadlineModel.getIsRegister());
		  if(deadlineModel.getIsRegister() == true) 
			  IsRegister = 1; 
		 
		return insert(sql, deadlineModel.getTitle(), deadlineModel.getContent(), deadlineModel.getToClass(),
				deadlineModel.getDueDate(), IsRegister, deadlineModel.getWeekInYear(),
				deadlineModel.getStatus(), deadlineModel.getCreatedDate(),
				deadlineModel.getModifiedDate(), deadlineModel.getCreatedBy(), deadlineModel.getModifiedBy());
	}

	@Override
	public DeadlineModel findOne(Integer id) {
		String sql = "SELECT * FROM deadline WHERE id =?";
		List<DeadlineModel> deadline = query(sql, new DeadlineModel(), id);
		return deadline.isEmpty() ? null : deadline.get(0);
	}

	@Override
	public Integer update(DeadlineModel model) {
		String sql="UPDATE deadline SET title = ?, content =?,to_classes=?,due_date=?,week_in_year=?  WHERE (id = ?);";
		return insert(sql,model.getTitle(),model.getContent(),model.getToClass(),model.getDueDate(),model.getWeekInYear(),model.getId());
	}

	@Override
	public Boolean deleteDeadline(Integer id) {
		try {
			String sql = "UPDATE deadline SET status = -1 where (id = ?) ";
			update(sql,id);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<DeadlineModel> findByClass(String classDeadline) {
		String sql = "select * from deadline where  status = 1 and to_classes = ? order by modified_date desc";
		return query(sql, new DeadlineModel(), classDeadline);
	}

}
