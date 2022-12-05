<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title><dec:title default="Admin - Trang Chủ"/></title>
        <!-- Custom fonts for this template-->
        <link href="<c:url value="/template/admin/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <script src="<c:url value="/template/admin/vendor/jquery/jquery.min.js"/>"></script>
        <!-- Custom styles for this template-->
        <link href="<c:url value="/template/admin/css/sb-admin-2.min.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body id="page-top">


        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <%@include file="../common/admin/sidebar.jsp" %>

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">
                    <!-- Navbar -->
                    <%@include file="../common/admin/navbar.jsp" %>

                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <dec:body></dec:body>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Bootstrap core JavaScript-->
            <script src="<c:url value="/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
        <!-- Core plugin JavaScript-->
        <script src="<c:url value="/template/admin/vendor/jquery-easing/jquery.easing.min.js"/>"></script>
        <!-- Custom scripts for all pages-->
        <script src="<c:url value="/template/admin/js/sb-admin-2.min.js"/>"></script>
        <script src="<c:url value="/template/admin/ckeditor/ckeditor.js"/>" charset="utf-8"></script>
        <!-- Page level plugins -->
        <script src="<c:url value="/template/admin/vendor/datatables/jquery.dataTables.min.js"/>"></script>
        <script src=" <c:url value="/template/admin/vendor/datatables/dataTables.bootstrap4.min.js"/>"></script>
    </body>
</html>
