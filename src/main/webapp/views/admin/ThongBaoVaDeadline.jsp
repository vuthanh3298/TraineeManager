<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
	<section id="tabs">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 " style="width: 100%;">
					<nav>
						<div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
						<c:choose>
						<c:when test="${tab==2}">
							<a class="nav-item nav-link " id="nav-ThongBao-tab"
								data-toggle="tab" href="#nav-home" role="tab"
								aria-controls="nav-home" aria-selected="fasle">Thông báo</a>
							<a class="nav-item nav-link active" id="nav-Deadline-tab"
								data-toggle="tab" href="#nav-profile" role="tab"
								aria-controls="nav-profile" aria-selected="true">Deadline</a>
						</c:when>
						<c:otherwise>
							<a class="nav-item nav-link active" id="nav-ThongBao-tab"
								data-toggle="tab" href="#nav-home" role="tab"
								aria-controls="nav-home" aria-selected="true">Thông báo</a>
							<a class="nav-item nav-link" id="nav-Deadline-tab"
								data-toggle="tab" href="#nav-profile" role="tab"
								aria-controls="nav-profile" aria-selected="false">Deadline</a>
						</c:otherwise>
						</c:choose>
						</div>
					</nav>
					<div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent"
						style="width: 100%;">
						<c:choose>
						<c:when test="${tab==2}">
							<div class="tab-pane fade " id="nav-home"
								role="tabpanel" aria-labelledby="nav-ThongBao-tab">
								<%@ include file="/views/admin/ThongBao.jsp"%>
							</div>
							<div class="tab-pane fade show active" id="nav-profile" role="tabpanel"
								aria-labelledby="nav-Deadline-tab">
								<%@ include file="/views/admin/Deadline.jsp"%>
							</div>
					  	</c:when>
					 	<c:otherwise>
					    	<div class="tab-pane fade show active" id="nav-home"
								role="tabpanel" aria-labelledby="nav-ThongBao-tab">
								<%@ include file="/views/admin/ThongBao.jsp"%>
							</div>
							<div class="tab-pane fade" id="nav-profile" role="tabpanel"
								aria-labelledby="nav-Deadline-tab">
								<%@ include file="/views/admin/Deadline.jsp"%>
							</div>
					  	</c:otherwise>
					</c:choose>
					
					
					
					
						<!-- giữ nguyên tab khi thao tác -->
						
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>