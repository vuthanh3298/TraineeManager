package com.javatech.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.constant.ActionConstant;
import com.javatech.entity.DeadlineEntity;
import com.javatech.entity.ThongBaoEntity;
import com.javatech.service2.DeadlineService;
import com.javatech.service2.ThongBaoService;
import com.javatech.service2.ThongTinDangKyLichService;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/thong-bao-deadline" ,"/thong-tin-dang-ky-lich"})
public class ThongBaoVaDeadlineController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	ThongBaoService thongBaoService;
	@Inject
	DeadlineService deadlineService;
	@Inject
	ThongTinDangKyLichService thongTinDangKyLichService;
	
	
	///thong-bao-deadline?action=view_thong_bao&id=${thongBao.id}"
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.VIEW_THONG_BAO)) {
				getViewThongBao(req, res);
			}else if (action.equals(ActionConstant.VIEW_DEADLINE)) {
				getViewDeadline(req, res);
			}
		}
		
		  else { getThongTinDangKyLich(req, res); }
		 
		//DispatcherUtil.returnViewName(req, res, "web/ThongTinDangKyLich");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


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
	private void getViewDeadline(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {
		String strID = req.getParameter("id");
		if (strID != null) {
			Integer id = Integer.parseInt(strID);
			DeadlineEntity deadline = deadlineService.findOne(id);
			req.setAttribute("deadline", deadline);
		}
		DispatcherUtil.returnViewName(req, res, "web/DeadlineView");
	}
	private void getViewThongBao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String strID = req.getParameter("id");
		if (strID != null) {
			Integer id = Integer.parseInt(strID);
			ThongBaoEntity thongBao = thongBaoService.findOne(id);
			req.setAttribute("thongBao", thongBao);
		}
		DispatcherUtil.returnViewName(req, res, "web/ThongBaoView");
	}
	
	private void getThongTinDangKyLich(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		setMessage(req);
		Object dsDangKyLich;
		dsDangKyLich = thongTinDangKyLichService.findByIdUser();
		if (dsDangKyLich != null) {
			req.setAttribute("dsDangKyLich", dsDangKyLich);
		}
		DispatcherUtil.returnViewName(req, res, "web/ThongTinDangKyLich");
	}

}
