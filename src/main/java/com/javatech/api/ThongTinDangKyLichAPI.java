package com.javatech.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.constant.ActionConstant;
import com.javatech.entity.ThongTinDangKyLichEntity;
import com.javatech.entity.UserDoHomeworkEntity;
import com.javatech.service2.ThongTinDangKyLichService;
import com.javatech.service2.UserDoHomeworkService;
import com.javatech.utils.ConvertUtil;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/api/thong-tin-dang-ky-lich","/api/luu-thong-tin-deadline"})
public class ThongTinDangKyLichAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	ThongTinDangKyLichService thongTinDangKyLichService;
	
	@Inject
	UserDoHomeworkService userDoHomeworkService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.SAVE_THONG_TIN_DANG_KY_LICH)) {
				postSaveThongTinDangKyLich(req, res);
			}else if (action.equals(ActionConstant.SAVE_THONG_TIN_DEADLINE)) {
				postSaveThongTinDeadline(req, res);
			}
		}
		
	}
	

	private void postSaveThongTinDangKyLich(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ThongTinDangKyLichEntity thongTinDangKyLichEntity = ConvertUtil.toModelOfAPI(ThongTinDangKyLichEntity.class, req);
		if (thongTinDangKyLichService.saveThongTinDangKyLich(thongTinDangKyLichEntity) > 0) {
			DispatcherUtil.send(res, true);
		}
	}
	
	private void postSaveThongTinDeadline(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
		UserDoHomeworkEntity userDoHomeworkEntity = ConvertUtil.toModelOfAPI(UserDoHomeworkEntity.class, req);
		if (userDoHomeworkService.saveThongTinDangKyLich(userDoHomeworkEntity) > 0) {
			DispatcherUtil.send(res, true);
		}
	}

}
