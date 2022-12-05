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
        <title>ADMIN - QUẢN LÍ SẢN PHẨM</title>
    </head>
    <body>
        <!-- Begin Page Content -->
        <div class="container-fluid">

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800 text-uppercase">SẢN PHẨM</h1>
            <a href="<c:url  value='/admin'/>" class="mb-4 btn btn-primary"><span class="fas fa-arrow-alt-circle-left"></span> Trở Về Trang Chủ</a>
            <br/>
            <a href="<c:url  value='/admin/product/edit'/>" class="btn btn-success mb-3"><span class="fas fa-solid fa-plus"></span> Thêm Danh Mục Mới</a>
            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Danh Sách Sản Phẩm</h6>
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

                                    <th>Id</th>
                                    <th>Tên Sản Phẩm</th>
                                    <th>Hình Ảnh</th>
                                    <th>Đơn Giá (VNĐ)</th>
                                    <th>Số Lượng</th>
                                    <th>Chất Liệu</th>
                                    <th>Thao Tác</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>

                                    <th>Id</th>
                                    <th>Tên Sản Phẩm</th>
                                    <th>Đơn Giá (VNĐ)</th>
                                    <th>Số Lượng</th>
                                    <th>Chất Liệu</th>
                                    <th>Thao Tác</th>
                                </tr>
                            </tfoot>
                            <tbody style="color: #000">
                                <c:forEach items="${products}" var="item">
                                    <tr class="somerow">
                                        <td  colspan="1">${item.id}</td>

                                        <td>${item.title}</td>
                                        <td><img src="${item.image}" class="img-fluid img-thumbnail" width="150px" height="100px"></td>
                                        <td class="fieldPrice">${item.price}</td>
                                        <td>${item.quantity}</td>
                                        <td>${item.substance}</td>
                                        <c:url var="updateLink" value='/admin/product/edit'>
                                            <c:param name="id" value="${item.id}"/>
                                        </c:url>
                                        <th><a href="${updateLink}" class="btn btn-primary"><span class="fas fa-pen-alt" title="Edit"></span></a>
                                            <button id="${item.id}" class="btn btn-danger btn-delete"><span class="fas fa-trash-alt" title="Delete"></span></button></th>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container-fluid -->
        <div id="deletemodel" class="modal fade">
            <div class="modal-dialog modal-confirm">
                <div class="modal-content">
                    <div class="modal-header">  </div>
                    <div class="modal-body">
                        <p>Bạn có muốn xoá mẫu tin này ??? Tiến trình này không thể hoàn tác</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" id="deletemodel" class="btn btn-danger deleteConfirm">Delete</button>
                    </div>
                </div>
            </div>
            <script>
                $(document).ready(function () {
                    $('#dataTable').DataTable({
                        "order": [[0, "desc"]]
                    });
                    $(".somerow .fieldPrice").each(function () {
                        var value = $(this).text();

                        $(this).html(new Intl.NumberFormat('en-IN', {minimumFractionDigits: 3, maximumFractionDigits: 3}).format(value));
                    });
                });

                $(".btn-delete").on("click", function () {
                    var element = $(this);
                    var del_id = element.attr("id");
                    $("#deletemodel").modal('show');
                    $('#deletemodel').on('click', function () {
                        var info = del_id;
                        location.href = "<c:url  value='/admin/product/delete/'/>" + info
                    })
                });


            </script>
    </body>
</html>
