package com.javatech.service;
import java.util.List;

import com.javatech.model.UserModel;

public interface IUserService {
	UserModel findOne(Integer id);
	UserModel findByEmailAndPassword(String userName, String password);
	Integer register(UserModel userModel);
	Boolean isEmailExist(String email);
	boolean update(UserModel userModel);
	List<UserModel> findAll();
	Boolean deleteUser(Integer id);
	Integer createUser(UserModel userModel);
	List<UserModel> findAllStatus0();
	Boolean duyetUser(Integer id);
	//Boolean duyetUsers(ArrayList<Integer> ids);
	Boolean duyetUsers(Integer[] ids);
	Boolean xoaIdUsersChoDuyet(Integer[] ids);
	Boolean xoaUserChoDuyet(Integer id);
	
	//Phuc
	List<UserModel> findAllTrainees();
	List<UserModel> findAllPending();
	List<UserModel> findAllDeleted();
	List<UserModel> findByClass(Integer pClass);
}