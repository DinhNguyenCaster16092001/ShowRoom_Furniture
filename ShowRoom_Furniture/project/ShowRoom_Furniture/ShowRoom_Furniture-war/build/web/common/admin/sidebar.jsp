<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item">
        <a class="nav-link" href="index.html">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Bảng Tổng Kết</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Danh Mục
    </div>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/user/"/>">
            <i class="fas fa-solid fa-users"></i>
            <span>Tài Khoản</span></a>
    </li>
    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseProduct" aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-solid fa-star"></i>
            <span>Sản Phẩm</span>
        </a>
        <div id="collapseProduct" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Quản lý sản phẩm</h6>
                <a class="collapse-item" href="<c:url value="/admin/product/"/>">Danh sách sản phẩm</a>
                <a class="collapse-item" href="<c:url value="/admin/product/edit"/>">Thêm sản phẩm mới</a>
            </div>
        </div>
    </li>
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseCategory" aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-solid fa-book"></i>
            <span>Danh Mục</span>
        </a>
        <div id="collapseCategory" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Quản lý thể loại</h6>
                <a class="collapse-item" href="<c:url value="/admin/category"/>">Tất Cả Thể Loại</a>
                <a class="collapse-item" href="<c:url value="/admin/category/edit"/>">Thêm Thể Loại Mới</a>
            </div>
        </div>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/order"/>">
            <i class="fas fa-solid fa-box"></i>
            <span>Đơn Hàng</span></a>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>
