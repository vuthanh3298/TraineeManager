package com.javatech.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.javatech.dao.IUserDAO;
import com.javatech.model.UserModel;
import com.javatech.utils.StringUtil;

public class UserDAO extends GenreicDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByEmailAndPassword(String email, String password) {
		StringBuilder sql = new StringBuilder("SELECT * FROM users AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.role_id");
		sql.append(" WHERE email = ? AND password = ?");
		List<UserModel> users = query(sql.toString(), new UserModel(), email, password);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Integer save(UserModel userModel) {
		String sql = "INSERT INTO `traineemanager`.`users` (`email`, `username`, `password`, `phone_number`, `address`, `dob`, `university`, `role_id`, `status`)  VALUES (?,?,?,?,?,?,?,?,?)";
		return insert(sql, userModel.getEmail(), userModel.getUsername(), userModel.getPassword(), userModel.getPhoneNumber(), userModel.getAddress(), userModel.getDob(), userModel.getUniversity(), userModel.getRoleId(), userModel.getStatus());
	}

	@Override
	public Boolean isEmailExist(String email) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select 1 from users where email = ?";
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, email);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public UserModel findOne(Integer id) {
		String sql = "SELECT * FROM users AS u INNER JOIN role AS r ON r.id = u.role_id WHERE u.id = ?";
		List<UserModel> users = query(sql, new UserModel(), id);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public boolean update(UserModel userModel) {
		try {
			String sql = null;
			String email = userModel.getEmail();
			String username = userModel.getUsername();
			String password = userModel.getPassword();
			String phone = userModel.getPhoneNumber();
			String address = userModel.getAddress();
			Timestamp dob = userModel.getDob();
			String university = userModel.getUniversity();
			Integer id = userModel.getId();
			if(StringUtil.makeBeautiful(password).isEmpty()) {
				sql = "UPDATE users SET `email` = ?, `username` = ?, `phone_number` = ?, `address` = ?, `dob` = ?, `university` = ? WHERE (`id` = ?)";
				update(sql, email, username, phone, address, dob, university, id);
			} else {
				sql = "UPDATE users SET `email` = ?, `username` = ?, `password` = ?, `phone_number` = ?, `address` = ?, `dob` = ?, `university` = ? WHERE (`id` = ?)";
				update(sql, email, username, password, phone, address, dob, university, id);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<UserModel> findAll() {
		String sql = "select * from users where `status`= 1";
		return query(sql, new UserModel());
	}
	
	@Override
	public Boolean deleteUser(Integer id) {
		try {
			String sql = "UPDATE users SET `status` = -1 where (`id` = ?) ";
			update(sql,id);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<UserModel> findAllStatus0() {
		String sql = "select * from users where `status`= 0";
		return query(sql, new UserModel());
	}

	@Override
	public Boolean duyetUser(Integer id) {
		try {
			String sql = "UPDATE users SET `status` = 1 where (`id` = ?) ";
			update(sql,id);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean duyetUsers(Integer[] ids) {
		try {
			String sql = "UPDATE users SET `status` = 1 where id in ( ";
			String listId= ids[0]+"";
			for (int i = 1; i < ids.length; i++) {
				
				listId += ","+ids[i];
			}
			listId += ")";
			sql+=listId;
			update(sql);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean xoaIdUsersChoDuyet(Integer[] ids) {
		try {
			String sql = "DELETE FROM users where id in ( ";
			String listId= ids[0]+"";
			for (int i = 1; i < ids.length; i++) {
				
				listId += ","+ids[i];
			}
			listId += ")";
			sql+=listId;
			update(sql);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean xoaUserChoDuyet(Integer id) {
		try {
			String sql = "DELETE FROM users where (`id` = ?) ";
			update(sql,id);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<UserModel> findAllTrainees() {
		String sql = "SELECT * FROM users WHERE status = 1 and role_id =2";
		List<UserModel> users = query(sql, new UserModel());
		return users;
	}

	@Override
	public List<UserModel> findAllPending() {
		String sql = "SELECT * FROM users WHERE status = 0";
		List<UserModel> users = query(sql, new UserModel());
		return users;
	}
	
	@Override
	public List<UserModel> findAllDeleted() {
		String sql = "SELECT * FROM users WHERE status = -1";
		List<UserModel> users = query(sql, new UserModel());
		return users;
	}

	@Override
	public List<UserModel> findByClass(Integer pClass) {
		String sql = "SELECT * FROM users WHERE id IN(SELECT user_id FROM user_in_class WHERE class_id = ?) and status=1";
		List<UserModel> users = query(sql.toString(), new UserModel(), pClass);
		return users;
	}
}
