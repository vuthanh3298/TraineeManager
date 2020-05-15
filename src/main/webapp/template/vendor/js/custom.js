$(document).ready(function(){
	
	$(".btnEditTaiKhoan").click(function(){
		$(this).closest("li").find("a").click();
	});
	
	$(".btnDeleteTaiKhoan").click(function(){
		var idUser = $(this).attr("data");
		var This = $(this);
		$.ajax({
			url: "/jwat/api/user/delete",
			type: "POST",
			data: {
				id: idUser
			},
			success: function(result) {
				if(result == "true"){
					This.closest("li").remove();
				}
			}
		})
	});
	
	$(".btnDuyetTaiKhoan").click(function(){
		var idUser = $(this).attr("data");
		var This = $(this);
		$.ajax({
			url: "/jwat/api/user/duyet",
			type: "POST",
			data: {
				id: idUser
			},
			success: function(result) {
				if(result == "true"){
					This.closest("li").remove();
				}
			}
		});
	});
	
	$(".txtUser").click(function(){
		var username = $(this).attr("username");
		var email = $(this).attr("email");
		var password = $(this).attr("password");
		var university = $(this).attr("university");
		var dob = $(this).attr("dob");
		console.log(dob);
		var avatar = $(this).attr("avatar");
		$("#modal-info-user-name").val(username);
		$("#modal-info-user-email").val(email);
		//$("#modal-info-user-password").val(password);
		$("#modal-info-user-university").val(university);
		$("#modal-info-user-dob").val(dob);
		//$("#modal-info-user-avatar").val(avatar);
	});
	
	$(".btnSuaThongBao").click(function(){
		var idThongBao =$(this).attr("idThongBao");
		
		console.log(idThongBao);
		var loai = $(this).attr("loai");
		var tieuDe = $(this).attr("tieuDe");
		var content = $(this).attr("content");
		var deadline = $(this).attr("deadline");
		var note = $(this).attr("note");
		
		$("#idThongBao").val(idThongBao);
		$("#loaiThongBao").val(loai);
		$("#tenThongBao").val(tieuDe);
		$("#noiDungThongBao").val(content);
		$("#thoiHanThongBao").val(deadline);
		$("#luuYThongBao").val(note);
		
	});
	
	$(".btnXoaThongBao").click(function(){
		var idThongBao = $(this).attr("idThongBao");
		var This = $(this);
		$.ajax({
			url: "/jwat/api/admin/xoaThongBao",
			type: "POST",
			data: {
				id: idThongBao
			},
			success: function(result) {
				if(result == "true"){
					This.closest("li").remove();
				}
			}
		});
	});
	
//	$("#radDangKy").change(function(){
//		if(this.checked){
//			$(".thoiGianDangKy").show();
//			$("#tieuDeThongBao").val("Các bạn đăng ký lịch training trên công ty");
//		} 
//	});
//	$("#radKhac").change(function(){
//		if(this.checked){
//			$(".thoiGianDangKy").hide();
//			$("#tieuDeThongBao").val("");
//		} 
//	});
	
	
	$(".thSoanLich").click(function(){
		var buoi = $(this).attr("buoi");
		var tuan = $("#idinputWeek").val();
		
		$("#idTuan").val(tuan);
		$("#idBuoi").val(buoi);
	});
});