package com.javatech.dao.impl;
import java.util.List;

import com.javatech.dao.IKhoaHocDAO;
import com.javatech.model.KhoaHocModel;

public class KhoaHocDAO extends GenreicDAO<KhoaHocModel> implements IKhoaHocDAO {
	
	@Override
	public List<KhoaHocModel> findAll() {
		String sql = "select * from courses where status = 1";
		List<KhoaHocModel> dsKhoaHoc = query(sql, new KhoaHocModel());
		return dsKhoaHoc;
	}

	@Override
	public KhoaHocModel findOne(Integer id) {
		return findOne("courses", new KhoaHocModel(), id);
	}

}
