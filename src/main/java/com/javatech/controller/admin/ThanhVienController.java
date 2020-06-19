package com.javatech.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.constant.ActionConstant;
import com.javatech.model.ClassModel;
import com.javatech.model.UserModel;
import com.javatech.service.IClassService;
import com.javatech.service.IUserService;
import com.javatech.utils.ConvertUtil;
import com.javatech.utils.DispatcherUtil;
import com.javatech.utils.HttpUtil;

@WebServlet(urlPatterns = { "/admin/thanh-vien", "/admin/thanh-vien-cho-duyet" })
public class ThanhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	IUserService userService;
	@Inject
	IClassService classService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.print("GET");
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.THANH_VIEN)) {
				getThanhVien(req, res);
			} else if (action.equals(ActionConstant.CHO_DUYET)) {
				getChoDuyet(req, res);
			} else if (action.equals(ActionConstant.DELETED)) {
				getDeleted(req, res);
			} else if (action.equals(ActionConstant.DUYET_USER)) {
				duyetUser(req, res, action);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.print("POST");
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.THANH_VIEN)) {
				postThanhVien(req, res);
			} else if (action.equals(ActionConstant.CHO_DUYET)) {
				getChoDuyet(req, res);
			} else if (action.equals(ActionConstant.EDIT_USER)) {
				editUser(req, res);
			} else if (action.equals(ActionConstant.CREATE_USER)) {
				createUser(req, res);
			} else if (action.equals(ActionConstant.RE_ACTIVE)) {
				duyetUser(req, res, action);
			} else if (action.equals(ActionConstant.DELETE_USER) || action.equals(ActionConstant.DELETE_USER_PENDING)) {
				deleteUser(req, res, action);
			}
		}
	}

	protected void deleteUser(HttpServletRequest req, HttpServletResponse resp, String action)
			throws ServletException, IOException {
		System.out.print("DELETE USER\n");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		int id = Integer.parseInt(req.getParameter("id"));
		// UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		userService.deleteUser(id);
		if (action.equals(ActionConstant.DELETE_USER)) {
			DispatcherUtil.redirect(req, resp, "/admin/thanh-vien?action=thanhvien");
		} else if (action.equals(ActionConstant.DELETE_USER_PENDING)) {
			DispatcherUtil.redirect(req, resp, "/admin/thanh-vien-cho-duyet?action=choduyet");
		}
	}

	protected void duyetUser(HttpServletRequest req, HttpServletResponse resp, String action)
			throws ServletException, IOException {
		System.out.print("DELETE USER\n");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		if (action.equals(ActionConstant.RE_ACTIVE)) {
			int id = Integer.parseInt(req.getParameter("id"));
			userService.duyetUser(id);
			DispatcherUtil.redirect(req, resp, "/admin/thanh-vien-cho-duyet?action=deleted");
		} else if (action.equals(ActionConstant.DUYET_USER)) {
			int user_id = Integer.parseInt(req.getParameter("userid"));
			int class_id = Integer.parseInt(req.getParameter("class"));
			userService.duyetUser(user_id);
			classService.insertUserIntoClass(user_id, class_id);
			DispatcherUtil.redirect(req, resp, "/admin/thanh-vien-cho-duyet?action=choduyet");
		} else {
			DispatcherUtil.redirect(req, resp, "/admin/thanh-vien-cho-duyet?action=choduyet");
		}
	}

	private void editUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserModel userModel = ConvertUtil.toModelOfController(UserModel.class, req);
		if (userService.update(userModel)) {
			DispatcherUtil.redirect(req, res,
					"/admin/thanh-vien?action=thanhvien&message=update_thanh_cong&alert=success");
		} else {
			DispatcherUtil.redirect(req, res,
					"/admin/thanh-vien?action=thanhvien&message=update_that_bai&alert=warning");
		}
	}

	private void postThanhVien(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub

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

	private void getThanhVien(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setMessage(req);
		String classStr = req.getParameter("class");
		// List<UserModel> dsThanhVien = userService.findAll();
		// List<UserModel> dsThanhVien = userService.findAllTrainees();
		List<ClassModel> dsClass = classService.findAll();
		List<UserModel> dsThanhVien;
		if (classStr != null) {
			int tempInt = Integer.parseInt(classStr);
			if (tempInt == -1) {
				dsThanhVien = userService.findAllTrainees();
			} else {
				dsThanhVien = userService.findByClass(Integer.parseInt(classStr));
			}
		} else {
			dsThanhVien = userService.findAllTrainees();
		}

		req.setAttribute("dsThanhVien", dsThanhVien);
		req.setAttribute("dsClass", dsClass);
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThanhVien");
	}

	private void getDeleted(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setMessage(req);
		// List<UserModel> dsThanhVien = userService.findAll();
		List<UserModel> dsThanhVien = userService.findAllDeleted();
		req.setAttribute("dsThanhVien", dsThanhVien);
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThanhVienDeleted");
	}

	private void getChoDuyet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setMessage(req);
		// List<UserModel> dsThanhVien = userService.findAllStatus0();
		List<ClassModel> dsClass = classService.findAll();
		List<UserModel> dsThanhVien = userService.findAllPending();
		// classService.insertUserIntoClass(1, 4);
		req.setAttribute("dsThanhVien", dsThanhVien);
		req.setAttribute("dsClass", dsClass);
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ChoDuyet");
	}

	private void createUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserModel userModel = ConvertUtil.toModelOfController(UserModel.class, req);
		if (userService.isEmailExist(userModel.getEmail())) {
			DispatcherUtil.redirect(req, res, "/admin/thanh-vien?action=thanhvien&message=email_ton_tai&alert=danger");
			return;
		}
		if (userService.createUser(userModel) != null) {
			DispatcherUtil.redirect(req, res, "/admin/thanh-vien?action=thanhvien");
			System.out.println(userService.createUser(userModel));
		}

	}

}
