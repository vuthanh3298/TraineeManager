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
		<div class="form-group row">
			<label for="loaiThongBao" class="col-sm-2 col-form-label">Loại Deadline:</label>
			<div class="col-sm-10">
				<select name="loaiDeadline" id="loaiDeadline" class="btnSort btn-info btn"
					style="background-color: white; color: black; width: 100%">
					<option value="thongbaokhac">Khác</option>
					<option value="dangkylichtraining">Đăng ký lịch học</option>
				</select>
			</div>
		</div>
		<div class="form-group row" id="div-han-deadline" style="display : compact;">
			<label for="loaiThongBao" class="col-sm-2 col-form-label">Thời hạn Deadline:</label>
			<div class="col-sm-10">
				<input   class="btnDate btn-info btn" type="date" id="due_dateDeadline" name="hanDeadline" style="background-color: white; color: black;  width: 300px;">
			</div>
		</div>
		<div class="form-group row" id="div-week-deadline" style="display : none">
			<label for="loaiThongBao" class="col-sm-2 col-form-label">Đăng ký cho tuần:</label>
			<div class="col-sm-10">
				<input  class="btnWeek btn-info btn" type="week" id="due_weekDeadline" name="hanDeadline" style="background-color: white;color: black; width: 300px; ">
			</div>
		</div>
		<div class="form-group row">
			<label  class="col-sm-2 col-form-label">Lớp nhận deadline:</label>
			<div class="col-sm-10">
				<select name="AddDeadlineClasses" id="AddDeadlineClasses"class="select-filter "  style="width: 300px;">
					<option value="Tất cả">Tất cả</option>
					<c:forEach var="classes" items="${dsClasses}">
						<option value="${classes.name }">${classes.name }</option>
					</c:forEach>
				</select>
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
				<button id="btn-save-add-Deadline" type="submit" class="btn btn-primary mb-2">Lưu</button>
				<button onclick="goBack()" class="btn btn-primary mb-2" type="button" >Thoát</button>
			</div>
		</div>
		<script src="<c:url value='/js/admin/DeadlineAdd.js' />"></script>
</body>
</html>