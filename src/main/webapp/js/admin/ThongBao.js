$(document).ready(function() {
	$(".btndeleteThongBao").click(function() {
        var idThongBao = $(this).attr("id-Thong-Bao");
        var This = $(this);
        var data = {
            id: idThongBao
        };
        $.ajax({
            url: '/api/thong-bao-deadline?action=delete_thong_bao',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result > 0) {
                    This.closest("li").remove();
                } else {
                    alert("bug");
                }
            }
        });
    });
	
	$('#ClassesNameThongBao').on('change', function (e) {
    	var optionSelected = $("option:selected", this);
        var valueSelected = this.value;
        window.location = "/admin/thong-bao-deadline?action=thong_bao_va_deadline&class="+valueSelected;
    });
	
});

