package com.javatech.service2;

import java.util.List;

import javax.inject.Inject;

import com.javatech.constant.SystemConstant;
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

	//
	public List<UserEntity> findByEmailAndPassword(String userName, String password) {
		return userDao.selecList(userName, password);
	}

	public Integer register(UserEntity userEntity) {
		userEntity.setRoleId(SystemConstant.USER_ROLE_ID);
		userEntity.setStatus(SystemConstant.STATUS_APPROVED);
		return userDao.insertOne(userEntity);
	}

	public Boolean isEmailExist(String email) {
		List<UserEntity> userEntities = userDao.selecList(email);
		if (userEntities.size() > 0)
			return true;
		return false;
	}

	public UserEntity findOne(Integer id) {
		return userDao.selectOne(id);
	}

	public Integer update(UserEntity user) {// return boolean
		return userDao.updateOne(user);
	}

	public List<UserEntity> selectAll(Integer status) {
		//return userDao.selecList("select * from users");
		return userDao.selectAll(status);
	}
	public List<UserEntity> selectList(){
		String sql = "select username, email, id from users";
		return userDao.selecList(sql);
	}
}
