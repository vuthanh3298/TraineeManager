package com.javatech.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.entity.StageEntity;
import com.javatech.service2.StageService;
import com.javatech.utils.ConvertUtil;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/api/stage" })
public class StageAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	StageService stageService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		Object stage = stageService.selectOne(Integer.parseInt(id));
		DispatcherUtil.send(res, stage);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StageEntity stageEntity = ConvertUtil.toModelOfAPI(StageEntity.class, req);
		Object stage = stageService.deleteOne(stageEntity);
		DispatcherUtil.send(res, stage);
	}
}
