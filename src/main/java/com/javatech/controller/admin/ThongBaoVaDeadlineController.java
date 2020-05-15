package com.javatech.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.constant.ActionConstant;
import com.javatech.model.DeadlineModel;
import com.javatech.model.ThongBaoModel;
import com.javatech.service.IDeadlineService;
import com.javatech.service.IThongBaoService;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/admin/thong-bao-deadline" })
public class ThongBaoVaDeadlineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	IThongBaoService thongBaoService;
	@Inject
	IDeadlineService deadlineService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.THONG_BAO_VA_DEADLINE)) {
				getThongBaovaDeadline(req, res);
			} else if (action.equals(ActionConstant.ADD_THONG_BAO)) {
				DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "AddThongBao");
			} else if (action.equals(ActionConstant.EDIT_THONG_BAO)) {
				String strID = req.getParameter("id");
				if (strID != null) {
					Integer id = Integer.parseInt(strID);
					ThongBaoModel thongBao = thongBaoService.findOne(id);
					req.setAttribute("thongBao", thongBao);
				}
				DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "EditThongBao");
			} else if (action.equals(ActionConstant.VIEW_THONG_BAO)) {
				String strID = req.getParameter("id");
				if (strID != null) {
					Integer id = Integer.parseInt(strID);
					ThongBaoModel thongBao = thongBaoService.findOne(id);
					req.setAttribute("thongBao", thongBao);
				}
				DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ViewThongBao");
			} else if (action.equals(ActionConstant.ADD_DEADLINE)) {
				DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "AddDeadline");
			}else if (action.equals(ActionConstant.EDIT_DEADLINE)) {
				String strID = req.getParameter("id");
				if (strID != null) {
					Integer id = Integer.parseInt(strID);
					DeadlineModel deadline = deadlineService.findOne(id);
					req.setAttribute("deadline", deadline);
				}
				DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "EditDeadline");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}

	private void getThongBaovaDeadline(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		List<ThongBaoModel> dsThongBao = thongBaoService.findAll();
		if (dsThongBao != null) {
			req.setAttribute("dsThongBao", dsThongBao);
		}
		List<DeadlineModel> dsDeadline = deadlineService.findAll();
		if (dsDeadline != null) {
			req.setAttribute("dsDeadline", dsDeadline);
		}
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThongBaoVaDeadline");
	}
}
