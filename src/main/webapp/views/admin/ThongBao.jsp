<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div style="width: 100%;">
	<c:if test="${not empty message}">
		<div class="alert alert-${alert} alert-dismissible">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			${message}
		</div>
	</c:if>
	<div class="row">
		<div class="col-sm-6">
			<a class="btn btn-outline-danger"
				href='<c:url value="/admin/thong-bao-deadline?action=add_thong_bao"/>' style="margin-bottom: 5px;">Thêm</a>
		</div>


		<div class="col-sm-6">
			<div class="div-select-filter">
				<select name="ClassesNameThongBao" id="ClassesNameThongBao"
					class="select-filter"
					style="margin-bottom: 0px; float: right;"><!--  position: absolute; float: 0 -->
					<option value="Tất cả">Tất cả</option>
					<c:forEach var="classes" items="${dsClasses}">
						<c:choose>
							<c:when test="${clazz == classes.name }">
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
			<c:forEach var="thongBao" items="${dsThongBao}">
				<li
					class="list-group-item d-flex justify-content-between align-items-center">
					<div style="margin-right: 25px;">
						<a class="a-notification-admin"
							href="/admin/thong-bao-deadline?action=view_thong_bao&id=${thongBao.id}">
							${thongBao.title} </a> <span style="color: #2b2b2b; font-size: 13px;">
							${thongBao.createdDate} </span> <span
							style="color: #f00; font-size: 16px"> *new</span>

					</div> <a class="edit"
					href='<c:url value="/admin/thong-bao-deadline?action=edit_thong_bao&id=${thongBao.id}"/>'></a>
					<i class="delete btndeleteThongBao" id-Thong-Bao="${thongBao.id}"></i>
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
<script src="<c:url value='/js/admin/ThongBao.js' />"></script>
