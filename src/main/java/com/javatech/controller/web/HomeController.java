package com.javatech.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.model.ClassesModel;
import com.javatech.model.DeadlineModel;
import com.javatech.model.ThongBaoModel;
import com.javatech.service.IClassesService;
import com.javatech.service.IDeadlineService;
import com.javatech.service.IThongBaoService;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	IThongBaoService thongBaoService;
	@Inject
	IDeadlineService deadlineService;
	@Inject
	IClassesService classesService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		getThongBaovaDeadline(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		super.doPost(req, res);
	}
	
	private void getThongBaovaDeadline(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String clazz = req.getParameter("class");
		if(clazz != null) {
			List<ThongBaoModel> dsThongBao = thongBaoService.findByClass(clazz);
			if (dsThongBao != null) {
				req.setAttribute("dsThongBao", dsThongBao);
				req.setAttribute("clazz", clazz);
			}
		} else {
			List<ThongBaoModel> dsThongBao = thongBaoService.findAll();
			if (dsThongBao != null) {
				req.setAttribute("dsThongBao", dsThongBao);
				req.setAttribute("clazz", "Tất cả");
			}
		}
		String classDeadline = req.getParameter("classDeadline");
		if(classDeadline != null) {
			List<DeadlineModel> dsDeadline = deadlineService.findByClass(classDeadline);
			if (dsDeadline != null) {
				req.setAttribute("dsDeadline", dsDeadline);
				req.setAttribute("classDeadline", classDeadline);
			}
		} else {
			List<DeadlineModel> dsDeadline = deadlineService.findAll();
			if (dsDeadline != null) {
				req.setAttribute("dsDeadline", dsDeadline);
				req.setAttribute("classDeadline", "Tất cả");
			}
		}
		List<ClassesModel> dsClasses = classesService.findAll();
		if (dsClasses != null) {
			req.setAttribute("dsClasses", dsClasses);
		}
		String tab = req.getParameter("tab");
		if (tab != null) {
			req.setAttribute("tab", tab);
		}
		DispatcherUtil.returnViewName(req, res, "web/Home");
	}
}
