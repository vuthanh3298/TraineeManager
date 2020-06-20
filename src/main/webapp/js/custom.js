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
function goBack() {
	  window.history.back();
	}
//lấy tuần hiện tại
Date.prototype.getWeekNumber = function(){
	  var d = new Date(Date.UTC(this.getFullYear(), this.getMonth(), this.getDate()));
	  var dayNum = d.getUTCDay() || 7;
	  d.setUTCDate(d.getUTCDate() + 4 - dayNum);
	  var yearStart = new Date(Date.UTC(d.getUTCFullYear(),0,1));
	  return Math.ceil((((d - yearStart) / 86400000) + 1)/7);
};
var editor='';
//ckeditor
editor= CKEDITOR.replace('editorContentThongBao');
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
    
    /*Khoá học*/
    $('#btn-course-create').click(function() {
        $('#course-modal').attr('action', '/admin/khoa-hoc?action=create_khoa_hoc');
    });

    $('.btn-edit-courses').click(function() {
        $('#course-modal').attr('action', '/admin/khoa-hoc?action=update_khoa_hoc');
        var data = {
            id: $(this).attr('id-course')
        };
        $.ajax({
            url: '/api/khoa-hoc',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result !== null) {
                    $("#course-id").val(result.id);
                    $("#courses-name").val(result.name);
                    $("#courses-start-time").val(formatDate(result.startTime));
                    $("#courses-end-time").val(formatDate(result.endTime));
                    $("#courses-description").val(result.description);
                    $("#courses-note").val(result.note);
                }
            }
        });
    });

    $('.btn-delete-courses').click(function() {
        var data = {
            id: $(this).attr('id-course')
        };
        $.ajax({
            url: '/api/khoa-hoc',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result > -1) {
                    window.location = '/admin/khoa-hoc';
                }
            }
        });
    });
    
});