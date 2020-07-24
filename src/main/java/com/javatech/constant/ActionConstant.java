package com.javatech.constant;

public interface  ActionConstant {
	public static final Object CHECK_SESSION = "check-session";
	public static final String LOGIN = "login";
	public static final String REGISTER = "register";
	public static final String LOGOUT = "logout";
	
	public static final String THANH_VIEN = "thanhvien";
	public static final String CHO_DUYET = "choduyet";
	
	public static final Object THONG_TIN_DANG_KY_LICH = "thongtindangkylich";
	public static final Object SOAN_THOI_KHOA_BIEU = "soanthoikhoabieu";
	public static final Object THONG_TIN_XIN_NGHI = "thongtinxinnghi";
	
	public static final Object DIEM_DANH = "diemdanh";
	public static final Object TIEN_DO = "tiendo";
	
	public static final Object DANH_SACH_LOP = "danhsachlop";
	public static final Object DELETE_LOP = "delete_class";
	public static final Object EDIT_LOP = "edit_class";
	public static final Object XEP_LOP = "xeplop";
	public static final Object CHECK_EMAIL_EXIST = "check_email_exist";
	
	public static final Object EDIT = "edit";
	
	public static final Object GET_USER = "get_user";
	public static final Object EDIT_USER = "edit_user";
	public static final Object DELETE_USER = "delete_user";
	public static final Object CREATE_USER = "create_user";
	public static final Object DUYET_USER = "duyet_user";
	public static final Object DUYET_USERS = "duyet_users";
	public static final Object DELETE_USERS_CHO_DUYET = "delete_users_cho_duyet";
	public static final Object DELETE_USER_CHO_DUYET = "delete_user_cho_duyet";
	
	public static final Object THONG_BAO_VA_DEADLINE = "thong_bao_va_deadline";
	public static final Object ADD_THONG_BAO = "add_thong_bao";
	public static final Object EDIT_THONG_BAO = "edit_thong_bao";
	public static final Object CREATE_THONG_BAO = "create_thong_bao";
	public static final Object GET_THONG_BAO = "get_thong_bao";
	public static final Object SAVE_EDIT_THONG_BAO = "save_edit_thong_bao";
	public static final Object DELETE_THONG_BAO = "delete_thong_bao";
	public static final Object VIEW_THONG_BAO = "view_thong_bao";
	
	public static final Object ADD_DEADLINE = "add_deadline";
	public static final Object EDIT_DEADLINE = "edit_deadline";
	public static final Object VIEW_DEADLINE = "view_deadline";
	public static final Object SAVE_EDIT_DEADLINE = "save_edit_deadline";
	public static final Object DELETE_DEADLINE = "delete_deadline";
	
	public static final Object DELETED = "deleted";
	public static final Object RE_ACTIVE = "re_active";
	public static final Object DELETE_USER_PENDING = "delete_user_pending";
	
	public static final Object SAVE_THONG_TIN_DANG_KY_LICH = "save_thong_tin_dang_ky_lich";
	public static final Object SAVE_THONG_TIN_DEADLINE = "save_thong_tin_deadline";
	
	public static interface KHOA_HOC {
		public static final String CHI_TIET_KHOA_HOC = "chi_tiet_khoa_hoc";
		public static final String CREATE = "create_khoa_hoc";
		public static final String UPDATE = "update_khoa_hoc";
	}
	
	public static interface CHI_TIET_KHOA_HOC {
		public static final String CREATE_GIAI_DOAN = "create_giai_doan";
		public static final String UPDATE = "update";
		public static final Object GET_STAGE_BY_COURSE = "get_stage_by_course";
		public static final Object CREATE_BAI_HOC = "create_bai_hoc";
		public static final Object CREATE_BUOI_HOC = "create_buoi_hoc";
		public static final Object UPDATE_GIAI_DOAN = "update_giai_doan";
		public static final Object UPDATE_BAI_HOC = "update_bai_hoc";
		public static final Object UPDATE_BUOI_HOC = "update_buoi_hoc";
	}
}

