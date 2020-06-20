package com.javatech.service2;

import javax.inject.Inject;

import com.javatech.dao2.UserDoHomeworkDao;
import com.javatech.entity.UserDoHomeworkEntity;
import com.javatech.utils.SessionUtil;

public class UserDoHomeworkService {
	@Inject
	UserDoHomeworkDao userDoHomeworkDao;

	public int saveThongTinDangKyLich(UserDoHomeworkEntity userDoHomeworkEntity) {
		Integer userId = SessionUtil.getUserId();
		userDoHomeworkEntity.setUserId(userId);
		userDoHomeworkEntity.setStatus(1);
		return userDoHomeworkDao.insertOne(userDoHomeworkEntity);
	}
}
