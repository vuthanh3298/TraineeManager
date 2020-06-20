package com.javatech.dao2;

import java.util.List;

import com.javatech.entity.LessonEntity;

public class LessonDao extends CommonDao<LessonEntity>{

	public List<LessonEntity> getLessonByCourse(Integer courseId) {
		StringBuilder sql = new StringBuilder(" select l.*, ");
		sql.append(" s.name as stage_name ");
		sql.append(" from lesson l, (select id, name, courses_id from stage where status = 1) s ");
		sql.append(" where 1 = 1 ");
		sql.append(" and status = 1 ");
		sql.append(" and l.stage_id = s.id ");
		sql.append(" and s.courses_id = ? ");
		sql.append(" order by l.stage_id ");
		return selecList(sql.toString(), courseId);
	}

}
