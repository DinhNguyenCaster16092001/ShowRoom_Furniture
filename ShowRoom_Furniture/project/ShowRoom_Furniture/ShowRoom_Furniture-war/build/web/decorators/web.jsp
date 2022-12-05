<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="utf-8">
        <title><dec:title default="Trang Chủ"/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Bootstrap styles -->
        <link href="<c:url value="/template/web/assets/css/bootstrap.css"/>" rel="stylesheet" />
        <!-- Customize styles -->
        <link href="<c:url value="/template/web/assets/css/style.css"/>" rel="stylesheet" />
        <!-- font awesome styles -->
        <link href="<c:url value="/template/web/assets/font-awesome/css/font-awesome.css"/>" rel="stylesheet">
        <!-- Favicons -->
        <link rel="shortcut icon" href="<c:url value="/template/web/assets/ico/favicon.ico"/>">
        <script src="<c:url value="/template/web/assets/js/jquery.js"/>"></script>
        <script src="<c:url value="/template/web/pagination/jquery.twbsPagination.js"/>"></script>
    </head>
    <body>

        <!--UPPER HEADER--->
        <%@include file="../common/web/upper_header.jsp" %>
        <!--UPPER HEADER--->

        <div class="container">
            <div id="gototop"> </div>
            <!--UPPER HEADER--->
            <%@include file="../common/web/low_header.jsp" %>
            <!--UPPER HEADER--->
            <!--UPPER HEADER--->
            <%@include file="../common/web/navbar.jsp" %>
            <!--UPPER HEADER--->
            <div class="row">
                <%@include file="../common/web/sidebar.jsp"%>
                <dec:body></dec:body>
                </div>
            </div>

            <!--FOOTER--->
        <%@include file="../common/web/footer.jsp" %>
        <!--FOOTER--->

        <a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/template/web/assets/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/template/web/assets/js/jquery.easing-1.3.min.js"/>"></script>
        <script src="<c:url value="/template/web/assets/js/jquery.scrollTo-1.4.3.1-min.js"/>"></script>
        <script src="<c:url value="/template/web/assets/js/shop.js"/>"></script>
    </body>