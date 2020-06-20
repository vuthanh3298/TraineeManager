var today = new Date();
function setTitleAndContent() {
	// set value title
	document.getElementById("title").value = "Đăng ký lịch học "+ document.getElementById("due_weekEditDeadline").value;
	// set value editor
	var contentEditor=" <br/>Các bạn";
	if(document.getElementById("EditDeadlineClasses").value !="Tất cả"){
		contentEditor+=" học lớp "+ document.getElementById("EditDeadlineClasses").value;
	}
	contentEditor+=" đăng ký lịch học cho tuần " + document.getElementById("due_weekEditDeadline").value;
	contentEditor+="("+ startDate.getDate()+"/"+startDate.getMonth()+"/"+startDate.getFullYear() +" - " + endDay.getDate() +"/"+endDay.getMonth()+"/"+endDay.getFullYear()+")";
	//contentEditor+= "<br/>Link đăng ký: <a href='/web/dangkylichhoc?action=dang-ky-lich-hoc&id="+ document.getElementById("due_weekEditDeadline").value +"'> Đăng ký lịch học tuần "+ document.getElementById("due_weekEditDeadline").value + "</a>";
	editor.setData(contentEditor);
	
}
function removeTitleAndContent() {
	document.getElementById("due_weekEditDeadline").value = "" ;
	editor.setData("");
	document.getElementById("title").value = "";
}
function setWeakInYearNow() {
	var today = new Date();
	var w=today.getFullYear()+'-W'+ new Date().getWeekNumber();
	document.getElementById("due_weekEditDeadline").value = w ;
}

$(document).ready(function() {
	$('#due_dateDeadline').on('change', function (e) {
		if (new Date(document.getElementById("due_dateDeadline").value).getTime() <= today.getTime()) {
	    	document.getElementById("due_dateDeadline").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + (today.getDate())).slice(-2);
	    }
	});
	 $('#due_weekEditDeadline').on('change', function (e) {
	    	var WeekInYear = $('#due_weekEditDeadline').val().split("-W");
	    	var today = new Date();
	    	var weekNow = "" + new Date().getWeekNumber();
	    	var yearNow = "" + new Date().getFullYear();
	    	if(WeekInYear[0] <= yearNow && WeekInYear[1] <= weekNow){
	    		setWeakInYearNow();
	    	}
	    	setTitleAndContent();
	    });
	
	 $('#EditDeadlineClasses').on('change', function (e) {
	    	if(document.getElementById("loaiDeadline").value === "dangkylichtraining"){
	    		setTitleAndContent();
	    	}
	    });

	    $("#btn-save-edit-deadline").click(function() {
	    	var idDeadline = $('#deadline-id').val();
	        var title = $('#title').val();
	        var dueDate=$('#due_dateDeadline').val();
	        var WeekInYear = $('#due_weekEditDeadline').val();
	        var isRegister = false;
	        if($('#loaiDeadline').val()==="dangkylichtraining"){
	        	isRegister = true;
	    	}
	        var toClass = $('#EditDeadlineClasses').val();
	        var data = {
	        		id:idDeadline,
	        		title: title,
	        		dueDate: dueDate,
	        		weekInYear: WeekInYear,
	        		isRegister: isRegister,
	        		toClass: toClass
	        }
	       data["content"]=editor.getData();
	        
	        $.ajax({
	            url: '/api/thong-bao-deadline?action=save_edit_deadline',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function(result) {
	                if (result === true) {
	                    window.location = "/admin/thong-bao-deadline?action=thong_bao_va_deadline&message=update_thanh_cong&alert=success";
	                } else {
	                	window.location = "/admin/thong-bao-deadline?action=thong_bao_va_deadline&message=update_that_bai&alert=warning";
	                    
	                }
	            }
	        });
	    });
	    
	    
});

