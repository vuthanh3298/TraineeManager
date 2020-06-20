package com.javatech.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.entity.LessonEntity;
import com.javatech.service2.LessonService;
import com.javatech.utils.ConvertUtil;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/api/lesson" })
public class LessonAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	LessonService lessonService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		Object lesson = lessonService.selectOne(Integer.parseInt(id));
		DispatcherUtil.send(res, lesson);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LessonEntity lessonEntity = ConvertUtil.toModelOfAPI(LessonEntity.class, req);
		Object lesson = lessonService.deleteOne(lessonEntity);
		DispatcherUtil.send(res, lesson);
	}
}
