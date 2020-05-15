package com.javatech.dao;
import java.util.List;

import com.javatech.model.IRowMapper;

public interface GenericDAO<T> {
	List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);
	void update (String sql, Object... parameters);
	Integer insert (String sql, Object... parameters);
	int count(String sql, Object... parameters);
}
