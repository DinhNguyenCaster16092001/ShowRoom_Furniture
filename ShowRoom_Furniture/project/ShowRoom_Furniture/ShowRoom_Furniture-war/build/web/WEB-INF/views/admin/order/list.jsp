<%-- 
    Document   : list
    Created on : Apr 21, 2022, 8:15:41 PM
    Author     : Nguyen Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN - QUẢN LÍ THỂ LOẠI</title>
    </head>
    <body>
        <!-- Begin Page Content -->
        <div class="container-fluid">

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800 text-uppercase">THỂ LOẠI</h1>
            <a href="<c:url  value='/admin'/>" class="mb-4 btn btn-primary"><span class="fas fa-arrow-alt-circle-left"></span> Trở Về Trang Chủ</a>
            <br/>
            <a href="<c:url  value='/admin/category/edit'/>" class="btn btn-success mb-3"><span class="fas fa-solid fa-plus"></span> Thêm Danh Mục Mới</a>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Danh Sách Thể Loại</h6>
                </div>
                <div class="card-body">

                    <c:if test="${message != null}">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            ${message}
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:if>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered"  id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>Mã</th>
                                    <th>Họ Tên</th>
                                    <th>Địa chỉ giao hàng</th>
                                    <th>SĐT</th>
                                    <th>Trị giá</th>
                                    <th>Ngày đặt hàng</th>
                                    <th>Trạng thái</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Mã Đơn Hàng</th>
                                    <th>Họ Tên</th>
                                    <th>Địa chỉ giao hàng</th>
                                    <th>SĐT</th>
                                    <th>Trị giá</th>
                                    <th>Ngày đặt hàng</th>
                                    <th>Trạng thái</th>
                                </tr>
                            </tfoot>
                            <tbody style="color: #000">
                                <c:forEach items="${orders}" var="item">
                                    <tr>
                                        <td  colspan="1">${item.id}</td>
                                        <td>${item.userid.firstName} ${item.userid.lastName}</td>
                                        <td>${item.shipAddress}</td>
                                        <td>${item.numberPhone}</td>
                                        <td>${item.total} VNĐ</td>
                                        <td>${item.orderDate} </td>
                                            <c:if test="${item.status == 1}">
                                                <td><a href="<c:url value="/admin/order/update/${item.id}"/>" title="Xác Nhận Đơn Hàng" class="text-warning">Chờ Xác Nhận</a>
                                            </c:if>
                                                    <c:if test="${item.status == 2}">
                                                <td><a  class="text-success">Đã Xác Nhận</a>
                                            </c:if>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>

    </body>
</html>
