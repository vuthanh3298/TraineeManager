function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' +
        d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}

function hideMessage() {
    $('.span-email-exist').attr("hidden", "hidden");
    $('.btn-create').removeAttr("disabled");
}

function showMessage() {
    $('.span-email-exist').removeAttr('hidden');
    $('.btn-create').attr("disabled", "disabled");
}
var editor = '';
$(document).ready(function() {
    $("#btn-save-change").click(function(event) {
        event.preventDefault();
        var password = $('#new-password').val();
        var confirm = $('#confirm').val();
        if (password !== confirm) {
            $('#confirm-incorrect').removeAttr('hidden');
        } else {
            $('#confirm-incorrect').attr('hidden', 'hidden');
            $('#form-profile').submit();
        }
    });
    $(".btnSuaTaiKhoan").click(function() {
        var idUser = $(this).attr("user-id");
        var data = {
            id: idUser
        };
        $.ajax({
            url: '/api/users?action=get_user',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result !== null) {
                    $("#user-id").val(result.id);
                    $("#email").val(result.email);
                    $("#username").val(result.username);
                    $("#phone").val(result.phoneNumber);
                    $("#address").val(result.address);
                    $("#dob").val(formatDate(result.dob));
                    $("#university").val(result.university);
                }
            }
        });
    });
    $(".btnDeleteTaiKhoan").click(function() {
        var idUser = $(this).attr("user-id");
        var This = $(this);
        var data = {
            id: idUser
        };
        $.ajax({
            url: '/api/users?action=delete_user',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result === true) {
                    This.closest("a").remove();
                } else {
                    alert("bug");
                }
            }
        });

    });

    $('.input-register-email').keyup(function() {
        var inputEmail = $(this);
        clearTimeout(inputEmail.data('timeout'));
        inputEmail.data('timeout', setTimeout(function() {
            if (inputEmail.val() !== '') {
                var data = {
                    email: inputEmail
                        .val()
                }
                $.ajax({
                    url: '/api/users?action=check_email_exist',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    dataType: 'json',
                    success: function(result) {
                        if (result == 1) {
                            showMessage();
                        } else {
                            hideMessage();
                        }
                    }
                });
            } else {
                hideMessage();
            }
        }, 500));
    });
    /* btn duyệt tài khoản */
    $(".btnDuyetTaiKhoan").click(function() {
        var idUser = $(this).attr("user-id");
        var This = $(this);
        var data = {
            id: idUser
        };
        $.ajax({
            url: '/api/users?action=duyet_user',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result === true) {
                    This.closest("tr").remove();
                } else {
                    alert("bug");
                }
            }
        });

    });
    /* chon all tài khoản */
    $("#checkedAll").change(function() {
        if (this.checked) {
            $(".checkSingle").each(function() {
                this.checked = true;
            });
        } else {
            $(".checkSingle").each(function() {
                this.checked = false;
            });
        }
    });

    $(".checkSingle").click(function() {
        if ($(this).is(":checked")) {
            var isAllChecked = 0;

            $(".checkSingle").each(function() {
                if (!this.checked)
                    isAllChecked = 1;
            });

            if (isAllChecked === 0) {
                $("#checkedAll").prop("checked", true);
            }
        } else {
            $("#checkedAll").prop("checked", false);
        }
    });
    /* duyệt tài khoản được chọn */
    $("#btnDuyetTaiKhoanDuocChon").click(function() {
        var arr = [];
        var checkbox = document
            .getElementsByName('checkSingle');
        for (var i = 0; i < checkbox.length; i++) {
            if (checkbox[i].checked === true) {
                arr.push(checkbox[i].value);
            }
        }
        var data = {
            ids: arr
        }
        $.ajax({
            url: '/api/users?action=duyet_users',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result === true) {
                    window.location = "/admin/thanh-vien-cho-duyet?action=choduyet";
                } else {
                    alert("bug");
                }
            }
        });

    });
    /* btn Xóa tài khoản chờ duyệt*/
    $(".delete-duyet").click(function() {
        var idUser = $(this).attr("user-id");
        var This = $(this);
        var data = {
            id: idUser
        };
        $.ajax({
            url: '/api/users?action=delete_user_cho_duyet',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result === true) {
                    This.closest("tr").remove();
                } else {
                    alert("bug");
                }
            }
        });

    });

    /* Xóa danh sách tài khoản chờ duyệt được chọn */
    $("#btnXoaTaiKhoanDuocChon").click(function() {
        var arr = [];
        var checkbox = document
            .getElementsByName('checkSingle');
        for (var i = 0; i < checkbox.length; i++) {
            if (checkbox[i].checked === true) {
                arr.push(checkbox[i].value);
            }
        }
        var data = {
            ids: arr
        }
        $.ajax({
            url: '/api/users?action=delete_users_cho_duyet',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result === true) {
                    window.location = "/admin/thanh-vien-cho-duyet?action=choduyet";
                } else {
                    alert("bug");
                }
            }
        });

    });

    $('.btn-edit-courses').click(function() {
        var data = {
            id: $(this).attr('id-course')
        };
        $.ajax({
            url: '/api/khoa-hoc?action=edit',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result !== null) {
                    console.log(result);
                    $("#courses-name").val('');
                    //					$("#courses-start-time").val('');
                    //					$("#courses-end-time").val('');
                    $("#courses-description").val('');
                    $("#courses-note").val('');
                }
            }
        });
    });
    //ckeditor
    editor = CKEDITOR.replace('editorContentThongBao');
    $("#btn-save-add-Thong-Bao").click(function() {
        var title = $('#title').val();
       // var toClass = $('#confirm').val();
       
        var data = {
        		title: title,
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
    
    /* btn sửa tài khoản*/
    $("#btn-save-edit-Thong-Bao").click(function() {
    	var idThongBao = $('#thong-bao-id').val();
        var title = $('#title').val();
        var data = {
        		id:idThongBao,
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
                if (result === true) {
                    window.location = "/admin/thong-bao-deadline?action=thong_bao_va_deadlinemessage=update_thanh_cong&alert=success";
                } else {
                	window.location = "/admin/thong-bao-deadline?action=thong_bao_va_deadline&message=update_that_bai&alert=warning";
                    
                }
            }
        });
    });
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
                if (result === true) {
                    This.closest("li").remove();
                } else {
                    alert("bug");
                }
            }
        });

    });
    // deadline
    
    $("#btn-save-add-Deadline").click(function() {
        var title = $('#title').val();
       // var toClass = $('#confirm').val();
       
        var data = {
        		title: title,
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
    
});