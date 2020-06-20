package com.javatech.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.entity.ChapterEntity;
import com.javatech.service2.ChapterService;
import com.javatech.utils.ConvertUtil;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/api/chapter" })
public class ChapterAPI extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	@Inject
	ChapterService chapterService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		Object stage = chapterService.selectOne(Integer.parseInt(id));
		DispatcherUtil.send(res, stage);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ChapterEntity chapterEntity = ConvertUtil.toModelOfAPI(ChapterEntity.class, req);
		Object stage = chapterService.deleteOne(chapterEntity);
		DispatcherUtil.send(res, stage);
	}
}
