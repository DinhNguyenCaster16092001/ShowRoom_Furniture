<%-- 
    Document   : list_order
    Created on : May 9, 2022, 10:17:39 PM
    Author     : Nguyen Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Order</title>
        <style>

        </style>
    </head>
    <body>
        <div class="span9">
            <div class="well well-small">
                <h3>History Order</h3>
            </div>
            <c:if test="${orders.size() > 0}">
                <table class="table table-bordered table-striped">
                    <tr>
                        <th>Mã Đơn Hàng</th>
                        <th>Trị Giá</th>
                        <th>Ngày Đặt Hàng</th>
                        <th>Địa Chỉ Đặt Hàng</th>
                        <th>Trạng Thái</th>
                        <th>Liên Hệ</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${orders}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td style="color: green">${item.total} VNĐ</td>
                            <td>${item.orderDate}</td>
                            <td>${item.shipAddress}</td>
                            <c:if test="${item.status == 1}">
                                <td style="color: orange">Đang Chờ Xác Nhận</td>
                            </c:if>
                            <c:if test="${item.status == 2}">
                                <td style="color: green">Đã Xác Nhận Đơn Hàng</td>
                            </c:if>
                            <td>${item.numberPhone}</td>
                            <td><a href="<c:url value="/order/detail/${item.id}"/>">Xem Chi Tiết</a></td>
                        </tr> 
                    </c:forEach>
                </table>
            </c:if>
            
            <c:if test="${orders.size() == 0}">
                <h2>Bạn Ko Có Đơn Hàng Nào</h2>
            </c:if>
        </div>
    </body>
</html>
