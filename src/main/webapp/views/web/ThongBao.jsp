<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div style="width: 100%;">
	<div>
		<ul class="list-group ul-notification-admin">
			<c:forEach var="thongBao" items="${dsThongBao}">
				<li
					class="list-group-item d-flex justify-content-between align-items-center">
					<div style="margin-right: 25px;">
						<a class="a-notification-admin"

							href="/thong-bao-deadline?action=view_thong_bao&id=${thongBao.id}">
							${thongBao.title} </a> <span style="color: #2b2b2b; font-size: 13px;">
							${thongBao.createdDate} </span> <span
							style="color: #f00; font-size: 16px"> *new</span>
					</div>

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
