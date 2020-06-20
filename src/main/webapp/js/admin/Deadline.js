$(document).ready(function() {
	$(".btndeleteDeadline").click(function() {
        var idDeadline = $(this).attr("id-Deadline");
        var This = $(this);
        var data = {
            id: idDeadline
        };
        $.ajax({
            url: '/api/thong-bao-deadline?action=delete_deadline',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result >0) {
                    This.closest("li").remove();
                } else {
                    alert("bug");
                }
            }
        });
    });
	$('#ClassesNameDeadline').on('change', function (e) {
    	var optionSelected = $("option:selected", this);
        var valueSelected = this.value;
        window.location = "/admin/thong-bao-deadline?action=thong_bao_va_deadline&tab=2&classDeadline="+valueSelected;
    });
	
});

