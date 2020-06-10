package com.javatech.service2;

import javax.inject.Inject;

import com.javatech.dao2.UserDao;
import com.javatech.entity.UserEntity;

public class UserService {
	
	@Inject
	UserDao userDao;
	
	public UserEntity selectOne(Integer id) {
		return userDao.selectOne(id);
	}
	
	public Integer insertOne(UserEntity user) {
		return userDao.insertOne(user);
	}

	public int updateOne(UserEntity user) {
		return userDao.updateOne(user);
	}

	public int deleteOne(UserEntity user) {
		return userDao.deleteOne(user);
	}
	
	
}
