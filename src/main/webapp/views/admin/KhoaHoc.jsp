<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Khoá học</title>
</head>
<body>
	<c:if test="${not empty message}">
        <div class="alert alert-${alert} alert-dismissible">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
            ${message}
        </div>
    </c:if>
	<div style="margin-bottom: 10px;">
		<button id="btn-course-create" type="button" class="btn btn-outline-danger"
			data-toggle="modal" data-target="#courses-info">Thêm Khoá học</button>
	</div>
	<div class="list-group">
		<c:choose>
	         <c:when test = "${not empty courses}">
	         	<c:forEach var="course" items="${courses}" >
		         	<div class="list-group-item list-group-item-action flex-column align-items-start">
		         		<a href="<c:url value='/admin/khoa-hoc?action=chi_tiet_khoa_hoc&id=${course.id}'/>" >
							<div class="d-flex w-100 justify-content-between">
								<h5 class="mb-1 a-list-users">${course.getName()}</h5>
							</div> 
							<small class="text-muted">
								${course.description}
							</small> 
						</a> 
						<i class="edit btn-edit-courses" data-toggle="modal" data-target="#courses-info" id-course="${course.id}"></i> 
						<i class="delete btn-delete-courses" id-course="${course.id}"></i>
		         	</div>
					
				</c:forEach>
	         </c:when>
	         <c:otherwise>
	            Không có khoá học nào
	         </c:otherwise>
	      </c:choose>
	</div>
	
<!-- start Modal edit user -->
<div class="modal fade" id="courses-info" tabindex="-1"
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
			
			<form id="course-modal" action="/admin/khoa-hoc?action=create_khoa_hoc" method="post">
				<input id="course-id" name="id" hidden="true">
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
			                <input type="date" class="form-control" id="courses-start-time" name="startTime">
			            </div>
			        </div>
			        <div class="form-group row">
			            <label for="courses-end-time" class="col-sm-3 col-form-label">Kết thúc:</label>
			            <div class="col-sm-9">
			                <input type="date" class="form-control" id="courses-end-time" name="endTime">
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
			                <input type="text" class="form-control" id="courses-note" name="note">
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