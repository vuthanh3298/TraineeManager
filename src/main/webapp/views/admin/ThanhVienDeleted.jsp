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
			<option value="dangkylichtraining">_(danh sách)lớp_</option>
			<option value="thongbaonghi">Jwat 01</option>
			<option value="thongbaonghi">Jwat 02</option>
			<option value="thongbaonghi">Jwat 03</option>
			<option value="thongbaonghi">Jwat 04</option>
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
												<option value="dangkylichtraining">_(danh sách)lớp_</option>
												<option value="thongbaonghi">Jwat 01</option>
												<option value="thongbaonghi">Jwat 02</option>
												<option value="thongbaonghi">Jwat 03</option>
												<option value="thongbaonghi">Jwat 04</option>
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
										<a class="btnReActiveTaiKhoan" href=""
											style="color: blue; margin-right: 30px;" data-toggle="modal"
											data-target="#ReActiveUserModalCenter"
											user-id="${thanhVien.id}" user-name="${thanhVien.username}"
											user-mail="${thanhVien.email}">Kích hoạt</a>

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
<div class="modal fade" id="ReActiveUserModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="EditUserModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Tái kích hoạt</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<!--  -->
			<form id="delete-form"
				action="/admin/thanh-vien?action=re_active"
				method="POST">
				<input id="user-id" name="id" type="text" hidden="true" />
				<h3 id="name-del"></h3>
				<h5 id="email-del"></h5>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Hủy</button>
					<!-- <button id="btn-edit-change" type="button" class="btn btn-primary">Lưu</button> -->
					<button type="submit" class="btn btn-primary">Kích hoạt</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- end Modal delete user -->

<script>
	$('.btnDuyetTaiKhoan').click(function() {
		const id = $(this).attr('user-id');
		document.getElementById("passId").submit();
	});
	$('.btnReActiveTaiKhoan').click(function() {
		const id = $(this).attr('user-id');
		name = "Tên: " + $(this).attr('user-name');
		email = "Email: " + $(this).attr('user-mail');
		$("input:text").val(id);
		$("#name-del").text(name);
		$("#email-del").text(email);
	});
</script>
