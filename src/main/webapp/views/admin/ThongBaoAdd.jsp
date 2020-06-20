<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
	<!-- <form id="form-profile" action="/admin/thong-bao-deadline?action=create_thong_bao" method="POST">  -->
		<div class="form-group row">
			<label for="loaiThongBao" class="col-sm-2 col-form-label">Loại thông báo:</label>
			<div class="col-sm-10">
				<select name="loaiThongBao" id="loaiThongBao"class="select-filter" style="width: 300px;">
					<option value="thongbaokhac">Thông báo khác</option>
					<option value="thongbaonghi">Thông báo nghỉ</option>
				</select>
			</div>
		</div>
		<div class="form-group row">
			<label  class="col-sm-2 col-form-label">Lớp nhận thông báo:</label>
			<div class="col-sm-10">
				<select name="ClassesNameAddThongBao" id="ClassesNameAddThongBao"class="select-filter "  style="width: 300px;">
					<option value="Tất cả">Tất cả</option>
					<c:forEach var="classes" items="${dsClasses}">
						<option value="${classes.name }">${classes.name }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group row div-date-thongbaonghi" style="display : compact;" id = "div-NgayNghiDau" hidden="true">
			<label for="loaiThongBao" class="col-sm-2 col-form-label">Nghỉ ngày:</label>
			<div class="col-sm-10">
				<input class="btnDate btn-info btn" type="date" id="NgayNghiDau" name="hanDeadline" onchange="NgayNghi('NgayNghiDau')" required style="background-color: white; color: black;  width: 300px;">
			</div>
		</div>
		<div class="form-group row div-date-thongbaonghi" style="display : compact;" id = "div-NgayNghiCuoi" hidden="true">
			<label for="loaiThongBao" class="col-sm-2 col-form-label">Tới ngày:</label>
			<div class="col-sm-10">
				<input   class="btnDate btn-info btn" type="date" id="NgayNghiCuoi" name="hanDeadline" onchange="NgayNghi('NgayNghiCuoi')" required style="background-color: white; color: black;  width: 300px;">
			</div>
		</div>
		<div class="form-group row">
			<label for="title" class="col-sm-2 col-form-label">Tiêu
				đề:</label>
			<div class="col-sm-10">
				<textarea name="title" id="title"class="form-control" rows="1"
					style="width: 100%; color: black;"></textarea>
			</div>
		</div>
		<div class="form-group row">
			<label for="editorContentThongBao" class="col-sm-2 col-form-label">Nội
				dung:</label>
			<div class="col-sm-10">
				<textarea id="editorContentThongBao" name="editorContentThongBao" cols="500" rows="10" style="width: 100%;">
				</textarea>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-2"></div>
			<div class="col-sm-10">
				<button id="btn-save-add-Thong-Bao" type="submit" class="btn btn-primary mb-2">Lưu</button>
				<button onclick="goBack()" class="btn btn-primary mb-2" type="button" >Thoát</button>
			</div>
		</div>
		
		
		
		<script src="<c:url value='/js/admin/ThongBaoAdd.js' />"></script>
</body>
</html>