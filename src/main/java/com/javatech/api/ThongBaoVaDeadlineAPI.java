package com.javatech.api;

import java.io.IOException;

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
import com.javatech.utils.ConvertUtil;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/api/thong-bao-deadline" })
public class ThongBaoVaDeadlineAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.ADD_THONG_BAO)) {
				createThongBao(req, res);
			}else if(action.equals(ActionConstant.SAVE_EDIT_THONG_BAO)) {
				saveEditThongBao(req, res);
			}else if(action.equals(ActionConstant.DELETE_THONG_BAO)) {
				deleteThongBao(req, res);
			}else if (action.equals(ActionConstant.ADD_DEADLINE)) {
				createDeadline(req, res);
			}
		}

	}
	
	

	@Inject
	IThongBaoService thongBaoService;
	@Inject
	IDeadlineService deadlineService;

	private void createThongBao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ThongBaoModel thongBaoModel = ConvertUtil.toModelOfAPI(ThongBaoModel.class, req);
		if (thongBaoService.createThongBao(thongBaoModel) != null) {
			DispatcherUtil.send(res, true);
		}
	}
	private void saveEditThongBao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		ThongBaoModel model = ConvertUtil.toModelOfAPI(ThongBaoModel.class, req);
		/*
		 * Integer id=(Integer) SessionUtil.getInstance().getValue(req, "id");
		 * model.setModifiedBy(id);
		 */
		Integer editThongBao=thongBaoService.update(model);
		DispatcherUtil.send(res, editThongBao);
	}
	private void deleteThongBao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		ThongBaoModel model = ConvertUtil.toModelOfAPI(ThongBaoModel.class, req);
		Boolean delThongBao=thongBaoService.deleteThongBao(model.getId());
		DispatcherUtil.send(res, delThongBao);
	}
	private void createDeadline(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DeadlineModel deadlineModel = ConvertUtil.toModelOfAPI(DeadlineModel.class, req);
		if (deadlineService.createDeadline(deadlineModel) != null) {
			DispatcherUtil.send(res, true);
		}
	}

}
