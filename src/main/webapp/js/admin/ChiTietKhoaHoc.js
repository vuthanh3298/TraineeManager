$(document).ready(function() {
    $('#btn-add-stage').on('click', function() {
        $('#stage-modal').attr('action', '/admin/chi-tiet-khoa-hoc?action=create_giai_doan');
        $("#stage-id").val('');
        $("#stage-name").val('');
        $("#stage-description").val('');
        $("#stage-note").val('');
    });

    $('.btn-edit-stage').click(function() {
        $('#stage-modal').attr('action', '/admin/chi-tiet-khoa-hoc?action=update_giai_doan');
        var data = {
            id: $(this).attr('stage-id')
        };
        $.ajax({
            url: '/api/stage',
            type: 'GET',
            contentType: 'application/json',
            data,
            dataType: 'json',
            success: function(result) {
                if (result !== null) {
                    $("#stage-id").val(result.id);
                    $("#stage-name").val(result.name);
                    $("#stage-description").val(result.description);
                    $("#stage-note").val(result.note);
                }
            }
        });
    });

    $('.btn-delete-stage').click(function() {
        const courseId = $(this).attr('course-id');
        var data = {
            id: $(this).attr('stage-id')
        };
        // $('body').loadingModal({
        //     text: 'Showing loader animations...'
        // });
        // $('body').loadingModal('animation', 'spinner');
        $.ajax({
            url: '/api/stage',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result > 0) {
                    window.location = `/admin/khoa-hoc?action=chi_tiet_khoa_hoc&id=${courseId}`
                }
            }
        });
    });

    $('#btn-add-chapter').click(function() {
        const courseId = $(this).attr('course-id');
        $('#chapter-modal').attr('action', `/admin/chi-tiet-khoa-hoc?action=create_bai_hoc&courseId=${courseId}`);
        $("#chapter-id").val('');
        $("#stageId").val('');
        $("#chapter-name").val('');
        $("#chapter-content").val('');
    });

    $('.btn-edit-chapter').click(function() {
        const courseId = $(this).attr('course-id');
        $('#chapter-modal').attr('action', `/admin/chi-tiet-khoa-hoc?action=update_bai_hoc&courseId=${courseId}`);
        var data = {
            id: $(this).attr('chapter-id')
        };
        $.ajax({
            url: '/api/chapter',
            type: 'GET',
            contentType: 'application/json',
            data,
            dataType: 'json',
            success: function(result) {
                if (result !== null) {
                    $("#chapter-id").val(result.id);
                    $("#stageId").val(result.stageId);
                    $("#chapter-name").val(result.name);
                    $("#chapter-content").val(result.content);
                }
            }
        });
    });

    $('.btn-delete-chapter').click(function() {
        const this2 = $(this);
        var data = {
            id: $(this).attr('chapter-id')
        };
        $.ajax({
            url: '/api/chapter',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result > 0) {
                    this2.closest('tr').remove();
                }
            }
        });
    });

    $('#btn-add-lesson').click(function() {
        const courseId = $(this).attr('course-id');
        $('#lesson-modal').attr('action', `/admin/chi-tiet-khoa-hoc?action=create_buoi_hoc&courseId=${courseId}`);
        $("#lesson-id").val('');
        $("#stageId-lesson").val('');
        $("#lesson-name").val('');
        $("#numOfStudent").val('');
    });

    $('.btn-edit-lesson').click(function() {
        const courseId = $(this).attr('course-id');
        $('#lesson-modal').attr('action', `/admin/chi-tiet-khoa-hoc?action=update_buoi_hoc&courseId=${courseId}`);
        var data = {
            id: $(this).attr('lesson-id')
        };
        $.ajax({
            url: '/api/lesson',
            type: 'GET',
            contentType: 'application/json',
            data,
            dataType: 'json',
            success: function(result) {
                if (result !== null) {
                    $("#lesson-id").val(result.id);
                    $("#stageId-lesson").val(result.stageId);
                    $("#lesson-name").val(result.name);
                    $("#numOfStudent").val(result.numOfStudent);
                }
            }
        });
    });

    $('.btn-delete-lesson').click(function() {
        const this2 = $(this);
        var data = {
            id: $(this).attr('lesson-id')
        };
        $.ajax({
            url: '/api/lesson',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                if (result > 0) {
                    this2.closest('tr').remove();
                }
            }
        });
    });
});