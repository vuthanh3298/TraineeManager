<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Admin</title>
<!-- Custom fonts for this template-->

<link rel="stylesheet" href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" />
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<!-- Custom styles for this template-->
<link rel="stylesheet" href="<c:url value='/template/admin/css/sb-admin-2.min.css' />" />
<link rel="stylesheet" href='<c:url value="/template/vendor/font-awesome/css/font-awesome.min.css"/>' />

<link rel="stylesheet" href='<c:url value="/template/vendor/datatables/dataTables.bootstrap4.min.css"/>' />

<link rel="stylesheet" href="<c:url value='/template/admin/css/styles.css' />" />
<!-- ckeditor -->
<script src="<c:url value='/ckeditor/ckeditor.js' />"></script>


<script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
<!-- MDBootstrap Datatables  -->
<link href="<c:url value='/template/vendor/table/datatables.min.css' />" rel="stylesheet">
<!-- MDBootstrap Datatables  -->
<script type="text/javascript" src="<c:url value='/template/vendor/table/datatables.min.js' />"></script>
<link rel="stylesheet" href="<c:url value='/template/loader/jquery.loadingModal.css' />" />

<link rel="stylesheet" href="<c:url value='/template/admin/css/styles.css' />" />
<!-- ckeditor -->
<script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
  
<style type="text/css">
table.dataTable thead .sorting:after, table.dataTable thead .sorting:before,
	table.dataTable thead .sorting_asc:after, table.dataTable thead .sorting_asc:before,
	table.dataTable thead .sorting_asc_disabled:after, table.dataTable thead .sorting_asc_disabled:before,
	table.dataTable thead .sorting_desc:after, table.dataTable thead .sorting_desc:before,
	table.dataTable thead .sorting_desc_disabled:after, table.dataTable thead .sorting_desc_disabled:before
	{
	bottom: .5em;
	}
</style>


<%-- <script src="<c:url value='/template/loader/jquery-3.1.1.slim.min.js' />"></script>
<script src="<c:url value='/template/loader/jquery.loadingModal.js' />"></script> --%>

</head>
<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Sidebar -->
		<%@ include file="/common/admin/menu.jsp"%>
		<!-- End of Sidebar -->
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<!-- Topbar -->
				<%@ include file="/common/admin/header.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<dec:body />
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->
			<!-- Footer -->
			<%@ include file="/common/admin/footer.jsp"%>
			<!-- End of Footer -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>


	<!-- Bootstrap core JavaScript-->

	<script
		src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js' />"></script>
	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/template/admin/js/sb-admin-2.min.js' />"></script>
	<!-- Page level plugins -->
	<script
		src="<c:url value='/template/admin/vendor/chart.js/Chart.min.js' />"></script>
	<!-- Page level custom scripts -->
	<script
		src="<c:url value='/template/admin/js/demo/chart-area-demo.js' />"></script>
	<script
		src="<c:url value='/template/admin/js/demo/chart-pie-demo.js' />"></script>
	<script src="<c:url value='/js/custom.js' />"></script>
</body>
</html>
