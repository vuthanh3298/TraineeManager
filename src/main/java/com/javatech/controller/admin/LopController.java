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
import com.javatech.model.ClassModel;
import com.javatech.model.KhoaHocModel;
import com.javatech.model.UserModel;
import com.javatech.service.IClassService;
import com.javatech.service.IKhoaHocService;
import com.javatech.utils.ConvertUtil;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/admin/danh-sach-lop", "/admin/xep-lop" })
public class LopController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	IClassService classService;

	@Inject
	IKhoaHocService khoaHocService;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.DANH_SACH_LOP)) {
				getDanhSachLop(req, res);
			} else if (action.equals(ActionConstant.XEP_LOP)) {
				getXepLop(req, res);
			}

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.DELETE_LOP)) {
				deleteClass(req, res);
			} else if(action.equals(ActionConstant.EDIT_LOP)) {
				editClass(req, res);
			}
		}
	}

	private void editClass(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ClassModel classModel = ConvertUtil.toModelOfController(ClassModel.class, req);
		if (classService.update(classModel)) {
			DispatcherUtil.redirect(req, res,
					"/admin/danh-sach-lop?action=danhsachlop&message=update_thanh_cong&alert=success");
		} else {
			DispatcherUtil.redirect(req, res,
					"/admin/danh-sach-lop?action=danhsachlop&message=update_that_bai&alert=warning");
		}
	}

	private void deleteClass(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		classService.delClass(id);
		DispatcherUtil.redirect(req, res, "/admin/danh-sach-lop?action=danhsachlop");
	}

	private void getXepLop(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "XepLop");

	}

	private void getDanhSachLop(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String courseStr = req.getParameter("course");
		List<KhoaHocModel> dsCourse = khoaHocService.findAll();
		List<ClassModel> dsClass;
		if (courseStr != null) {
			int tempInt = Integer.parseInt(courseStr);
			if (tempInt == -1) {
				dsClass = classService.findAll();
			} else {
				dsClass = classService.findByCourse(tempInt);
			}
		} else {
			dsClass = classService.findAll();
		}
		req.setAttribute("dsClass", dsClass);
		req.setAttribute("dsCourse", dsCourse);
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "DanhSachLop");

	}

}
