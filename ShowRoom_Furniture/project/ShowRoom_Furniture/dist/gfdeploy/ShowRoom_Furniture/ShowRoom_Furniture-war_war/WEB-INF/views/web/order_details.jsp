<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi Tiết Đơn Hàng</title>
    </head>
    <body>
        <div class="span9">
            <div class="well well-small">
                <h3>Chi Tiết Đơn Hàng</h3>
            </div>
            <table class="table table-bordered table-striped">
                <tr>
                    <th>Tên Sản Phẩm</th>
                    <th>Hình Ảnh</th>
                    <th>Số Lượng Đã Đặt</th>
                    <th>Đơn Giá</th>
                    <th>Tổng Giá</th>
                </tr>
                <c:forEach items="${orderDetails}" var="item">
                    <tr>
                        <td>${item.products.title}</td>
                        <td><img width="100px" height="100px" src="${item.products.image}"></td>
                        <td>${item.quantity}</td>
                        <td>${item.products.price} VNĐ</td>
                        <td>${item.quantity * item.products.price} VNĐ</td>
                    </tr> 
                </c:forEach>
            </table>
        </div>
    </body>
</html>
