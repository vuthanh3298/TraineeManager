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
		<input type="hidden" id="deadline-id" style=""
				value="${deadline.id}"/>
		<div class="form-group row">
			<label for="loaiThongBao" class="col-sm-2 col-form-label">Loại Deadline:</label>
			<div class="col-sm-10">
				<select name="loaiDeadline" id="loaiDeadline" class="btnSort btn-info btn"
					style="background-color: white; color: black; width: 100%" disabled="disabled">
					<c:choose>
					  <c:when test="${deadline.getIsRegister()}">
					    <option value="thongbaokhac">Khác</option>
						<option value="dangkylichtraining" selected>Đăng ký lịch học</option>
					  </c:when>
					  <c:otherwise>
					   <option value="thongbaokhac" selected>Khác</option>
						<option value="dangkylichtraining" >Đăng ký lịch học</option>
					  </c:otherwise>
					</c:choose>
					
				</select>
			</div>
		</div>
		<!--  -->
		<div class="form-group row" id="div-han-deadline" style="display : compact;">
			<label for="loaiThongBao" class="col-sm-2 col-form-label">Thời hạn Deadline:</label>
			<div class="col-sm-10">
				<input   class="btnDate btn-info btn" type="date" id="due_dateDeadline" name="hanDeadline" style="background-color: white; color: black;  width: 300px;"
				value='<fmt:formatDate value="${deadline.dueDate}" pattern="yyyy-MM-dd"/>' >
			</div>
		</div>
		  <c:if test="${deadline.getIsRegister()}">
		    <div class="form-group row" id="div-week-deadline" >
				<label for="loaiThongBao" class="col-sm-2 col-form-label">Đăng ký cho tuần:</label>
				<div class="col-sm-10">
					<input  class="btnWeek btn-info btn" type="week" id="due_weekEditDeadline" name="hanDeadline" style="background-color: white;color: black; width: 300px; "
					value="${deadline.weekInYear}" >
				</div>
			</div>
		  </c:if>
		
		
		<div class="form-group row">
			<label  class="col-sm-2 col-form-label">Lớp nhận deadline:</label>
			<div class="col-sm-10">
				<select name="EditDeadlineClasses" id="EditDeadlineClasses"class="select-filter "  style="width: 300px;">
					<option value="Tất cả">Tất cả</option>
					<c:forEach var="classes" items="${dsClasses}">
						<option value="${classes.name }">${classes.name }</option>
					</c:forEach>
				</select>
			</div>
		</div>
	<div class="form-group row">
		<label for="newpassword" class="col-sm-2 col-form-label">Tiêu
			đề:</label>
		<div class="col-sm-10">
			<textarea name="title" id="title" class="form-control" rows="1"
				style="width: 100%; color: black;">${deadline.title}</textarea>
		</div>
	</div>
	<div class="form-group row">
		<label for="newpassword" class="col-sm-2 col-form-label">Nội
			dung:</label>
		<div class="col-sm-10">
			<textarea id="editorContentThongBao" name="editorContentThongBao"
				cols="80" rows="5" style="width: 100%;">
				${deadline.content}
				</textarea>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-2"></div>
		<div class="col-sm-10" >
			<button id="btn-save-edit-deadline" type="button"
				class="btn btn-primary mb-2" style=" margin-right: 5px;">Lưu</button>
			<button onclick="goBack()" class="btn btn-primary mb-2" type="button" >Thoát</button>
		</div>
	</div>
	<script src="<c:url value='/js/admin/DeadlineEdit.js' />"></script>
</body>
</html>