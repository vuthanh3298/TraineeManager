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
import com.javatech.model.KhoaHocModel;
import com.javatech.service.IKhoaHocService;
import com.javatech.utils.ConvertUtil;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = {"/api/khoa-hoc"})
public class KhoaHocAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null) {
			if(action.equals(ActionConstant.EDIT)) {
				postEdit(req, res);
			}
		}
	}
	
	@Inject
	IKhoaHocService khoaHocService;
	
	private void postEdit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CommonDTO model = ConvertUtil.toModelOfAPI(CommonDTO.class, req);
		KhoaHocModel khoacHocModel = khoaHocService.findOne(model.getId());
		DispatcherUtil.send(res, khoacHocModel);
	}

}
