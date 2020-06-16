package com.javatech.dao;
import java.util.List;

import com.javatech.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByEmailAndPassword(String userName, String password);
	Integer save(UserModel userModel);
	Boolean isEmailExist(String email);
	UserModel findOne(Integer id);
	boolean update(UserModel userModel);
	List<UserModel> findAll();
	Boolean deleteUser(Integer id);
	List<UserModel> findAllStatus0();
	Boolean duyetUser(Integer id);
	Boolean duyetUsers(Integer[] ids);
	Boolean xoaIdUsersChoDuyet(Integer[] ids);
	Boolean xoaUserChoDuyet(Integer id);
	
	//Phuc
	List<UserModel> findAllTrainees();
	List<UserModel> findAllPending();
	List<UserModel> findAllDeleted();
	List<UserModel> findByClass(Integer pClass);
}
