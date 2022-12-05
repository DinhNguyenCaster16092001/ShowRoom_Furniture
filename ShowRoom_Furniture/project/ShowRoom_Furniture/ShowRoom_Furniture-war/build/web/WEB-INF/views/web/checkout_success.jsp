<%-- 
    Document   : checkout_success
    Created on : May 9, 2022, 9:57:02 PM
    Author     : Nguyen Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ĐẶT HÀNG THÀNH CÔNG</title>
    </head>
    <body>
        <div class="span9">
            <div class="card">
                <h1>ĐẶT HÀNG THÀNH CÔNG</h1> 
                <p>Chúng tôi đã nhận đc đơn hàng của bạn<br/> Chúng tôi sẽ phản hồi trong thời gian sớm nhất</p>
                <a href="<c:url value="/order/${user.id}"/>">Xem Lịch Sử Đặt Hàng</a>
            </div>
        </div>
    </body>
</html>
