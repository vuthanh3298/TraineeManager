<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- https://bootsnipp.com/snippets/2P90 -->



<div class="container">
	<div style="margin-bottom: 5px;">
		<input type="checkbox" style="margin-left: 10px;" name="checkedAll"
			id="checkedAll" /> <select name="loaiThongBao"
			class="btnSort btn-info btn"
			style="background-color: white; color: black; margin-left: 30px;">
			<option value="dangkylichtraining" disabled selected hidden>_(danh
				sách)lớp_</option>
			<c:forEach var="mClass" items="${dsClass}">
				<option value=${mClass.id }>${mClass.name}</option>
			</c:forEach>
		</select>
		<div style="float: right;">
			<button id="btnDuyetTaiKhoanDuocChon" type="button"
				class="btn btn-outline-danger" style="color: black;">Duyệt</button>
			<button id="btnXoaTaiKhoanDuocChon" type="button"
				class="btn btn-outline-danger" style="color: black;">Xóa</button>
		</div>

	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive">
				<table id="mytable" class="table table-bordred table-striped">
					<tbody>
						<c:forEach var="thanhVien" items="${dsThanhVien}">
							<tr>
								<td><input type="checkbox" class="checkSingle"
									name="checkSingle" value="${thanhVien.id}" /></td>
								<td>
									<div class="d-flex w-100 justify-content-between">
										<h5 class="mb-1 a-list-users">${thanhVien.username}</h5>
										<small class="text-muted"> <select name="loaiThongBao"
											class="select-filter">
												<option value="dangkylichtraining" disabled selected hidden>_(danh
													sách)lớp_</option>
												<c:forEach var="mClass" items="${dsClass}">
													<option value=${mClass.id }>${mClass.name}</option>
												</c:forEach>
										</select>
										</small>
									</div> <small class="text-muted">SĐT:
										${thanhVien.phoneNumber} - Email: ${thanhVien.email} - SN: <fmt:formatDate
											pattern="dd-MM-yyyy" value="${thanhVien.dob}" /> - Địa chỉ:
										${thanhVien.address}.
								</small>
									<div style="float: right;">
										<%-- <button type="button"
											class="btnDuyetTaiKhoan btn btn-outline-danger "
											style="color: black;" user-id="${thanhVien.id}">Duyệt</button> --%>
										<a class="btnDuyetTaiKhoan" href=""
											style="color: blue; margin-right: 30px;"
											user-id="${thanhVien.id}">Duyệt</a> <a><i
											class="delete-duyet" data-toggle="modal"
											data-target="#DeleteUserModalCenter"
											user-id="${thanhVien.id}" user-name="${thanhVien.username}"
											user-mail="${thanhVien.email}"></i></a>

									</div>

								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<!-- start Modal delete user -->
<div class="modal fade" id="DeleteUserModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="EditUserModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">XÓA YÊU CẦU</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<!--  -->
			<form id="delete-form"
				action="/TraineeManager/admin/thanh-vien?action=delete_user_pending"
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

<script>
	var global_class_id;
	$('.delete-duyet').click(function() {
		const id = $(this).attr('user-id');
		name = "Tên: " + $(this).attr('user-name');
		email = "Email: " + $(this).attr('user-mail');
		$("input:text").val(id);
		$("#name-del").text(name);
		$("#email-del").text(email);
	});
	$('.select-filter').change(function() {
		global_class_id = $(this).children("option:selected").val();
	});
	$('.btnDuyetTaiKhoan')
			.click(
					function() {
						user_id = $(this).attr('user-id');
						var path = "/TraineeManager/admin/thanh-vien?action=duyet_user&class="
								+ global_class_id + "&userid=" + user_id;
						alert(path);
						window.location.replace(path);
					});
</script>
