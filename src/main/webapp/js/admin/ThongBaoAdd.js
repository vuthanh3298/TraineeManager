var today = new Date();
document.getElementById("NgayNghiDau").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + (today.getDate())).slice(-2);
document.getElementById("NgayNghiCuoi").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + (today.getDate())).slice(-2);
function updateTitleAndContent() {
	if(document.getElementById("loaiThongBao").value === "thongbaokhac"){
		 document.getElementById("title").value = "";
		 $('#div-NgayNghiDau').attr("hidden", true);
		 $('#div-NgayNghiCuoi').attr("hidden", true);
	 }else{
		 $('#div-NgayNghiDau').removeAttr("hidden");
		 $('#div-NgayNghiCuoi').removeAttr("hidden");
		 if(document.getElementById("ClassesNameAddThongBao").value === "Tất cả"){
			 if(new Date(document.getElementById("NgayNghiCuoi").value).getTime() === new Date(document.getElementById("NgayNghiDau").value).getTime()){
				 document.getElementById("title").value = "Thông báo tất cả các lớp nghỉ ngày " + document.getElementById("NgayNghiCuoi").value ;
				 editor.setData("Thông báo tất cả các lớp nghỉ ngày " + document.getElementById("NgayNghiCuoi").value );
			 }
			 else{
				 document.getElementById("title").value = "Thông báo tất cả các lớp nghỉ ngày " + document.getElementById("NgayNghiDau").value +" tới ngày " +  document.getElementById("NgayNghiCuoi").value;
				 editor.setData("Thông báo tất cả các lớp nghỉ từ ngày " + document.getElementById("NgayNghiDau").value +" tới ngày " +  document.getElementById("NgayNghiCuoi").value);
			 }
		 }else{
			 if(new Date(document.getElementById("NgayNghiCuoi").value).getTime() === new Date(document.getElementById("NgayNghiDau").value).getTime()){
				 document.getElementById("title").value = "Thông báo lớp "+ document.getElementById("ClassesNameAddThongBao").value +" nghỉ ngày " + document.getElementById("NgayNghiCuoi").value ;
				 editor.setData("Thông báo lớp "+ document.getElementById("ClassesNameAddThongBao").value +" nghỉ ngày " + document.getElementById("NgayNghiCuoi").value);
			 }
			 else{
				 document.getElementById("title").value = "Thông báo lớp "+ document.getElementById("ClassesNameAddThongBao").value +" từ ngày " + document.getElementById("NgayNghiDau").value +" tới ngày " +  document.getElementById("NgayNghiCuoi").value;
				 editor.setData("Thông báo lớp "+ document.getElementById("ClassesNameAddThongBao").value +" từ ngày " + document.getElementById("NgayNghiDau").value +" tới ngày " +  document.getElementById("NgayNghiCuoi").value);
			 }
		 }
	 }
}
function NgayNghi(id) {
    if (id ==="NgayNghiDau" && new Date(document.getElementById(id).value).getTime() <= today.getTime()) {
    	document.getElementById(id).value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + (today.getDate())).slice(-2);
    	document.getElementById("NgayNghiDau").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + (today.getDate())).slice(-2);
    }
    if( new Date(document.getElementById("NgayNghiCuoi").value).getTime() < new Date(document.getElementById("NgayNghiDau").value).getTime()) {
		 document.getElementById("NgayNghiCuoi").value = document.getElementById("NgayNghiDau").value;
	  }
    updateTitleAndContent();
   
}
$(document).ready(function() {
	
	$('#loaiThongBao').on('change', function (e) {
	     updateTitleAndContent();
	  });
	$('#ClassesNameAddThongBao').on('change', function (e) {
	     updateTitleAndContent();
	  });
	 
	$("#btn-save-add-Thong-Bao").click(function() {
	        var title = $('#title').val();
		 	var toClass =$("#ClassesNameAddThongBao").val();
		 	var data = {
	        		title: title,
	        		toClass:toClass
	        }
		 	data["content"]=editor.getData();
		 	$.ajax({
	            url: '/api/thong-bao-deadline?action=add_thong_bao',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function(result) {
	                if (result === true) {
	                    window.location = "/admin/thong-bao-deadline?action=thong_bao_va_deadline";
	                } else {
	                    alert("bug");
	                }
	            }
	        });
	    });
});

