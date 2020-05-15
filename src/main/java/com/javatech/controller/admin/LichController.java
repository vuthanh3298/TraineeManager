package com.javatech.controller.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.constant.ActionConstant;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/admin/thong-tin-dang-ky-lich","/admin/soan-thoi-khoa-bieu","/admin/thong-tin-xin-nghi"})
public class LichController extends HttpServlet{
	private static final long serialVersionUID = 1L;
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

	private void getThongTinDangKyLich(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThongTinDangKyLich");
		
	}
	private void getThoiKhoaBieu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThoiKhoaBieu");
		
	}
	private void getThongTinXinNghi(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThongTinXinNghi");
		
	}
	

}
