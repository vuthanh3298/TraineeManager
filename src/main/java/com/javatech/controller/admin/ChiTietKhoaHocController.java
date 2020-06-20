package com.javatech.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatech.constant.ActionConstant;
import com.javatech.entity.ChapterEntity;
import com.javatech.entity.LessonEntity;
import com.javatech.entity.StageEntity;
import com.javatech.service2.ChapterService;
import com.javatech.service2.LessonService;
import com.javatech.service2.StageService;
import com.javatech.utils.ConvertUtil;
import com.javatech.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/admin/chi-tiet-khoa-hoc" })
public class ChiTietKhoaHocController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	StageService stageService;
	@Inject
	ChapterService chapterService;
	@Inject
	LessonService lessonService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.CHI_TIET_KHOA_HOC.CREATE_GIAI_DOAN)) {
				createGiaiDoan(req, res);
			} else if (action.equals(ActionConstant.CHI_TIET_KHOA_HOC.CREATE_BAI_HOC)) {
				createBaiHoc(req, res);
			} else if (action.equals(ActionConstant.CHI_TIET_KHOA_HOC.CREATE_BUOI_HOC)) {
				createBuoiHoc(req, res);
			} else if (action.equals(ActionConstant.CHI_TIET_KHOA_HOC.UPDATE_GIAI_DOAN)) {
				updateGiaiDoan(req, res);
			} else if (action.equals(ActionConstant.CHI_TIET_KHOA_HOC.UPDATE_BAI_HOC)) {
				updateBaiHoc(req, res);
			} else if (action.equals(ActionConstant.CHI_TIET_KHOA_HOC.UPDATE_BUOI_HOC)) {
				updateBuoiHoc(req, res);
			} 
		}
	}

	private void updateBuoiHoc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String courseId = req.getParameter("courseId");
		LessonEntity lessonEntity = ConvertUtil.toModelOfController(LessonEntity.class, req);
		Integer result = lessonService.updateOne(lessonEntity);
		if (result > 0) {
			DispatcherUtil.redirect(req, res, "/admin/khoa-hoc?action=chi_tiet_khoa_hoc&id=" + courseId);
		}
	}

	private void updateBaiHoc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String courseId = req.getParameter("courseId");
		ChapterEntity chapterEntity = ConvertUtil.toModelOfController(ChapterEntity.class, req);
		Integer result = chapterService.updateOne(chapterEntity);
		if (result > 0) {
			DispatcherUtil.redirect(req, res, "/admin/khoa-hoc?action=chi_tiet_khoa_hoc&id=" + courseId);
		}
	}

	private void updateGiaiDoan(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StageEntity stageEntity = ConvertUtil.toModelOfController(StageEntity.class, req);
		Integer result = stageService.updateOne(stageEntity);
		if (result > 0) {
			DispatcherUtil.redirect(req, res,
					"/admin/khoa-hoc?action=chi_tiet_khoa_hoc&id=" + stageEntity.getCoursesId());
		}
	}

	private void createBuoiHoc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String courseId = req.getParameter("courseId");
		LessonEntity lessonEntity = ConvertUtil.toModelOfController(LessonEntity.class, req);
		Integer result = lessonService.insertOne(lessonEntity);
		if (result > 0) {
			DispatcherUtil.redirect(req, res, "/admin/khoa-hoc?action=chi_tiet_khoa_hoc&id=" + courseId);
		}
	}

	private void createBaiHoc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String courseId = req.getParameter("courseId");
		ChapterEntity chapterEntity = ConvertUtil.toModelOfController(ChapterEntity.class, req);
		Integer result = chapterService.insertOne(chapterEntity);
		if (result > 0) {
			DispatcherUtil.redirect(req, res, "/admin/khoa-hoc?action=chi_tiet_khoa_hoc&id=" + courseId);
		}
	}

	private void createGiaiDoan(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StageEntity stageEntity = ConvertUtil.toModelOfController(StageEntity.class, req);
		Integer result = stageService.insertOne(stageEntity);
		if (result > 0) {
			DispatcherUtil.redirect(req, res,
					"/admin/khoa-hoc?action=chi_tiet_khoa_hoc&id=" + stageEntity.getCoursesId());
		}
	}
}
