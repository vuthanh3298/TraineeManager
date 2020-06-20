package com.javatech.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertUtil {
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <T> T toModelOfController(Class<T> tclass, HttpServletRequest req){
		T object = null;
		try {
			
			DateConverter converter = new DateConverter( null );
			converter.setPattern("yyyy-MM-dd");
			ConvertUtils.register(converter, java.sql.Timestamp.class);
			object = tclass.newInstance();
			BeanUtils.populate(object, req.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.print(e.getMessage());
		}
		return object;
	}
	
	public static <T> T toModelOfAPI(Class<T> tclass, HttpServletRequest req) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = req.getReader();
			String line;
		    while ((line = reader.readLine()) != null) {
		        sb.append(line);
		    }
		    return new ObjectMapper().readValue(sb.toString(), tclass);
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
}
