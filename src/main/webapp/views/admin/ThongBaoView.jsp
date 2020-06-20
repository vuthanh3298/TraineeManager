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

	<div class="d-flex w-100 justify-content-between">
		<h1
			style="color: #B94A48; font-size: 18px; font-weight: normal; margin: 0;">
			${thongBao.title}</h1>
		<small class="text-muted">14 view<!-- Jwat 01 bỏ tên lớp vào đây bấm vào hiển thị danh sách người xem --></small>
	</div>
	<small class="text-muted">${thongBao.createdDate} </small>
	<div style="margin-top: 30px; color: black;">${thongBao.content}</div>
	<button onclick="goBack()" class="btn btn-primary mb-2" type="button"  style="float: right;">Thoát</button>
</body>
</html>