<%-- 
    Document   : list
    Created on : Apr 21, 2022, 8:15:41 PM
    Author     : Nguyen Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<c:url var="addUrl" value='/admin/product/save'/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN - CHỈNH SỦA DANH MỤC</title>
    </head>
    <body>
        <!-- Begin Page Content -->
        <div class="container-fluid">

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800 text-uppercase">QUẢN LÍ SẢN PHẨM</h1>
            <a href="<c:url value="/admin/product"/>" class="mb-4 btn btn-primary"><span class="fas fa-arrow-alt-circle-left"></span> Trở Về Danh Sách Sản Phẩm</a>
            <br/>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <c:if test="${product.id != null}">
                        <h6 class="m-0 font-weight-bold text-primary">Cập nhật Sản Phẩm</h6>
                    </c:if>
                    <c:if test="${product.id == null}">
                        <h6 class="m-0 font-weight-bold text-primary">Thêm mới Sản Phẩm</h6>
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
                    <form:form action="${addUrl}" method="POST" modelAttribute="product">
                        <div class="row">
                            <form:hidden path="id"/>

                            <div class="form-group col-12">
                                <label >Tên Sản Phẩm</label>
                                <form:input path="title" class="form-control" required="required" maxlength="100" minlength="5"  placeholder="Nhập Tên Sản Phẩm"/>
                            </div>

                            <div class="form-group col-4">
                                <label >Đơn Giá</label>
                                <form:input path="price" class="form-control" required="required"  placeholder="Nhập đơn giá"/>

                            </div>

                            <div class="form-group col-4">
                                <label >Số Lượng</label>
                                <form:input type="number" required="required" path="quantity" class="form-control"/>
                            </div>

                            <div class="form-group col-12">
                                <label >Chất Liệu</label>
                                <form:select  path="substance" class="form-control">
                                    <form:option value="NONE"> --SELECT--</form:option>
                                    <form:option value="Nhựa"> NHỰA </form:option>
                                    <form:option value="Gỗ"> GỖ </form:option>
                                    <form:option value="Gốm"> GỐM SỨ </form:option>
                                    <form:option value="Vải"> VẢI </form:option>
                                    <form:option value="Nỉ"> NỈ </form:option>
                                    <form:option value="Bông"> BÔNG </form:option>
                                    <form:option value="Bông"> CAO SU </form:option>
                                    <form:option value="Da"> DA </form:option>
                                    <form:option value="Thuỷ Tinh"> THUỶ TINH </form:option>
                                </form:select>
                            </div>
                            <div class="form-group col-12">
                                <label >Thể Loại</label>
                                <form:select  path="categoryid" class="form-control">
                                    <form:options items="${categories}" itemLabel="name" itemValue="id"/>
                                </form:select>
                            </div>
                            <div class="form-group col-12">
                                <label >Hãng Sản Xuất</label>
                                <form:select  path="brandid" class="form-control">
                                    <form:options items="${brands}" itemLabel="name" itemValue="id"/>
                                </form:select>
                            </div>
                            <div class="form-group col-4">
                                <label >Hình Ảnh</label>
                                <input type="file" class="form-control" id="input_img" onchange="fileChange()" accept="image/*"/>
                                <form:hidden path="image"/>
                            </div
                         
                            <div class="form-group col-8">
                                <img src="${product.image}" class="img-fluid img-thumbnail" id="img" style="max-width: 150px; max-height: 150px">
                            <div class="form-group col-12">
                                <label >Mô Tả Ngắn</label>
                                <form:textarea path="shortDescription" maxlength="200"  class="form-control"/>
                            </div
                            <div class="form-group col-12">
                                <label >Mô Tả </label>
                                <form:textarea path="description" class="form-control"/>
                            </div>
                            <div class="text-center m-3">
                                <button type="submit" class="btn btn-success">Thêm</button> <button type="reset" class="btn btn-danger">Huỷ</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>


            <script>

                var editor = '';
                $(document).ready(function () {
                    editor = CKEDITOR.replace('description');
                });

                function fileChange() {
                    var file = document.getElementById('input_img');
                    var form = new FormData();
                    form.append("image", file.files[0])

                    var settings = {
                        "url": "https://api.imgbb.com/1/upload?key=64ce8ec45736c6f0961f04c071ea8ab2",
                        "method": "POST",
                        "timeout": 0,
                        "processData": false,
                        "mimeType": "multipart/form-data",
                        "contentType": false,
                        "data": form
                    };


                    $.ajax(settings).done(function (response) {
                        console.log(response);
                        var jx = JSON.parse(response);
                        console.log(jx.data.url);
                        $("#image").val(jx.data.url);
                    });
                }

                $("#input_img").change(function () {
                    var fileSize = this.files[0].size;
                    alert(fileSize);
                    if (fileSize > 1048576) {
                        this.setCustomValidity("The file too large you must choose file smaller 1MB");
                        this.reportValidity();
                    } else {
                        this.setCustomValidity("");
                        previewImageInput(this);
                    }

                });

                function previewImageInput(fileInput) {
                    var file = fileInput.files[0];
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $("#img").attr("src", e.target.result);
                    }
                    reader.readAsDataURL(file)
                }
            </script>
    </body>