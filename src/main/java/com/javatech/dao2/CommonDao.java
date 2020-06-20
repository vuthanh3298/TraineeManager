package com.javatech.dao2;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.apache.commons.lang.ArrayUtils;

import com.javatech.anotatiton.Column;
import com.javatech.anotatiton.CommonTable;
import com.javatech.anotatiton.Id;
import com.javatech.anotatiton.Table;
import com.javatech.utils.SessionUtil;

public class CommonDao<T> {

	private Class<?> clazz;
	private Field[] fields;
	private String tableName = "";
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

	/**
	 * initialize clazz, fields, tableName
	 */
	public CommonDao() {
		try {
			Type typeGeneric = this.getClass().getGenericSuperclass();
			Type typeClass = ((ParameterizedType) typeGeneric).getActualTypeArguments()[0];
			String className = typeClass.toString().split(" ")[1];
			this.clazz = Class.forName(className);

			if (clazz.isAnnotationPresent(Table.class)) {
				Table table = clazz.getAnnotation(Table.class);
				this.tableName = table.value();
			}

			Class<?> superClass = this.clazz.getSuperclass();
			if (superClass.isAnnotationPresent(CommonTable.class)) {
				this.fields = (Field[]) ArrayUtils.addAll(this.clazz.getSuperclass().getDeclaredFields(),
						this.clazz.getDeclaredFields());
			} else {
				this.fields = this.clazz.getDeclaredFields();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	private T convertToEntity(ResultSet resultSet) {
		try {
			T instance = (T) this.clazz.newInstance();
			for (Field field : this.fields) {
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					field.setAccessible(true);

					if (!hasColumn(resultSet, column.value())) {
						continue;
					}

					Object value = resultSet.getObject(column.value());
					if (value == null) {
						continue;
					}

					if (field.getType().isAssignableFrom(Integer.class)) {
						field.set(instance, resultSet.getInt(column.value()));
					} else if (field.getType().isAssignableFrom(Long.class)) {
						field.set(instance, resultSet.getLong(column.value()));
					} else if (field.getType().isAssignableFrom(String.class)) {
						field.set(instance, resultSet.getString(column.value()));
					} else if (field.getType().isAssignableFrom(Timestamp.class)) {
						field.set(instance, resultSet.getTimestamp(column.value()));
					} else if (field.getType().isAssignableFrom(Boolean.class)) {
						field.set(instance, resultSet.getBoolean(column.value()));
					}
				}
			}
			return instance;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean hasColumn(ResultSet rs, String column) {
		try{
	        rs.findColumn(column);
	        return true;
	    } catch (SQLException sqlex){
	        sqlex.printStackTrace();
	    }
	    return false;
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				} else if (parameter instanceof Boolean) {
					statement.setBoolean(index, (Boolean) parameter);
				} else if (parameter == null) {
					statement.setNull(index, 0);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public T selectOne(Integer id) { // TO-DO Object... ids getAnotaion @Id with value
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			StringBuilder sql = new StringBuilder("select * from ");
			sql.append(tableName);
			sql.append(" where id = ?");
			statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return convertToEntity(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				// e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * if status is null or empty then select all without status condition
	 * 
	 * @param status
	 * @return List<T>
	 */
	public List<T> selectAll(Integer... status) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			StringBuilder sql = new StringBuilder("select * from ");
			sql.append(tableName);
			if (status != null && status.length > 0) {
				sql.append(" where status =? ");
				statement = connection.prepareStatement(sql.toString());
				statement.setInt(1, status[0]);
				// setParameter(statement, status[0]);
			} else {
				statement = connection.prepareStatement(sql.toString());
			}
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(convertToEntity(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	public List<T> selecList(String sql, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(convertToEntity(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	public Integer query(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			int result = statement.executeUpdate();
			connection.commit();
			return result;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return -1;
	}

	public int count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			int count = 0;
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}
	}

	public Integer insertOne(T instance) {
		try {
			List<String> fieldsInsert = new ArrayList<>();
			List<Object> valueInsert = new ArrayList<>();
			List<String> questionMarks = new ArrayList<>();

			for (Field field : this.fields) {
				if (field.isAnnotationPresent(Column.class)) {
					field.setAccessible(true);
					Object value = field.get(instance);
					Column column = field.getAnnotation(Column.class);
					if (value != null || column.value().equals("created_by") || column.value().equals("modified_by")
							|| column.value().equals("created_date") || column.value().equals("modified_date")) {

						fieldsInsert.add(column.value());
						questionMarks.add("?");
						if (column.value().equals("created_by") || column.value().equals("modified_by")) {
							valueInsert.add(SessionUtil.getUserId());
						} else if (column.value().equals("created_date") || column.value().equals("modified_date")) {
							valueInsert.add(new Timestamp((new Date()).getTime()));
						} else {
							valueInsert.add(value);
						}
					}
				}
			}
			String fieldsStr = fieldsInsert.stream().collect(Collectors.joining(", "));
			String questionMarkStr = questionMarks.stream().collect(Collectors.joining(", "));
			StringBuilder sql = new StringBuilder("INSERT INTO ");
			sql.append(tableName);
			sql.append(" ( ");
			sql.append(fieldsStr);
			sql.append(" ) values ( ");
			sql.append(questionMarkStr);
			sql.append(" )");
			return query(sql.toString(), valueInsert.toArray());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	public Integer updateOne(T instance) {
		try {
			List<String> fieldsUpdate = new ArrayList<>();
			List<String> idsUpdate = new ArrayList<>();

			List<Object> valuesUpdate = new ArrayList<>();
			List<Object> valueIdsUpdate = new ArrayList<>();

			for (Field field : this.fields) {
				field.setAccessible(true);
				Column column = field.getAnnotation(Column.class);
				if (field.isAnnotationPresent(Id.class)) {
					Object value = field.get(instance);
					if (value == null) {
						throw new Exception("[UPDATE FAIL] Id of instance is null");
					}
					idsUpdate.add(" AND " + column.value() + " = ? ");
					valueIdsUpdate.add(value);
				} else if (field.isAnnotationPresent(Column.class)) {
					Object value = field.get(instance);
					if (value != null || column.value().equals("modified_by")
							|| column.value().equals("modified_date")) {
						fieldsUpdate.add(column.value() + " = ?");
						if (column.value().equals("modified_by")) {
							valuesUpdate.add(SessionUtil.getUserId());
						} else if (column.value().equals("modified_date")) {
							valuesUpdate.add(new Timestamp((new Date()).getTime()));
						} else {
							valuesUpdate.add(value);
						}
					}
				}
			}
			String fieldsStr = fieldsUpdate.stream().collect(Collectors.joining(", "));
			String idsStr = idsUpdate.stream().collect(Collectors.joining(" "));
			StringBuilder sql = new StringBuilder("UPDATE ");
			sql.append(tableName);
			sql.append(" SET ");
			sql.append(fieldsStr);
			sql.append(" WHERE 1 = 1 ");
			sql.append(idsStr);
			System.out.println(sql.toString());
			return query(sql.toString(), ArrayUtils.addAll(valuesUpdate.toArray(), valueIdsUpdate.toArray()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	public Integer deleteOne(T instance) {
		try {
			List<String> idsUpdate = new ArrayList<>();
			List<Object> valueIdsUpdate = new ArrayList<>();

			for (Field field : this.fields) {
				field.setAccessible(true);
				Column column = field.getAnnotation(Column.class);
				if (field.isAnnotationPresent(Id.class)) {
					Object value = field.get(instance);
					if (value == null) {
						throw new Exception("[UPDATE FAIL] Id of instance is null");
					}
					idsUpdate.add(" AND " + column.value() + " = ? ");
					valueIdsUpdate.add(value);
				}
			}
			String idsStr = idsUpdate.stream().collect(Collectors.joining(" "));
			StringBuilder sql = new StringBuilder("DELETE FROM ");
			sql.append(tableName);
			sql.append(" WHERE 1 = 1 ");
			sql.append(idsStr);
			System.out.println(sql.toString());
			return query(sql.toString(), valueIdsUpdate.toArray());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
}
