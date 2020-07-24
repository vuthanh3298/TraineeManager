<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="container-fluid">
	<c:if test="${not empty message}">
		<div class="alert alert-${alert} alert-dismissible">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			${message}
		</div>
	</c:if>

	<div class="input-group md-form form-sm form-2 pl-0 ">
		<button type="button" class="btn btn-outline-danger"
			data-toggle="modal" data-target="#AddUserModalCenter">Thêm</button>

	</div>
	<!-- start list users -->
	<div class="div-select-filter">
		<select name="loaiThongBao" class="course-filter">
			<option value="" disabled selected hidden>Lọc theo khóa</option>
			<option value=-1>Tất cả</option>
			<c:forEach var="mCourse" items="${dsCourse}">
				<option value=${mCourse.id }>${mCourse.name}</option>
			</c:forEach>

		</select>
	</div>

	<div class="list-group">
		<c:forEach var="mClass" items="${dsClass}">
			<a
				class="list-group-item list-group-item-action flex-column align-items-start ">
				<div class="d-flex w-100 justify-content-between">
					<h5 class="mb-1 a-list-users">${mClass.name}</h5>
					<small class="text-muted"></small>
				</div> <small class="text-muted">Hoàn tất: ${mClass.isDone} </small> <i
				class="edit btnSuaTaiKhoan" data-toggle="modal"
				data-target="#EditUserModalCenter" class-id="${mClass.id}"
				class-name="${mClass.name}" user-mail="${thanhVien.email}"
				class-status="${mClass.isDone}"></i> <i
				class="delete btnDeleteTaiKhoan" data-toggle="modal"
				data-target="#DeleteUserModalCenter" class-id="${mClass.id}"
				class-name="${mClass.name}" class-status="${mClass.isDone}"></i>
			</a>
		</c:forEach>
	</div>
</div>

<!-- end list users -->
<!-- start Modal edit class -->
<div class="modal fade" id="EditUserModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="EditUserModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">THÔNG TIN
					LỚP HỌC</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<!--  -->
			<form id="form-profile"
				action="/admin/danh-sach-lop?action=edit_class"
				method="POST">
				<input id="user-id" name="id" type="text" hidden="true" />
				<div class="form-group row" style="margin-left: 5px;">
					<label for="username" class="col-sm-3 col-form-label">Tên:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control ModalSizeInput"
							id="className" placeholder="Tên" name="name">
					</div>
				</div>

				<div class="form-group row" style="margin-left: 5px;">
					<label for="phone" class="col-sm-3 col-form-label">Trạng
						thái:</label>
					<div class="col-sm-9">
						<input type="number" class="form-control ModalSizeInput"
							id="isDone" placeholder="Hoàn tất?" name="isDone">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Đóng</button>
					<!-- <button id="btn-edit-change" type="button" class="btn btn-primary">Lưu</button> -->
					<button type="submit" class="btn btn-primary">Lưu</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- end Modal edit class -->

<!-- start Modal delete class -->
<div class="modal fade" id="DeleteUserModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="EditUserModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">XÓA LỚP HỌC</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<!--  -->
			<form id="delete-form"
				action="/admin/danh-sach-lop?action=delete_class"
				method="POST">
				<input id="class-id" name="id" type="text" hidden="true" />
				<h3 id="name-del"></h3>
				<h5 id="status-del"></h5>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Hủy</button>
					<!-- <button id="btn-edit-change" type="button" class="btn btn-primary">Lưu</button> -->
					<button type="submit" class="btn btn-primary">Xóa</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- end Modal delete class -->

<script>
	$('.btnDeleteTaiKhoan').click(function() {
		id = $(this).attr('class-id');
		name = "Tên: " + $(this).attr('class-name');
		status = "Trạng thái: " + $(this).attr('class-status');
		$("input:text").val(id);
		$("#name-del").text(name);
		$("#status-del").text(status);
	});

	$('.btnSuaTaiKhoan').click(function() {
		id = $(this).attr('class-id');
		name = $(this).attr('class-name');
		status = $(this).attr('class-status');
		$("input:text").val(id);
		$("#className").val(name);
		$("#isDone").val(status);
	});
	$('.course-filter')
			.change(
					function() {
						var id = $(this).children("option:selected").val();
						//alert(id);
						var path = "/admin/danh-sach-lop?action=danhsachlop&course="
								+ id;
						window.location.replace(path);
					});
</script>
<!--  -->