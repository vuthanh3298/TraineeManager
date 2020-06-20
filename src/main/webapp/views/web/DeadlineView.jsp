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
	<input type="text" id="deadlineId" value="${deadline.id}" hidden ><!-- hidden -->
	<input type="text" id="weekInYear" value="${deadline.weekInYear}" hidden >
	<div class="d-flex w-100 justify-content-between">
		<h1
			style="color: #B94A48; font-size: 18px; font-weight: normal; margin: 0;">
			${deadline.title}</h1>
		<button onclick="goBack()" class="btn btn-primary mb-2" type="button" style="float: right;">Thoát</button>
	</div>
	<small class="text-muted">${deadline.createdDate} </small>
	<div style="margin-top: 30px; color: black;">${deadline.content}</div>
	<div style="margin-top: 30px; color: black;">Hạn chót:
		${deadline.dueDate}</div>
	<c:choose>
	  <c:when test="${deadline.isRegister}">
	    
	<div class="card shadow mb-4 " style="margin-top: 10px;">
		<div class="card-header py-3">
			<h2 class="m-0 font-weight-bold text-primary">Đăng ký:</h2>
		</div>
		<div class="card-body">
			<div>
				<script language="JavaScript">
					function toggle(source) {
					  checkboxes = document.getElementsByName('vehicle1');
					  for(var i=0, n=checkboxes.length;i<n;i++) {
					    checkboxes[i].checked = source.checked;
					  }
					}
					</script>
					<div style="float: right; ">
						<input type="checkbox"  onClick="toggle(this)" value=""/> Chọn tất cả <br/>
					</div>
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Buổi</th>
							<th>Thứ 2</th>
							<th>Thứ 3</th>
							<th>Thứ 4</th>
							<th>Thứ 5</th>
							<th>Thứ 6</th>
							<th>Thứ 7</th>
							<th>Chủ Nhật</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td>Sáng </td>
							<td><input type="checkbox" id="S2" name="vehicle1" value="S2"></td>
							<td><input type="checkbox" id="S3" name="vehicle1" value="S3"></td>
							<td><input type="checkbox" id="S4" name="vehicle1" value="S4"></td>
							<td><input type="checkbox" id="S5" name="vehicle1" value="S5"></td>
							<td><input type="checkbox" id="S6" name="vehicle1" value="S6"></td>
							<td><input type="checkbox" id="S7" name="vehicle1" value="S7"></td>
							<td><input type="checkbox" id="S8" name="vehicle1" value="S8"></td>
						</tr>

						<tr>
							<td>Chiều </td>
							<td><input type="checkbox" id="C2" name="vehicle1" value="C2"></td>
							<td><input type="checkbox" id="C3" name="vehicle1" value="C3"></td>
							<td><input type="checkbox" id="C4" name="vehicle1" value="C4"></td>
							<td><input type="checkbox" id="C5" name="vehicle1" value="C5"></td>
							<td><input type="checkbox" id="C6" name="vehicle1" value="C6"></td>
							<td><input type="checkbox" id="C7" name="vehicle1" value="C7"></td>
							<td><input type="checkbox" id="C8" name="vehicle1" value="C8"></td>
						</tr>
					</tbody>
				</table>
				<button id="btnLuuThongTinDangKyLich" class="btn btn-primary mb-2" type="button" style="float: right;">Lưu</button>
			</div>
		</div>
	</div>
	
	  </c:when>
	  <c:otherwise>
	    <div class="card shadow mb-4 " style="margin-top: 10px;">
		<div class="card-header py-3">
			<h2 class="m-0 font-weight-bold text-primary">Nộp link:</h2>
		</div>
		<div class="card-body">
			<div>
				Link bài làm:
				<input id="url_homework" type="text" style="width: 100%; margin-bottom: 10px;">
				<button id="btnLuuThongTinDeadline" class="btn btn-primary mb-2" type="button" style="float: right;">Lưu</button>
			</div>
		</div>
	</div>
	  </c:otherwise>
	</c:choose>
<script src="<c:url value='/js/web/DeadlineView.js' />"></script>



</body>
</html>