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
		<select name="loaiThongBao" class="select-filter">
			<option value="" disabled selected hidden>Lọc theo lớp</option>
			<option value=-1>Tất cả</option>
			<c:forEach var="mClass" items="${dsClass}">
				<option value=${mClass.id }>${mClass.name}</option>
			</c:forEach>

		</select>
	</div>

	<div class="list-group">
		<c:forEach var="thanhVien" items="${dsThanhVien}">
			<a
				class="list-group-item list-group-item-action flex-column align-items-start ">
				<div class="d-flex w-100 justify-content-between">
					<h5 class="mb-1 a-list-users">${thanhVien.username}</h5>
					<small class="text-muted"></small>
				</div> <small class="text-muted">SĐT: ${thanhVien.phoneNumber} -
					Email: ${thanhVien.email} - SN: <fmt:formatDate
						pattern="dd-MM-yyyy" value="${thanhVien.dob}" /> - Địa chỉ:
					${thanhVien.address}.
			</small> <i class="edit btnSuaTaiKhoan" data-toggle="modal"
				data-target="#EditUserModalCenter" user-id="${thanhVien.id}"
				user-name="${thanhVien.username}" user-mail="${thanhVien.email}"
				user-phone="${thanhVien.phoneNumber}"
				user-add="${thanhVien.address}" user-dob="${thanhVien.dob}"
				user-uni="${thanhVien.university}"></i> <i
				class="delete btnDeleteTaiKhoan" data-toggle="modal"
				data-target="#DeleteUserModalCenter" user-id="${thanhVien.id}"
				user-name="${thanhVien.username}" user-mail="${thanhVien.email}"></i>
			</a>
		</c:forEach>
	</div>
</div>

<!-- end list users -->
<!-- start Modal edit user -->
<div class="modal fade" id="EditUserModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="EditUserModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">THÔNG TIN
					TÀI KHOẢN</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<!--  -->
			<form id="form-profile"
				action="/admin/thanh-vien?action=edit_user"
				method="POST">
				<input id="user-id" name="id" type="text" hidden="true" />
				<div class="form-group row"
					style="margin-top: 5px; margin-left: 5px;">
					<label for="email" class="col-sm-3 col-form-label">Email</label>
					<div class="col-sm-9">
						<input type="text" readonly class="form-control ModalSizeInput"
							id="email" name="email">
					</div>
				</div>
				<div class="form-group row" style="margin-left: 5px;">
					<label for="username" class="col-sm-3 col-form-label">Tên:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control ModalSizeInput"
							id="username" placeholder="Tên" name="username">
					</div>
				</div>

				<div class="form-group row" style="margin-left: 5px;">
					<label for="phone" class="col-sm-3 col-form-label">Điện
						thoại:</label>
					<div class="col-sm-9">
						<input type="number" class="form-control ModalSizeInput"
							id="phone" placeholder="Điện thoại" name="phoneNumber">
					</div>
				</div>
				<div class="form-group row" style="margin-left: 5px;">
					<label for="address" class="col-sm-3 col-form-label">Địa
						chỉ:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control ModalSizeInput"
							id="address" placeholder="Địa chỉ" name="address">
					</div>
				</div>
				<div class="form-group row" style="margin-left: 5px;">
					<label for="dob" class="col-sm-3 col-form-label"> Ngày
						sinh:</label>
					<div class="col-sm-9">
						<input type="date" class="form-control ModalSizeInput" id="dob"
							name="dob"
							value='<fmt:formatDate value="${USERMODEL.dob}" pattern="yyyy-MM-dd"/>'>
					</div>
				</div>
				<div class="form-group row" style="margin-left: 5px;">
					<label for="university" class="col-sm-3 col-form-label">Trường
						học:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control ModalSizeInput"
							id="university" placeholder="Trường học" name="university">
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
<!-- end Modal edit user -->

<!-- start Modal delete user -->
<div class="modal fade" id="DeleteUserModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="EditUserModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">XÓA THÀNH
					VIÊN</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<!--  -->
			<form id="delete-form"
				action="/admin/thanh-vien?action=delete_user"
				method="POST">
				<input id="user-id" name="id" type="text" hidden="true" />
				<h3 id="name-del"></h3>
				<h5 id="email-del"></h5>
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
<!-- end Modal delete user -->


