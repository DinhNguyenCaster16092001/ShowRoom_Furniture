<%-- 
    Document   : login
    Created on : May 9, 2022, 7:06:29 PM
    Author     : Nguyen Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div class="span9">
            <ul class="breadcrumb">
                <li><a href="index.html">Home</a> <span class="divider">/</span></li>
                <li class="active">Login</li>
            </ul>
            <h3> LOGIN</h3>	
            <hr class="soft"/>
            <div class="well">
                <c:if test="${message != null}">
                    <p style="color: green">${message}</p>
                </c:if>
                <form class="form-horizontal" action="<c:url value="/login"/>" method="POST">
                    <div class="control-group">
                        <label class="control-label" for="inputEmail">Email</label>
                        <div class="controls">
                            <input class="span3" required  name="email" type="text" placeholder="Email">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">Password</label>
                        <div class="controls">
                            <input type="password" name="password" required class="span3" placeholder="Password">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <button type="submit" class="defaultBtn">Đăng Nhập</button> <a href="<c:url value="/register"/>">Chưa Có Tài Khoản?</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
