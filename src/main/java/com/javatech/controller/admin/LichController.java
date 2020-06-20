package com.javatech.controller.admin;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.constant.ActionConstant;
import com.javatech.service2.ClassesService;
import com.javatech.service2.LessonService;
import com.javatech.service2.ThongTinDangKyLichService;
import com.javatech.utils.DispatcherUtil;
import com.javatech.utils.StringUtil;

@WebServlet(urlPatterns = { "/admin/thong-tin-dang-ky-lich","/admin/soan-thoi-khoa-bieu","/admin/thong-tin-xin-nghi"})
public class LichController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	ThongTinDangKyLichService thongTinDangKyLichService;
	@Inject
	ClassesService classesService;
	@Inject
	LessonService lessonService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.THONG_TIN_DANG_KY_LICH)) {
				getThongTinDangKyLich(req, res);
			} else if (action.equals(ActionConstant.SOAN_THOI_KHOA_BIEU)) {
				getThoiKhoaBieu(req, res);
			}else if (action.equals(ActionConstant.THONG_TIN_XIN_NGHI)) {
				getThongTinXinNghi(req, res);
			}
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		super.doPost(req, res);
	}
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	private void setMessage(HttpServletRequest req) {
		String message = req.getParameter("message");
		if (message != null) {
			String alert = req.getParameter("alert");
			req.setAttribute("message", resourceBundle.getString(message));
			req.setAttribute("alert", alert);
		}
	}

	private void getThongTinDangKyLich(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
			setMessage(req);
			String weekInYear = req.getParameter("weekinyear");
			Object dsDangKyLich;
			if(StringUtil.isNullOrEmpty(weekInYear)) {
				 dsDangKyLich = thongTinDangKyLichService.findAll();
			}else {
				req.setAttribute("weekInYear", weekInYear);
				dsDangKyLich = thongTinDangKyLichService.findByWeekInYear(weekInYear);
			}
			if (dsDangKyLich != null) {
				req.setAttribute("dsDangKyLich", dsDangKyLich);
			}
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThongTinDangKyLich");
	}
	private void getThoiKhoaBieu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		Object lessons = lessonService.selectAll();
		req.setAttribute("lessons", lessons);
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThoiKhoaBieu");
		
	}
	private void getThongTinXinNghi(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThongTinXinNghi");
		
	}
	

}
