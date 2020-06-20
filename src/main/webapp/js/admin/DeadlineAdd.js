var today = new Date();
document.getElementById("due_dateDeadline").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + (today.getDate())).slice(-2);
//lấy ngày đầu tuần
function getDateOfISOWeek(w, y) {
    var simple = new Date(y, 0, 1 + (w - 1) * 7);
    var dow = simple.getDay();
    var ISOweekStart = simple;
    if (dow <= 4)
        ISOweekStart.setDate(simple.getDate() - simple.getDay() + 1);
    else
        ISOweekStart.setDate(simple.getDate() + 8 - simple.getDay());
    return ISOweekStart;
}
function setTitleAndContent() {
	var temp = document.getElementById("due_weekDeadline").value.split('-W');
	var year = temp[0];
	var week = temp[1];
	var startDate = getDateOfISOWeek(week,year);
	var endDay = new Date(startDate);
	endDay.setDate(startDate.getDate() + 6);
	
	
	
	
	
	// set value title
	document.getElementById("title").value = "Đăng ký lịch học "+ document.getElementById("due_weekDeadline").value;
	// set value editor
	var contentEditor=" <br/>Các bạn";
	if(document.getElementById("AddDeadlineClasses").value !="Tất cả"){
		contentEditor+=" học lớp "+ document.getElementById("AddDeadlineClasses").value;
	}
	contentEditor+=" đăng ký lịch học cho tuần " + document.getElementById("due_weekDeadline").value;
	contentEditor+="("+ startDate.getDate()+"/"+startDate.getMonth()+"/"+startDate.getFullYear() +" - " + endDay.getDate() +"/"+endDay.getMonth()+"/"+endDay.getFullYear()+")";
	//contentEditor+= "<br/>Link đăng ký: <a href='/web/dangkylichhoc?action=dang-ky-lich-hoc&id="+ document.getElementById("due_weekDeadline").value +"'> Đăng ký lịch học tuần "+ document.getElementById("due_weekDeadline").value + "</a>";
	editor.setData(contentEditor);
	
}
function removeTitleAndContent() {
	document.getElementById("due_weekDeadline").value = "" ;
	editor.setData("");
	document.getElementById("title").value = "";
}
function setWeakInYearNow() {
	var today = new Date();
	var w=today.getFullYear()+'-W'+ new Date().getWeekNumber();
	document.getElementById("due_weekDeadline").value = w ;
}

$(document).ready(function() { 
	
	// không cho chọn ngày nhỏ hơn ngày hiện tại
	$('#due_dateDeadline').on('change', function (e) {
		if (new Date(document.getElementById("due_dateDeadline").value).getTime() <= today.getTime()) {
	    	document.getElementById("due_dateDeadline").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + (today.getDate())).slice(-2);
	    }
	});
	
	$("#btn-save-add-Deadline").click(function() {
    	
        var title = $('#title').val();
        var dueDate=$('#due_dateDeadline').val();
        var WeekInYear = $('#due_weekDeadline').val();
        var isRegister = false;
        if($('#loaiDeadline').val()==="dangkylichtraining"){
        	isRegister = true;
    	}
        
        var toClass = $('#AddDeadlineClasses').val();
        var data = {
        		title: title,
        		dueDate: dueDate,
        		weekInYear: WeekInYear,
        		isRegister: isRegister,
        		toClass: toClass
        }
       data["content"]=editor.getData();
        $.ajax({
            url: '/api/thong-bao-deadline?action=add_deadline',
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
    //chọn loại deadline
    $('#loaiDeadline').on('change', function (e) {
    	if(document.getElementById("loaiDeadline").value === "dangkylichtraining"){
    		setWeakInYearNow();
    		setTitleAndContent();
    		$("#div-week-deadline").show();
    	} else{
    		removeTitleAndContent();
    		$("#div-week-deadline").hide();
    	}
    });

    // Chọn tuần để đăng ký lịch => thay đổi nội dung
    $('#due_weekDeadline').on('change', function (e) {
    	var WeekInYear = $('#due_weekDeadline').val().split("-W");
    	var today = new Date();
    	var weekNow = "" + new Date().getWeekNumber();
    	var yearNow = "" + new Date().getFullYear();
    	if(WeekInYear[0] <= yearNow && WeekInYear[1] <= weekNow){
    		setWeakInYearNow();
    	}
    	setTitleAndContent();
    });
    $('#AddDeadlineClasses').on('change', function (e) {
    	if(document.getElementById("loaiDeadline").value === "dangkylichtraining"){
    		setTitleAndContent();
    	}
    });
    
});