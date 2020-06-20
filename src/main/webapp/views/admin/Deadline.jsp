<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- start add notification and search -->
<div style="width: 100%;">
	<div class="row">
		<div class="col-sm-6">
			<a class="btn btn-outline-danger"
				href='<c:url value="/admin/thong-bao-deadline?action=add_deadline"/>'
				style="margin-bottom: 5px;">Thêm</a>
		</div>


		<div class="col-sm-6">
			<div class="div-select-filter">
				<select name="ClassesNameDeadline" id="ClassesNameDeadline"
					class="select-filter" style="margin-bottom: 0px; float: right;">
					<option value="Tất cả">Tất cả</option>
					<c:forEach var="classes" items="${dsClasses}">
						<c:choose>
							<c:when test="${classDeadline == classes.name }">
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
	</div>
	<div>
		<ul class="list-group ul-notification-admin">
			<c:forEach var="deadline" items="${dsDeadline}">
				<li
					class="list-group-item d-flex justify-content-between align-items-center">
					<div>
						<a class="a-notification-admin"
							href='<c:url value="/admin/thong-bao-deadline?action=view_deadline&id=${deadline.id}"/>'>
							${deadline.title}</a> <span style="color: #2b2b2b; font-size: 13px;">${deadline.createdDate}</span>
						<span style="color: #f00; font-size: 16px">*new</span>
					</div> <a class="edit"
					href='<c:url value="/admin/thong-bao-deadline?action=edit_deadline&id=${deadline.id}"/>'></a>
					<i class="delete btndeleteDeadline" id-Deadline="${deadline.id}"></i>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="row " style="padding-top: 10px">
		<nav aria-label="Page navigation example" style="margin-left: 40%;">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
	</div>
</div>
<script src="<c:url value='/js/admin/Deadline.js' />"></script>