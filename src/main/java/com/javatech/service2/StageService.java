package com.javatech.service2;

import java.util.List;

import javax.inject.Inject;

import com.javatech.dao2.StageDao;
import com.javatech.entity.StageEntity;

public class StageService {
	@Inject
	StageDao stageDao;
	
	public Integer insertOne(StageEntity stageEntity) {
		stageEntity.setStatus(1);
		return stageDao.insertOne(stageEntity);
	}
	
	public List<StageEntity> getStageByCourseId(Integer id) {
		return stageDao.getStageByCourseId(id);
	}

	public Object selectOne(int id) {
		return stageDao.selectOne(id);
	}

	public Integer updateOne(StageEntity stageEntity) {
		return stageDao.updateOne(stageEntity);
	}

	public Object deleteOne(StageEntity stageEntity) {
		stageEntity.setStatus(-1);
		return stageDao.updateOne(stageEntity);
	}
}
