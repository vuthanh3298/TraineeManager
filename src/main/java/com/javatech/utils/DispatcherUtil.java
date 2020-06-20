package com.javatech.utils;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatech.constant.SystemConstant;
import com.javatech.model.UserModel;

public class DispatcherUtil {
	public static ResourceBundle resourceBundle = ResourceBundle.getBundle("page_name");

	public static void returnViewNameAdminAndSetPageName(HttpServletRequest req, HttpServletResponse res, String pageName) throws ServletException, IOException {
		req.setAttribute(SystemConstant.PAGE_NAME, resourceBundle.getString(pageName));
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/" + pageName + ".jsp");
		rd.forward(req, res);
	}

	public static void returnViewName(HttpServletRequest req, HttpServletResponse res, String pageName) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/" + pageName + ".jsp");
		rd.forward(req, res);
	}
	
	public static void redirect(HttpServletRequest req, HttpServletResponse res, String url) throws ServletException, IOException {
		res.sendRedirect(req.getContextPath() + url);
	}
	
	public static void redirectByUserRole(HttpServletRequest req, HttpServletResponse res, UserModel userModel) throws ServletException, IOException {
		if (userModel.getRole().getCode().equals(SystemConstant.USER_ROLE)) {
			res.sendRedirect(req.getContextPath() + "/trang-chu");
		} else if (userModel.getRole().getCode().equals(SystemConstant.ADMIN_ROLE)) {
			res.sendRedirect(req.getContextPath() + "/admin/trang-chu");
		}
	}
	
	public static void send(HttpServletResponse res, Object object) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(res.getOutputStream(), object);
	}
}
