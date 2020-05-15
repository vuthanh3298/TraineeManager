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
    <c:if test="${not empty message}">
        <div class="alert alert-${alert}">
            ${message}
        </div>
    </c:if>
    <form id="form-profile" action="/admin/thong-tin-tai-khoan" method="POST">
        <input name="id" value="${USERMODEL.id}" hidden="true" />
        <div class="form-group row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control" id="staticEmail" value="${USERMODEL.email}" name="email">
            </div>
        </div>
        <div class="form-group row">
            <label for="username" class="col-sm-2 col-form-label">Tên:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" placeholder="Tên" value="${USERMODEL.username}" name="username">
            </div>
        </div>
        <div class="form-group row">
            <label for="newpassword" class="col-sm-2 col-form-label">Mật khẩu mới:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="new-password" placeholder="Mật khẩu mới - Bỏ trống nếu không thay đổi mật khẩu" name="password">
            </div>
        </div>
        <div class="form-group row">
            <label for="comfirm" class="col-sm-2 col-form-label">Nhập lại:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="confirm" placeholder="Nhập lại">
            </div>
        </div>
        <div class="form-group row" id="confirm-incorrect" hidden="true">
         	<div class="col-sm-2"></div>
            <div class="col-sm-10">
                <span style="color: red;">Nhập lại không đúng</span>
            </div>
        </div>
        <div class="form-group row">
            <label for="phone" class="col-sm-2 col-form-label">Điện thoại:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="phone" placeholder="Điện thoại" value="${USERMODEL.phoneNumber}" name="phoneNumber">
            </div>
        </div>
        <div class="form-group row">
            <label for="address" class="col-sm-2 col-form-label">Địa chỉ:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="address" placeholder="Địa chỉ" value="${USERMODEL.address}" name="address">
            </div>
        </div>
        <div class="form-group row">
            <label for="dob" class="col-sm-2 col-form-label">Ngày sinh:</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="dob" name="dob" value='<fmt:formatDate value="${USERMODEL.dob}" pattern="yyyy-MM-dd"/>'>
            </div>
        </div>
        <div class="form-group row">
            <label for="university" class="col-sm-2 col-form-label">Trường học:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="university" placeholder="Trường học" value="${USERMODEL.university}" name="university">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-2"></div>
            <div class="col-sm-10">
                <button id="btn-save-change" type="submit" class="btn btn-primary mb-2">Lưu thay đổi</button>
            </div>
        </div>
    </form>
</body>
</html>