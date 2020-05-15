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
import com.javatech.model.UserModel;
import com.javatech.service.IUserService;
import com.javatech.utils.ConvertUtil;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/admin/thanh-vien", "/admin/thanh-vien-cho-duyet" })
public class ThanhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	IUserService userService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.THANH_VIEN)) {
				getThanhVien(req, res);
			} else if (action.equals(ActionConstant.CHO_DUYET)) {
				getChoDuyet(req, res);
			}
		}
	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.THANH_VIEN)) {
				postThanhVien(req, res);
			} else if (action.equals(ActionConstant.CHO_DUYET)) {
				getChoDuyet(req, res);
			}else if(action.equals(ActionConstant.EDIT_USER)) {
				editUser(req,res);
			}else if(action.equals(ActionConstant.CREATE_USER)) {
				create_user(req, res);
				
			}
		}
	}
	private void editUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		UserModel userModel = ConvertUtil.toModelOfController(UserModel.class, req);
		if(userService.update(userModel)) {
			DispatcherUtil.redirect(req, res, "/admin/thanh-vien?action=thanhvien&message=update_thanh_cong&alert=success");
		} else {
			DispatcherUtil.redirect(req, res, "/admin/thanh-vien?action=thanhvien&message=update_that_bai&alert=warning");
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
		List<UserModel> dsThanhVien = userService.findAll();
		req.setAttribute("dsThanhVien", dsThanhVien);
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThanhVien");
	}
	
	private void getChoDuyet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setMessage(req);
		List<UserModel> dsThanhVien = userService.findAllStatus0();
		req.setAttribute("dsThanhVien", dsThanhVien);
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ChoDuyet");
	}

	private void create_user(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserModel userModel = ConvertUtil.toModelOfController(UserModel.class, req);
		if(userService.isEmailExist(userModel.getEmail())) {
			DispatcherUtil.redirect(req, res, "/admin/thanh-vien?action=thanhvien&message=email_ton_tai&alert=danger");
			return;
		}
		if(userService.createUser(userModel) != null) {
			DispatcherUtil.redirect(req, res, "/admin/thanh-vien?action=thanhvien");
			System.out.println(userService.createUser(userModel));
		} 
		
	}

}
