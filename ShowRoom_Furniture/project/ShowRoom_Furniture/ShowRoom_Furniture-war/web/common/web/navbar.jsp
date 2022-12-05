<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>
<div class="navbar">
    <div class="navbar-inner">
        <div class="container">
            <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <div class="nav-collapse">
                <ul class="nav">
                    <li ><a href="<c:url value="/"/>">Home </a></li>
                    <li class=""><a href="<c:url value="/product?page=1"/>">Sản Phẩm</a></li>
                    <li class=""><a href="<c:url value="/about"/>">About Us</a></li>
                </ul>
            </div>
            <form action="<c:url value="/product"/>" class="navbar-search pull-right">
                <input type="hidden" name="page" value="1">
                <input type="text"  name="title" placeholder="Search" class="search-query span2">
                <input type="submit" style="margin-top: -1px" class="btn btn-success" value="Tìm Kiếm"/>
            </form>
        </div>
    </div>
</div>
<!--    