<!-- start Modal add user -->
<div class="modal fade" id="AddUserModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="AddUserModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title ModalTitle" id="exampleModalLongTitle">THÊM
					TÀI KHOẢN</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<%-- <c:if test="${not empty message}">
				<div class="alert alert-${alert}">${message}</div>
			</c:if> --%>

			<form id="form-profile"
				action="/admin/thanh-vien?action=create_user"
				method="POST">
				<div class="form-group row"
					style="margin-left: 5px; margin-top: 5px;">
					<label for="username" class="col-sm-3 col-form-label">Tên:</label>
					<div class="col-sm-9">
						<input type="text"
							class="form-control form-control-user ModalSizeInput"
							id="username" placeholder="Full Name" name="username">
					</div>
				</div>
				<div class="form-group row"
					style="margin-top: 5px; margin-left: 5px;">
					<label for="email" class="col-sm-3 col-form-label">Email</label>
					<div class="col-sm-9">
						<div class="span-email-exist" style="margin-left: 15px;"
							hidden="true">
							<span style="color: red;">Email đã tồn tại</span>
						</div>
						<input type="email"
							class="input-register-email form-control form-control-user ModalSizeInput"
							placeholder="Email Address" name="email">
					</div>
				</div>

				<div class="form-group row" style="margin-left: 5px;">
					<label for="phone" class="col-sm-3 col-form-label">Mật
						khẩu:</label>
					<div class="col-sm-9">
						<input type="password"
							class="form-control form-control-user ModalSizeInput"
							id="password" placeholder="Password" name="password">
					</div>
				</div>
				<div class="form-group row" style="margin-left: 5px;">
					<label for="phone" class="col-sm-3 col-form-label">Nhập
						lại:</label>
					<div class="col-sm-9">
						<input type="password"
							class="form-control form-control-user ModalSizeInput"
							id="repeat-passsword" placeholder="Repeat Password">
					</div>
				</div>
				<div class="form-group row" style="margin-left: 5px;">
					<label for="address" class="col-sm-3 col-form-label">Địa
						chỉ:</label>
					<div class="col-sm-9">
						<input type="text"
							class="form-control form-control-user ModalSizeInput"
							id="address" placeholder="Address" name="address">
					</div>
				</div>
				<div class="form-group row" style="margin-left: 5px;">
					<label for="university" class="col-sm-3 col-form-label">Trường
						học:</label>
					<div class="col-sm-9">
						<input type="text"
							class="form-control form-control-user ModalSizeInput"
							id="university" placeholder="University" name="university">
					</div>
				</div>

				<div class="form-group row" style="margin-left: 5px;">
					<label for="phone" class="col-sm-3 col-form-label">Điện
						thoại:</label>
					<div class="col-sm-9">
						<input type="text"
							class="form-control form-control-user ModalSizeInput" id="phone"
							placeholder="Phone" name="phoneNumber">
					</div>
				</div>

				<div class="form-group row" style="margin-left: 5px;">
					<label for="dob" class="col-sm-3 col-form-label"> Ngày
						sinh:</label>
					<div class="col-sm-9">
						<input type="date"
							class="form-control form-control-user ModalSizeInput" id="dob"
							name="dob" title="Date of birth">
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Đóng</button>
					<button type="submit" class="btn btn-primary btn-create">OK</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- end Modal add user -->
<script>
	$('.btnDeleteTaiKhoan').click(function() {
		const id = $(this).attr('user-id');
		name = "Tên: " + $(this).attr('user-name');
		email = "Email: " + $(this).attr('user-mail');
		$("input:text").val(id);
		$("#name-del").text(name);
		$("#email-del").text(email);
	});

	$('.btnSuaTaiKhoan').click(function() {
		id = $(this).attr('user-id');
		name = $(this).attr('user-name');
		email = $(this).attr('user-mail');
		phone = $(this).attr('user-phone');
		add = $(this).attr('user-add');
		dob = $(this).attr('user-dob');
		uni = $(this).attr('user-uni');
		$("input:text").val(id);
		$("#email").val(email);
		$("#username").val(name);
		$("#phone").val(phone);
		$("#address").val(add);
		$("#dob").val(dob);
		$("#university").val(uni);
	});
	$('.select-filter')
			.change(
					function() {
						var id = $(this).children("option:selected").val();
						//alert(id);
						var path = "/admin/thanh-vien?action=thanhvien&class="
								+ id;
						window.location.replace(path);
						$("#classUser").val("ahihi")
					});
</script>
<!--  -->