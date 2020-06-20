 

$(document).ready(function() {
	 $("#btn-save-edit-Thong-Bao").click(function() {
	    	var idThongBao = $('#thong-bao-id').val();
	    	var toClass =$("#ClassesNameEditThongBao").val();
	        var title = $('#title').val();
	        var data = {
	        		id:idThongBao,
	        		toClass:toClass,
	        		title: title,
	        }
	       data["content"]=editor.getData();
	        $.ajax({
	            url: '/api/thong-bao-deadline?action=save_edit_thong_bao',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function(result) {
	                if (result > 0) {
	                    window.location = "/admin/thong-bao-deadline?action=thong_bao_va_deadline&message=update_thanh_cong&alert=success";
	                } else {
	                	window.location = "/admin/thong-bao-deadline?action=thong_bao_va_deadline&message=update_that_bai&alert=warning";
	                }
	            }
	        });
	    });
	 
 });