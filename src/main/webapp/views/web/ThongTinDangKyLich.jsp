<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html>
<head>

</head>
<body>
	<!-- start add user -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-6">
				<div class="input-group md-form form-sm form-2 pl-0 "
					style="margin-bottom: 5px;">
					<div class="input-group-prepend">
						<span id="preWeek"
							class="btn input-group-text red lighten-3 backward span-ward"></span>
					</div>
					
					<input id="idInputWeek" type="week" name="idInputWeek"
						style="width: 200px; height: 30px; border: 1px solid #999;" <c:if test = "${not empty weekInYear}"> value="${weekInYear}" </c:if> />
					<div class="input-group-append ">
						<span id="nextWeek"
							class="btn input-group-text red lighten-3 forward span-ward"
							style="border-top-right-radius: 4px; border-bottom-right-radius: 4px;"></span>
					</div>
				</div>
			</div>
		</div>
		<table id="dtVerticalScrollExample"
			class="table table-striped table-bordered table-sm cellspacing=0 width=100%" 
			style="text-align: center; color: black; overflow-x: scroll;">
			<thead>
				<tr>
					<th scope="col" rowspan="2">Thời gian</th>
					<th scope="col" colspan="2">Thứ 2</th>
					<th scope="col" colspan="2">Thứ 3</th>
					<th scope="col" colspan="2">Thứ 4</th>
					<th scope="col" colspan="2">Thứ 5</th>
					<th scope="col" colspan="2">Thứ 6</th>
					<th scope="col" colspan="2">Thứ 7</th>
					<th scope="col" colspan="2">chủ nhật</th>
				</tr>
				<tr>
					<th scope="col">S</th>
					<th scope="col">C</th>
					<th scope="col">S</th>
					<th scope="col">C</th>
					<th scope="col">S</th>
					<th scope="col">C</th>
					<th scope="col">S</th>
					<th scope="col">C</th>
					<th scope="col">S</th>
					<th scope="col">C</th>
					<th scope="col">S</th>
					<th scope="col">C</th>
					<th scope="col">S</th>
					<th scope="col">C</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${dsDangKyLich}">
					<tr>
						<td>${i.className }</td>
						<td><c:if test='${i.schedule.contains("S2")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C2")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("S3")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C3")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("S4")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C4")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("S5")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C5")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("S6")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C6")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("S7")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C7")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("S8")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C8")}'>x</c:if></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<script src="<c:url value='/js/admin/ThongTinDangKyLich.js' />"></script>
</body>
</html>
