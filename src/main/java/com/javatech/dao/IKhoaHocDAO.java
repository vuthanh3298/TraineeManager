package com.javatech.dao;
import java.util.List;

import com.javatech.model.KhoaHocModel;

public interface IKhoaHocDAO {
	List<KhoaHocModel> findAll();
	KhoaHocModel findOne(Integer id);
}
