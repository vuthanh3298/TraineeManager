<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
        <div class="container-fluid">
            <!-- start list users -->

            <div style="margin-top: 68px">
                <h2 class="h2-admin">THỜI KHÓA BIỂU</h2>
            </div>
            <div class="div-select-filter">
                <select name="loaiThongBao" class="select-filter">
			<option value="thongbaonghi">Jwat 01</option>
			<option value="thongbaonghi">Jwat 02</option>
			<option value="thongbaonghi">Jwat 03</option>
			<option value="thongbaonghi">Jwat 04</option>
		</select>
            </div>
            <div>
                <form action="/jwat/xemlich" method="post">
                    <div class="input-group md-form form-sm form-2 pl-0 " style="margin-bottom: 5px;">
                        <div class="input-group-prepend">
                            <span class="btn input-group-text red lighten-3 backward span-ward"></span>
                        </div>
                        <input id="idinputWeek" type="week" name="weekSoanLich" style="width: 200px; height: 30px; border: 1px solid #999;" />
                        <div class="input-group-append ">
                            <span class="btn input-group-text red lighten-3 forward span-ward"></span>
                        </div>

                    </div>

                </form>
            </div>
            <table class="table table-striped table-bordered" style="text-align: center;">
                <thead>
                    <tr>
                        <th scope="col">Tuần</th>
                        <th scope="col">Thứ 2</th>
                        <th scope="col">Thứ 3</th>
                        <th scope="col">Thứ 4</th>
                        <th scope="col">Thứ 5</th>
                        <th scope="col">Thứ 6</th>
                        <th scope="col">Thứ 7</th>
                        <th scope="col">chủ nhật</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="col">Sáng</th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="s2" data-target="#exampleModalCenter"><span style="color: red;">
						Chapter 1+2</span> <br /> (15 ng) <br />7F small <br /> Anh Thuận <br /> 9h30 - 11h30</th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="s3" data-target="#exampleModalCenter"><span style="color: red;">
						Chapter 1+2</span> <br /> (15 ng) <br />7F small <br /> Anh Thuận <br /> 9h30 - 11h30</th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="s4" data-target="#exampleModalCenter"><span style="color: red;">
						Chapter 1+2</span> <br /> (15 ng) <br />7F small <br /> Anh Thuận <br /> 9h30 - 11h30</th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="s5" data-target="#exampleModalCenter"><span style="color: red;">
						Chapter 1+2</span> <br /> (15 ng) <br />7F small <br /> Anh Thuận <br /> 9h30 - 11h30</th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="s6" data-target="#exampleModalCenter"><span style="color: red;">
						Chapter 1+2</span> <br /> (15 ng) <br />7F small <br /> Anh Thuận <br /> 9h30 - 11h30</th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="s7" data-target="#exampleModalCenter"><span style="color: red;">
						Chapter 1+2</span> <br /> (15 ng) <br />7F small <br /> Anh Thuận <br /> 9h30 - 11h30</th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="s8" data-target="#exampleModalCenter"><span style="color: red;">
						Chapter 1+2</span> <br /> (15 ng) <br />7F small <br /> Anh Thuận <br /> 9h30 - 11h30</th>
                    </tr>
                    <tr>
                        <th colspan="8"></th>
                    </tr>
                    <tr>
                        <th scope="col">Chiều</th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="c2" data-target="#exampleModalCenter">${schedule.get("c2").getNoiDung() }
                            <br /> ${schedule.get("c2").getSoLuong() } <br />${schedule.get("c2").getPhong()}
                        </th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="c3" data-target="#exampleModalCenter">${schedule.get("c3").getNoiDung() }
                            <br /> ${schedule.get("c3").getSoLuong() } <br />${schedule.get("c3").getPhong()}
                        </th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="c4" data-target="#exampleModalCenter">${schedule.get("c4").getNoiDung() }
                            <br /> ${schedule.get("c4").getSoLuong() } <br />${schedule.get("c4").getPhong()}
                        </th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="c5" data-target="#exampleModalCenter">${schedule.get("c5").getNoiDung() }
                            <br /> ${schedule.get("c5").getSoLuong() } <br />${schedule.get("c5").getPhong()}
                        </th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="c6" data-target="#exampleModalCenter">${schedule.get("c6").getNoiDung() }
                            <br /> ${schedule.get("c6").getSoLuong() } <br />${schedule.get("c6").getPhong()}
                        </th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="c7" data-target="#exampleModalCenter">${schedule.get("c7").getNoiDung() }
                            <br /> ${schedule.get("c7").getSoLuong() } <br />${schedule.get("c7").getPhong()}
                        </th>
                        <th scope="col" data-toggle="modal" class="thSoanLich" buoi="c8" data-target="#exampleModalCenter">${schedule.get("c8").getNoiDung() }
                            <br /> ${schedule.get("c8").getSoLuong() } <br />${schedule.get("c8").getPhong()}
                        </th>
                    </tr>
                </tbody>
            </table>
            <div>
                <h4 style="color: red;">Ghi chú:</h4>
                <textarea name="noiDung" class="form-control" rows="5" style="width: 50%">Các bạn chú ý đi đúng giờ.
				</textarea>
                <button type="button" style="margin-top: 5px; background-color: #0085A0;">Lưu Ghi
			chú</button>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
                    </div>

                    <form action="/admin/soan-thoi-khoa-bieu" method="post">
                        <div class="modal-body">
                            <div class="card">
                                <div class="card-body">
                                    <label class="mr-sm-2">Nội dung: </label>
                                    <select class="form-control mb-2 mr-sm-2" name="lessonId" id="lessonId">
										<c:forEach var="lesson" items="${lessons}">
											<option value="${lesson.id}" >${lesson.name}</option>
										</c:forEach>
									</select>
                                    <label class="mr-sm-2">Số lượng: </label>
                                    <input name="soLuong" type="number" class="form-control mb-2 mr-sm-2">
                                    <label class="mr-sm-2">Phòng: </label>
                                    <input name="phong" type="text" class="form-control mb-2 mr-sm-2">
                                    <label class="mr-sm-2">Trainer: </label>
                                    <input name="trainer" type="text" class="form-control mb-2 mr-sm-2">
                                    <label class="mr-sm-2">Ghi chú: </label>
                                    <input name="ghiChu" type="text" class="form-control mb-2 mr-sm-2">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Lưu</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>