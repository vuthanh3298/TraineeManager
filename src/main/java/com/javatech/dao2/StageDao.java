package com.javatech.dao2;

import java.util.List;

import com.javatech.entity.StageEntity;

public class StageDao extends CommonDao<StageEntity> {

	public List<StageEntity> getStageByCourseId(Integer id) {
		String sql = "select * from stage where courses_id = ? and status = 1";
		return selecList(sql, id);
	}

}
