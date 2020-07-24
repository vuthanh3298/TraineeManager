package com.javatech.dao.impl;

import java.util.List;

import com.javatech.dao.IClassDAO;
import com.javatech.model.ClassModel;

public class ClassDAO extends GenreicDAO<ClassModel> implements IClassDAO {

	@Override
	public List<ClassModel> findAll() {
		String sql = "SELECT * FROM classes where status != -1";
		List<ClassModel> classes = query(sql, new ClassModel());
		return classes;
	}

	@Override
	public Integer insertUserIntoClass(Integer userId, Integer classId) {
		String sql = "INSERT INTO `traineemanager`.`user_in_class` (`class_id`, `user_id`, `status`)  VALUES (?,?,?)";
		return insert(sql, classId, userId, 0);
	}

	@Override
	public List<ClassModel> findByCourse(Integer courseId) {
		String sql = "SELECT * FROM classes where course_id = ? and status != -1";
		List<ClassModel> classes = query(sql, new ClassModel(), courseId);
		return classes;
	}

	@Override
	public Boolean delClass(Integer id) {
		try {
			String sql = "UPDATE classes SET status = -1 WHERE id = ?";
			update(sql, id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(ClassModel classModel) {
		try {
			String sql = null;
			String name = classModel.getName();
			Integer isDone = classModel.getIsDone();
			Integer id = classModel.getId();
			sql = "UPDATE classes SET `name` = ?, `is_done` = ? WHERE (`id` = ?)";
			update(sql, name, isDone, id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
