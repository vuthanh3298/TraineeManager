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
	<input id="thong-bao-id" hidden="true" value="${thongBao.id}"/>
	<div class="form-group row">
		<label for="newpassword" class="col-sm-2 col-form-label">Lớp nhận thông báo:</label>
		<div class="col-sm-10">
			<select name="ClassesNameEditThongBao" id="ClassesNameEditThongBao"class="select-filter "  style="width: 300px;"  >
				<option value="Tất cả">Tất cả</option>
				<c:forEach var="classes" items="${dsClasses}">
					<c:choose>
						<c:when test="${thongBao.toClass == classes.name }">
							<option value="${classes.name }" selected>${classes.name }</option>
					  	</c:when>
					 	<c:otherwise>
					    	<option value="${classes.name }" >${classes.name }</option>
					  	</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</div>
	</div>
	<script type="text/javascript">
	//document.getElementById('ClassesNameEditThongBao').getElementsByTagName('option')[11].selected = 'selected'
		


		document.getElementById("ClassesNameEditThongBao").value = thongBao.toClass
	</script>
<!-- <select id="cars">
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="vw">VW</option>
  <option value="audi" selected>Audi</option>
</select> -->
	<div class="form-group row">
		<label for="newpassword" class="col-sm-2 col-form-label">Tiêu đề:</label>
		<div class="col-sm-10">
			<textarea name="title" id="title" class="form-control" rows="1"
				style="width: 100%;">${thongBao.title}</textarea>
		</div>
	</div>
	<div class="form-group row">
		<label for="newpassword" class="col-sm-2 col-form-label">Nội
			dung:</label>
		<div class="col-sm-10">
			<textarea id="editorContentThongBao" name="editorContentThongBao"
				cols="80" rows="5" style="width: 100%;">
				${thongBao.content}
				</textarea>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-2"></div>
		<div class="col-sm-10">
			<button id="btn-save-edit-Thong-Bao" type="button" class="btn btn-primary mb-2">Lưu</button>
			<button onclick="goBack()" class="btn btn-primary mb-2" type="button" >Thoát</button>
		</div>
	</div>
	<script src="<c:url value='/js/admin/ThongBaoEdit.js' />"></script>
</body>
</html>