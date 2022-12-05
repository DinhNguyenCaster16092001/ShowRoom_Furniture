<!-- 
Upper Header Section 
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="topNav">
        <div class="container">
            <div class="alignR">
                <div class="pull-left socialNw">
                    <a href="#"><span class="icon-twitter"></span></a>
                    <a href="#"><span class="icon-facebook"></span></a>
                    <a href="#"><span class="icon-youtube"></span></a>
                    <a href="#"><span class="icon-tumblr"></span></a>
                </div>
                <c:if test="${sessionScope.user == null}">
                    <a href="<c:url value="/login"/>"><span class="icon-user"></span>Login</a>
                    <a href="<c:url value="/register"/>"><span class="icon-edit"></span> Đăng Kí </a>
                </c:if>

                <c:if test="${sessionScope.user != null}">
                    <a href="<c:url value="/order/${sessionScope.user.id}"/>"><span class="icon-book"> Order History</span></a>
                </c:if>
                <a href="<c:url value="/cart"/>"><span class="icon icon-shopping-cart"></span>${sessionScope.cartNum} Item(s) - <span
                        class="badge badge-warning"><c:if test="${sessionScope.cartTotal != null}">${sessionScope.cartTotal} O VNĐ</c:if>
                        <c:if test="${sessionScope.cartTotal == null}">0 VNĐ</c:if>
                        </span></a>
                    <c:if test="${sessionScope.user != null}">
                    <a href="#"><span class="icon-user"> Hello, ${sessionScope.user.firstName} ${sessionScope.user.lastName}</span></a>
                    <a href="<c:url value="/logout"/>"><span class="icon-signout"> Logout</span></a>
                </c:if>

            </div>
        </div>
    </div>
</div>
<!--
Lower Header Section 
-->