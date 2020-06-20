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
import com.javatech.model.ClassesModel;
import com.javatech.model.DeadlineModel;
import com.javatech.model.ThongBaoModel;
import com.javatech.service.IClassesService;
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
	@Inject
	IClassesService classesService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.THONG_BAO_VA_DEADLINE)) {
				getThongBaovaDeadline(req, res);
			} else if (action.equals(ActionConstant.ADD_THONG_BAO)) {
				getAddThongBao(req, res);
			} else if (action.equals(ActionConstant.EDIT_THONG_BAO)) {
				getEditThongBao(req, res);
			} else if (action.equals(ActionConstant.VIEW_THONG_BAO)) {
				getViewThongBao(req, res);
			} else if (action.equals(ActionConstant.ADD_DEADLINE)) {
				getAddDeadline(req, res);
			} else if (action.equals(ActionConstant.EDIT_DEADLINE)) {
				getEditDeadline(req, res);
			}else if (action.equals(ActionConstant.VIEW_DEADLINE)) {
				getViewDeadline(req, res);
			}
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


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
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThongBaoVaDeadline");
	}
	
	private void getAddThongBao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<ClassesModel> dsClasses = classesService.findAll();
		if (dsClasses != null) {
			req.setAttribute("dsClasses", dsClasses);
		}
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThongBaoAdd");
	}
	
	private void getEditThongBao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String strID = req.getParameter("id");
		if (strID != null) {
			Integer id = Integer.parseInt(strID);
			ThongBaoModel thongBao = thongBaoService.findOne(id);
			req.setAttribute("thongBao", thongBao);
		}
		List<ClassesModel> dsClasses = classesService.findAll();
		if (dsClasses != null) {
			req.setAttribute("dsClasses", dsClasses);
		}
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThongBaoEdit");
	}

	private void getViewThongBao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String strID = req.getParameter("id");
		if (strID != null) {
			Integer id = Integer.parseInt(strID);
			ThongBaoModel thongBao = thongBaoService.findOne(id);
			req.setAttribute("thongBao", thongBao);
		}
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThongBaoView");
	}
	
	private void getAddDeadline(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<ClassesModel> dsClasses = classesService.findAll();
		if (dsClasses != null) {
			req.setAttribute("dsClasses", dsClasses);
		}
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "DeadlineAdd");
	}
	
	private void getEditDeadline(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String strID = req.getParameter("id");
		if (strID != null) {
			Integer id = Integer.parseInt(strID);
			DeadlineModel deadline = deadlineService.findOne(id);
			req.setAttribute("deadline", deadline);
			
		}
		List<ClassesModel> dsClasses = classesService.findAll();
		if (dsClasses != null) {
			req.setAttribute("dsClasses", dsClasses);
		}
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "DeadlineEdit");
	}
	
	private void getViewDeadline(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {
		String strID = req.getParameter("id");
		if (strID != null) {
			Integer id = Integer.parseInt(strID);
			DeadlineModel deadline = deadlineService.findOne(id);
			req.setAttribute("deadline", deadline);
		}
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "DeadlineView");
	}

}
