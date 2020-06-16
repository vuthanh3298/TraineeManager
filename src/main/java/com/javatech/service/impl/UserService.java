package com.javatech.service.impl;
import java.util.List;

import javax.inject.Inject;

import com.javatech.constant.SystemConstant;
import com.javatech.dao.IUserDAO;
import com.javatech.dao.impl.UserDAO;
import com.javatech.model.UserModel;
import com.javatech.service.IUserService;

public class UserService implements IUserService {

	@Inject
	IUserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByEmailAndPassword(String userName, String password) {
		return userDAO.findByEmailAndPassword(userName, password);
	}

	public Integer register(UserModel userModel) {
		userModel.setRoleId(SystemConstant.USER_ROLE_ID);
		userModel.setStatus(SystemConstant.STATUS_APPROVED);
		return userDAO.save(userModel);
	}

	@Override
	public Boolean isEmailExist(String email) {
		return userDAO.isEmailExist(email);
	}

	@Override
	public UserModel findOne(Integer id) {
		return userDAO.findOne(id);
	}

	@Override
	public boolean update(UserModel userModel) {
		return userDAO.update(userModel);
	}
	
	public List<UserModel> findAll() {
		return userDAO.findAll();
	}
	
	public Boolean deleteUser(Integer id) {
		return userDAO.deleteUser(id);
	}

	@Override
	public Integer createUser(UserModel userModel) {
		userModel.setRoleId(SystemConstant.USER_ROLE_ID);
		userModel.setStatus(SystemConstant.STATUS_ACTIVED);
		return userDAO.save(userModel);
	}

	@Override
	public List<UserModel> findAllStatus0() {
		return userDAO.findAllStatus0();
	}

	@Override
	public Boolean duyetUser(Integer id) {
		return userDAO.duyetUser(id);
	}

	@Override
	public Boolean duyetUsers(Integer[] ids) {
		return userDAO.duyetUsers(ids);
	}

	@Override
	public Boolean xoaIdUsersChoDuyet(Integer[] ids) {
		return userDAO.xoaIdUsersChoDuyet(ids);
	}

	@Override
	public Boolean xoaUserChoDuyet(Integer id) {
		return userDAO.xoaUserChoDuyet(id);
	}

	@Override
	public List<UserModel> findAllTrainees() {
		return userDAO.findAllTrainees();
	}

	@Override
	public List<UserModel> findAllPending() {
		return userDAO.findAllPending();
	}

	@Override
	public List<UserModel> findAllDeleted() {
		return userDAO.findAllDeleted();
	}

	@Override
	public List<UserModel> findByClass(Integer pClass) {
		return userDAO.findByClass(pClass);
	}
}
