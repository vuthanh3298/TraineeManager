package com.javatech.api;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.constant.ActionConstant;
import com.javatech.dto.CommonDTO;
import com.javatech.model.UserModel;
import com.javatech.service.IUserService;
import com.javatech.utils.ConvertUtil;
import com.javatech.utils.DispatcherUtil;
import com.javatech.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api/users"})
public class UserAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	IUserService userService;
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		userService.update(userModel);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		userService.deleteUser(userModel.getId());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		String action = req.getParameter("action");
		/* Convert json to UserModel */
		UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		userService.createUser(userModel);
		
		if(action != null) {
			if(action.equals(ActionConstant.CHECK_EMAIL_EXIST)) {
				postCheckEmailExist(req, res);
			} else if (action.equals(ActionConstant.GET_USER)) {
				postGetUser(req, res);
			} else if (action.equals(ActionConstant.DELETE_USER)) {
				deleteUser(req, res);
			} else if (action.equals(ActionConstant.DUYET_USER)) {
				duyetUser(req, res);
			} else if (action.equals(ActionConstant.DUYET_USERS)) {
				duyetUsers(req, res);
			} else if (action.equals(ActionConstant.DELETE_USERS_CHO_DUYET)) {
				xoaUsersChoDuyet(req, res);
			} else if (action.equals(ActionConstant.DELETE_USER_CHO_DUYET)) {
				xoaUserChoDuyet(req, res);
			}
		}
	}
	
	private void postCheckEmailExist(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		CommonDTO model = ConvertUtil.toModelOfAPI(CommonDTO.class, req);
		if (userService.isEmailExist(model.getEmail())) {
			DispatcherUtil.send(res, 1);
		} else {
			DispatcherUtil.send(res, 0);
		}
	}
	private void postGetUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CommonDTO model = ConvertUtil.toModelOfAPI(CommonDTO.class, req);
		UserModel user = userService.findOne(model.getId());
		DispatcherUtil.send(res, user);
	}
	private void deleteUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		CommonDTO model = ConvertUtil.toModelOfAPI(CommonDTO.class, req);
		Boolean delUser=userService.deleteUser(model.getId());
		DispatcherUtil.send(res, delUser);
	}
	private void duyetUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		CommonDTO model = ConvertUtil.toModelOfAPI(CommonDTO.class, req);
		Boolean duyetIdUser=userService.duyetUser(model.getId());
		System.out.print("DUYET");
		DispatcherUtil.send(res, duyetIdUser);
	}
	private void duyetUsers(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		CommonDTO model = ConvertUtil.toModelOfAPI(CommonDTO.class, req);
		Boolean duyetIdUsers=userService.duyetUsers(model.getIds());
		DispatcherUtil.send(res, duyetIdUsers);
	}
	private void xoaUsersChoDuyet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		CommonDTO model = ConvertUtil.toModelOfAPI(CommonDTO.class, req);
		Boolean xoaIdUsersChoDuyet=userService.xoaIdUsersChoDuyet(model.getIds());
		DispatcherUtil.send(res, xoaIdUsersChoDuyet);
	}

	private void xoaUserChoDuyet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CommonDTO model = ConvertUtil.toModelOfAPI(CommonDTO.class, req);
		Boolean xoaUserChoDuyet=userService.xoaUserChoDuyet(model.getId());
		DispatcherUtil.send(res, xoaUserChoDuyet);		
	}
	/*
	 * private void postEditUser(HttpServletRequest req, HttpServletResponse res)
	 * throws ServletException, IOException { UserModel userModel =
	 * HttpUtil.of(req.getReader()).toModel(UserModel.class); if
	 * (userService.update(userModel)) { DispatcherUtil.send(res, 1); } else {
	 * DispatcherUtil.send(res, 0); } }
	 */
}
