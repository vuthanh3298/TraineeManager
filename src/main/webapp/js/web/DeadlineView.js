

$(document).ready(function() {  
	$("#btnLuuThongTinDangKyLich").click(function() {
		var deadlineId = $("#deadlineId").val();
		var weekInYear = $("#weekInYear").val();
		var schedule  = [];
		
		for(i=2;i<9;i++){
			var s = "S"+i;
			if($("#"+s).is(":checked")){
				schedule.push(s);
			}
			var c = "C"+i;
			if($("#"+c).is(":checked")){
				schedule.push(c);
			}
		}
		
		var data = {
				deadlineId: deadlineId,
				weekInYear: weekInYear,
				schedule: schedule.join('-')
        }
		$.ajax({
            url: '/api/thong-tin-dang-ky-lich?action=save_thong_tin_dang_ky_lich',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result === true) {
                    window.location = "/thong-tin-dang-ky-lich";
                } else {
                    alert("bug");
                }
            }
        });
		
	});
	$("#btnLuuThongTinDeadline").click(function() {
		var deadlineId = $("#deadlineId").val();
		var url_homework = $("#url_homework").val();
		var data = {
				deadlineId: deadlineId,
				urlHomework: url_homework,
        }
		$.ajax({
            url: '/api/luu-thong-tin-deadline?action=save_thong_tin_deadline',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result === true) {
                    window.location = "/thong-tin-dang-ky-lich";
                } else {
                    alert("bug");
                }
            }
        });
		
		//user_id
		//deadline_id
		//is_register
		//url_homework
	});
	
	//user_do_homework
});