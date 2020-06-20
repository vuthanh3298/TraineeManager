package com.javatech.service2;

import java.util.List;

import javax.inject.Inject;

import com.javatech.dao2.ChapterDao;
import com.javatech.entity.ChapterEntity;

public class ChapterService {
	@Inject
	ChapterDao chapterDao;
	
	public List<ChapterEntity> getChapterByCourse(Integer courseId){
		StringBuilder sql = new StringBuilder(" select c.*, ");
		sql.append(" s.name as stage_name ");
		sql.append(" from chapter c, (select id, name, courses_id from stage where status = 1) s ");
		sql.append(" where 1 = 1 ");
		sql.append(" and status = 1 ");
		sql.append(" and c.stage_id = s.id ");
		sql.append(" and s.courses_id = ? ");
		sql.append(" order by c.stage_id ");
		return chapterDao.selecList(sql.toString(), courseId);
	}

	public Integer insertOne(ChapterEntity chapterEntity) {
		chapterEntity.setStatus(1);
		return chapterDao.insertOne(chapterEntity);
	}

	public Object selectOne(int id) {
		String sql = "select * from chapter where id = ? and status = 1";
		return chapterDao.selecList(sql, id).get(0);
	}

	public Integer updateOne(ChapterEntity chapterEntity) {
		return chapterDao.updateOne(chapterEntity);
	}

	public Object deleteOne(ChapterEntity chapterEntity) {
		chapterEntity.setStatus(-1);
		return chapterDao.updateOne(chapterEntity);
	}
}
