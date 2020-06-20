package com.javatech.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.constant.ActionConstant;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/admin/diem-danh","/admin/tien-do"})
public class TienDoController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.DIEM_DANH)) {
				getDiemDanh(req, res);
			} else if (action.equals(ActionConstant.TIEN_DO)) {
				getTienDo(req, res);
			}
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		super.doPost(req, res);
	}
	private void getTienDo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "TienDo");
		
	}

	private void getDiemDanh(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "DiemDanh");
		
	}
}
