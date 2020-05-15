<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Khoá học</title>
</head>
<body>
	<div style="margin-bottom: 10px;">
		<button type="button" class="btn btn-outline-danger"
			data-toggle="modal" data-target="#AddUserModalCenter">Thêm Khoá học</button>
	</div>
	<div class="list-group">
		<c:choose>
	         <c:when test = "${not empty courses}">
	         	<c:forEach var="course" items="${courses}" >
					<a href="#" class="list-group-item list-group-item-action flex-column align-items-start ">
						<i class="edit btn-edit-courses" data-toggle="modal" data-target="#courses-edit" id-course="${course.id}"></i> 
						<i class="delete"></i>
						<div class="d-flex w-100 justify-content-between">
							<h5 class="mb-1 a-list-users">${course.getName()}</h5>
						</div> 
						<small class="text-muted">
							${course.description}
						</small> 
					</a> 
				</c:forEach>
	         </c:when>
	         <c:otherwise>
	            Không có khoá học nào
	         </c:otherwise>
	      </c:choose>
	</div>
	
	
<!-- start Modal edit user -->
<div class="modal fade" id="courses-edit" tabindex="-1"
	role="dialog" aria-labelledby="EditUserModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">THÔNG TIN KHOÁ HỌC</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form action="/jwat/updateUser" method="post">
				<div class="modal-body div-dangki">
					<div class="form-group row">
			            <label for="courses-name" class="col-sm-3 col-form-label">Tên khoá học:</label>
			            <div class="col-sm-9">
			                <input type="text" class="form-control" id="courses-name" name="name">
			            </div>
			        </div>
			        <div class="form-group row">
			            <label for="courses-start-time" class="col-sm-3 col-form-label">Bắt đầu:</label>
			            <div class="col-sm-9">
			                <input type="text" class="form-control" id="courses-start-time" name="startTime">
			            </div>
			        </div>
			        <div class="form-group row">
			            <label for="courses-end-time" class="col-sm-3 col-form-label">Kết thúc:</label>
			            <div class="col-sm-9">
			                <input type="text" class="form-control" id="courses-end-time" name="endTime">
			            </div>
			        </div>
			        <div class="form-group row">
			            <label for="courses-description" class="col-sm-3 col-form-label">Mô tả:</label>
			            <div class="col-sm-9">
			                <input type="text" class="form-control" id="courses-description" name="description">
			            </div>
			        </div>
			        <div class="form-group row">
			            <label for="courses-note" class="col-sm-3 col-form-label">Ghi chú:</label>
			            <div class="col-sm-9">
			                <input type="password" class="form-control" id="courses-note" name="note">
			            </div>
			        </div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Đóng</button>
					<button type="submit" class="btn btn-primary">Lưu</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- end Modal edit user -->
	
</body>
</html>