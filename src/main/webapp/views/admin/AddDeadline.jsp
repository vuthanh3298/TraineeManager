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
			<label for="loaiThongBao" class="col-sm-2 col-form-label">Lớp:</label>
			<div class="col-sm-10">
				<select name="loaiThongBao" class="btnSort btn-info btn"
					style="background-color: white; color: black; width: 100%">
					<option value="dangkylichtraining">_(danh sách)lớp_</option>
					<option value="thongbaonghi">Jwat 01</option>
					<option value="thongbaonghi">Jwat 02</option>
					<option value="thongbaonghi">Jwat 03</option>
					<option value="thongbaonghi">Jwat 04</option>
				</select>
			</div>
		</div>
		<div class="form-group row">
			<label for="title" class="col-sm-2 col-form-label">Tiêu
				đề:</label>
			<div class="col-sm-10">
				<textarea name="title" id="title"class="form-control" rows="1"
					style="width: 100%;"></textarea>
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
				<button id="btn-save-add-Deadline" type="submit"
					class="btn btn-primary mb-2">Lưu</button>
			</div>
		</div>
	<!--  </form> -->
<!-- 

	(3): Code Javascript thay thế textarea có id='editor1' bởi CKEditor
	<script>
		CKEDITOR.replace('editorContentThongBao');
	</script> -->
</body>
</html>