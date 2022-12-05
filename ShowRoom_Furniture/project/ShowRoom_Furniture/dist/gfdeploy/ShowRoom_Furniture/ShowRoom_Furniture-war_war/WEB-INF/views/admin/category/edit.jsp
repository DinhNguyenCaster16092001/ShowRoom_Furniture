<%-- 
    Document   : list
    Created on : Apr 21, 2022, 8:15:41 PM
    Author     : Nguyen Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<c:url var="addUrl" value='/admin/category/save'/>
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
            <h1 class="h3 mb-2 text-gray-800 text-uppercase">QUẢN LÍ DANH MỤC</h1>
            <a href="" class="mb-4 btn btn-primary"><span class="fas fa-arrow-alt-circle-left"></span> Trở Về Danh Sách Danh Mục</a>
            <br/>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <c:if test="${id != null || not empty id}">
                        <h6 class="m-0 font-weight-bold text-primary">Cập nhật danh mục</h6>
                    </c:if>
                    <c:if test="${id == null ||  empty id}">
                        <h6 class="m-0 font-weight-bold text-primary">Thêm mới danh mục</h6>
                    </c:if>
                </div>
                <div class="card-body">
                    <form:form action="${addUrl}" method="POST" modelAttribute="category">
                        <form:hidden path="id"/>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Tên danh mục</label>
                            <form:input path="name" class="form-control" id="exampleInputEmail1"  placeholder="Nhập tên danh mục"/>
                        </div>
                        <button type="submit" class="btn btn-success">Thêm</button> <button type="reset" class="btn btn-danger">Huỷ</button>
                    </form:form>
                </div>
            </div>
        </div>
        <!-- /.container-fluid -->

        <div id="deletemodel" class="modal fade">
            <div class="modal-dialog modal-confirm">
                <div class="modal-content">
                    <div class="modal-header">  </div>
                    <div class="modal-body">
                        <p>Do you really want to delete these record? This process cannot be undone.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info deleteCancel">Cancel</button>
                        <button type="button" class="btn btn-danger deleteConfirm">Delete</button>
                    </div>
                </div>
            </div>
    </body>
</html>
