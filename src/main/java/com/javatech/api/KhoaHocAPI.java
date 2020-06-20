package com.javatech.api;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.dto.CommonDTO;
import com.javatech.model.KhoaHocModel;
import com.javatech.service.IKhoaHocService;
import com.javatech.service2.CourseService;
import com.javatech.utils.ConvertUtil;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = {"/api/khoa-hoc"})
public class KhoaHocAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	IKhoaHocService khoaHocService;
	
	@Inject
	CourseService courseService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CommonDTO model = ConvertUtil.toModelOfAPI(CommonDTO.class, req);
		KhoaHocModel khoacHocModel = khoaHocService.findOne(model.getId());
		DispatcherUtil.send(res, khoacHocModel);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CommonDTO model = ConvertUtil.toModelOfAPI(CommonDTO.class, req);
		Integer result = courseService.deleteByStatus(model.getId());
		DispatcherUtil.send(res, result);
	}
	
}