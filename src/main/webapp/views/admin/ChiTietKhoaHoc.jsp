<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
        </head>

        <body>

            <div class="input-group md-form form-sm form-2 pl-0 ">
                <h3>Khoá học: ${course.getName()}</h3>
                <button id="btn-add-stage" type="button" class="btn btn-outline-danger ml-4 mb-2" data-toggle="modal" data-target="#add-giai-doan">Thêm giai đoạn</button>
                <button id="btn-add-chapter" type="button" class="btn btn-outline-primary ml-2 mb-2" data-toggle="modal" data-target="#add-bai-hoc" course-id="${course.id}">Thêm bài học</button>
                <button id="btn-add-lesson" type="button" class="btn btn-outline-success ml-2 mb-2" data-toggle="modal" data-target="#add-buoi-hoc" course-id="${course.id}">Thêm buổi học</button>
                <a href='<c:url value="/admin/khoa-hoc" />'>
                    <button class="btn btn-primary mb-2" style="position: absolute; right: 0;">Thoát</button>
                </a>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <!-- tblStage -->

                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Giai đoạn</h6>
                            </div>
                            <div class="card-body">
                                <div>
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Tên</th>
                                                <th>Mô tả</th>
                                                <th>Ghi chú</th>
                                                <th>Thao tác</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="stage" items="${stages}">
                                                <tr>
                                                    <td>${stage.name}</td>
                                                    <td>${stage.description}</td>
                                                    <td>${stage.note}</td>
                                                    <td>
                                                        <i class="fa fa-pencil btn-edit-stage" aria-hidden="true" style="margin-right: 2px;" data-toggle="modal" data-target="#add-giai-doan" stage-id="${stage.id}"></i>
                                                        <i class="fa fa-trash btn-delete-stage" aria-hidden="true" stage-id="${stage.id}" course-id="${course.id}"></i>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col-sm-6">
                        <div class="row">
                            <div class="col-sm-12">
                                <!-- tblChapter -->

                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">Bài học</h6>
                                    </div>
                                    <div class="card-body">
                                        <div>
                                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>Tên giai đoạn</th>
                                                        <th>Tên bài học</th>
                                                        <th>Nội dung</th>
                                                        <th>Thao tác</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="chapter" items="${chapters}">
                                                        <tr>
                                                            <td>${chapter.stageName}</td>
                                                            <td>${chapter.name}</td>
                                                            <td>${chapter.content}</td>
                                                            <td>
                                                                <i class="fa fa-pencil btn-edit-chapter" aria-hidden="true" style="margin-right: 2px;" data-toggle="modal" data-target="#add-bai-hoc" chapter-id="${chapter.id}" course-id="${course.id}"></i>
                                                                <i class="fa fa-trash btn-delete-chapter" aria-hidden="true" chapter-id="${chapter.id}"></i>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="col-sm-12">
                                <!-- tblLesson -->

                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">Buổi học</h6>
                                    </div>
                                    <div class="card-body">
                                        <div>
                                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>Tên giai đoạn</th>
                                                        <th>Tên buổi học</th>
                                                        <th>Số lượng</th>
                                                        <th>Thao tác</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="lesson" items="${lessons}">
                                                        <tr>
                                                            <td>${lesson.stageName}</td>
                                                            <td>${lesson.name}</td>
                                                            <td>${lesson.numOfStudent}</td>
                                                            <td>
                                                                <i class="fa fa-pencil btn-edit-lesson" aria-hidden="true" style="margin-right: 2px;" data-toggle="modal" data-target="#add-buoi-hoc" lesson-id="${lesson.id}" course-id="${course.id}"></i>
                                                                <i class="fa fa-trash btn-delete-lesson" aria-hidden="true" lesson-id="${lesson.id}"></i>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- start Modal Stage -->
            <div class="modal fade" id="add-giai-doan" tabindex="-1" role="dialog" aria-labelledby="EditUserModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Giai đoạn</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
                        </div>

                        <form id="stage-modal" action="/admin/chi-tiet-khoa-hoc?action=create_giai_doan" method="post">
                            <input id="stage-id" name="id" hidden="true" />
                            <input id="course-id" name="coursesId" hidden="true" value="${course.getId()}">
                            <div class="modal-body div-dangki">
                                <div class="form-group row">
                                    <label for="courses-name" class="col-sm-3 col-form-label">Giai đoạn:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="stage-name" name="name">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Mô tả:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="stage-description" name="description">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Ghi chú:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="stage-note" name="note">
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                                <button type="submit" class="btn btn-primary">Lưu</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- end Modal Stage -->

            <!-- start Modal Chapter -->
            <div class="modal fade" id="add-bai-hoc" tabindex="-1" role="dialog" aria-labelledby="EditUserModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Giai đoạn</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
                        </div>

                        <form id="chapter-modal" action="/admin/chi-tiet-khoa-hoc?action=create_bai_hoc&courseId=${course.id}" method="post">
                            <input id="chapter-id" name="id" hidden/>

                            <div class="modal-body">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Bài học:</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" name="stageId" id="stageId" style="margin-bottom: 0px; float: right;"><!--  position: absolute; float: 0 -->
                                            <c:forEach var="stage" items="${stages}">
                                                <option value="${stage.id}" >${stage.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Tên bài học:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="chapter-name" name="name">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Nội dung:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="chapter-content" name="content">
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                                <button type="submit" class="btn btn-primary ">Lưu</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- end Modal Chapter -->

            <!-- start Modal Lesson -->
            <div class="modal fade" id="add-buoi-hoc" tabindex="-1" role="dialog" aria-labelledby="EditUserModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Buổi học</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
                        </div>

                        <form id="lesson-modal" action="/admin/chi-tiet-khoa-hoc?action=create_buoi_hoc&courseId=${course.id}" method="post">
                            <input id="lesson-id" name="id" hidden />
                            <div class="modal-body">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Giai đoạn:</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" name="stageId" id="stageId-lesson" style="margin-bottom: 0px; float: right;"><!--  position: absolute; float: 0 -->
                                            <c:forEach var="stage" items="${stages}">
                                                <option value="${stage.id}" >${stage.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Tên buổi học:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="lesson-name" name="name">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Số lượng:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="numOfStudent" name="numOfStudent">
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                                <button type="submit" class="btn btn-primary ">Lưu</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- end Modal Lesson -->
            <script src="<c:url value='/js/admin/ChiTietKhoaHoc.js' />"></script>
        </body>

        </html>