<%-- 
    Document   : list
    Created on : Apr 21, 2022, 8:15:41 PM
    Author     : Nguyen Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<c:url var="addUrl" value='/admin/user/save'/>
<c:url var="apiUserURl" value="/api/users/checkEmail"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN - CHỈNH SỦA TÀI KHOẢN</title>
    </head>
    <body>
        <!-- Begin Page Content -->
        <div class="container-fluid">

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800 text-uppercase">QUẢN LÍ TÀI KHOẢN</h1>
            <a href="<c:url value="/admin/user"/>" class="mb-4 btn btn-primary"><span class="fas fa-arrow-alt-circle-left"></span> Trở Về Danh Sách Tài Khoản</a>
            <br/>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <c:if test="${user.id != null}">
                        <h6 class="m-0 font-weight-bold text-primary">Cập nhật tài khoản</h6>
                    </c:if>
                    <c:if test="${user.id == null}">
                        <h6 class="m-0 font-weight-bold text-primary">Thêm mới tài khoản</h6>
                    </c:if>
                </div>
                <c:if test="${message != null}">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            ${message}
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:if>
                <div class="card-body">
                    <form:form action="${addUrl}" method="POST" modelAttribute="user" onsubmit="checkEmailUnique(this)">
                        <div class="row">
                            <form:hidden path="id"/>
                            <div class="form-group col-12">
                                <label >Email</label>
                                <form:input path="email" class="form-control" required="required" placeholder="Nhập Email" type="email"/>
                            </div>

                            <div class="form-group col-12">
                                <label >Password</label>
                                <c:if test="${user.id != null || not empty user.id}">
                                    <form:input path="password"  placeholder="Để Trống Nếu Không Cập Nhật" type="password" class="form-control"/>
                                </c:if>
                                <c:if test="${user.id == null || empty user.id}">
                                    <form:input path="password" required="required"  type="password" class="form-control"  
                                            placeholder="Nhập Password"/>
                                </c:if>
                                

                            </div>

                            <div class="form-group col-4">
                                <label >Họ</label>
                                <form:input path="firstName" required="required" class="form-control"/>
                            </div>
                            <div class="form-group col-4">
                                <label >Tên</label>
                                <form:input path="lastName" required="required"  class="form-control"/>
                            </div>
                            <c:if  test="${id == null}">
                                <div class="form-group col-12">
                                    <label >Vai Trò</label>
                                    <form:select  path="roleId" class="form-control">
                                        <form:options items="${roles}" itemLabel="title" itemValue="id"/>
                                    </form:select>
                                </div>
                            </c:if>
                            <div class="text-center m-3">
                                <button type="submit" class="btn btn-success">Thêm</button> <button type="reset" class="btn btn-danger">Huỷ</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>



            <!-- The Modal -->
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title" id="modalTitle"></h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body" id="modalBody"></div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </div>

                    </div>
                </div>
            </div>

            <script>

              


                function checkEmailUnique(form) {
                    event.preventDefault()
                    url = "${apiUserURl}";
                    userEmail = $("#email").val();
                    userId = $("#id").val();
                    params = {
                        id: userId,
                        email: userEmail,
                    }
                    $.get(url, params, function (response) {
                        if (response === "OK") {
                            console.log("OK");
                            form.submit();
                            return true;
                        } else if (response === "Duplicated") {
                            showModalDialog("Warning", "There is another user using email" + userEmail + " please try another!!!!")
                            return false;
                        } else {
                            showModalDialog("Warning", "Unknow Error Please Try Again!!!")
                            return false;
                        }
                    }).fail(function () {
                        showModalDialog("Warning", "Error Accurr!!!!")
                    });
                    return false;
                }

                function showModalDialog(title, message) {
                    $("#modalTitle").text(title);
                    $("#modalBody").text(message);
                    $("#myModal").modal();
                }
            </script>
    </body>