<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd"
    <html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>TRANG CHỦ</title>
</head>
<body>
    <div class="span9">
        <div class="well np">
            <div id="myCarousel" class="carousel slide homCar">
                <div class="carousel-inner">
                    <div class="item">
                        <img style="width:1280px; height: 720px" src="https://d3nuqriibqh3vw.cloudfront.net/styles/aotw_detail_ir/s3/images/sofa.png?itok=qQi0RNvd"
                             alt="bootstrap ecommerce templates">
                        <div class="carousel-caption" class="img-responsive">
                            <p><span>Mang đến cho ngôi nhà của bạn một phong cách mới</span></p>
                        </div>
                    </div>
                    <div class="item">
                        <img style="width:1280px; height: 720px" class="img-responsive" src="https://image.made-in-china.com/202f0j00PeuYIcAGhWok/Modern-Design-Commercial-Melamine-Office-Conference-Table.webp"
                             alt="bootstrap ecommerce templates">
                        <div class="carousel-caption">
                            <h4>Uy Tín Chất Lượng Đi Đôi</h4>
                            <p><span>Tô điểm thế giới bên trong ngôi nhà của bạn</span></p>
                        </div>
                    </div>
                    <div class="item active">
                        <img style="width:1280px; height: 720px" src="https://www.migefurniture.com/wp-content/uploads/2019/05/banner-03.jpg"
                             alt="bootstrap ecommerce templates">
                        <div class="carousel-caption">
                            <h4>Show Room Furniture</h4>
                            <p><span>Mang đến cho ngôi nhà của bạn một phong cách mới</span></p>
                        </div>
                    </div>
                    <div class="item">
                        <img style="width:1280px; height: 720px" src="https://tribu.com/sites/default/files/styles/header_l/public/billboard/2_spanje_2021_amanu15900_0.jpg?itok=yH8Z6ydV&timestamp=1642674250"
                             alt="bootstrap templates">
                        <div class="carousel-caption">

                            <p><span>Đột phá ý tưởng – tạo nên đẳng cấp</span></p>
                        </div>
                    </div>
                </div>
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
            </div>
        </div>
        <!--
New Products
        -->
        <div class="well well-small">
            <h3>Sản Phẩm Mới</h3>
            <hr class="soften" />
            <div class="row-fluid">
                <div id="newProductCar" class="carousel slide">
                    <div class="carousel-inner">
                        <div class="item active">
                            <ul class="thumbnails">
                                <c:forEach items="${newProducts}" begin="0" end="3" var="item">
                                    <li>
                                        <div class="thumbnail">
                                            <a class="zoomTool" href="<c:url value="/product/details/${item.id}"/>"
                                               title="add to cart"><span class="icon-search"></span> XEM THÊM</a>
                                            <a href="#" class="tag"></a>
                                            <a href="<c:url value="/product/details/${item.id}"/>"><img src="${item.image}" style="width: 135px; height: 200px"
                                                                                alt="bootstrap-ring"></a>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="item">
                            <ul class="thumbnails">
                                <c:forEach items="${newProducts}" begin="4" end="8" var="item">
                                    <li class="span3">
                                        <div class="thumbnail">
                                            <a class="zoomTool" href="<c:url value="/product/details/${item.id}"/>"
                                               title="add to cart"><span class="icon-search"></span> XEM THÊM</a>
                                            <a href="<c:url value="/product/details/${item.id}"/>"><img src="${item.image}" style="width: 135px; height: 200px"
                                                                                alt="bootstrap-ring"></a>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <a class="left carousel-control" href="#newProductCar" data-slide="prev">&lsaquo;</a>
                    <a class="right carousel-control" href="#newProductCar" data-slide="next">&rsaquo;</a>
                </div>
            </div>
            <div class="row-fluid">

                <ul class="thumbnails">
                    <c:forEach items="${newProducts}" begin="0" end="2" var="item">
                        <li class="span4">
                            <div class="thumbnail">
                                <a class="zoomTool" href="<c:url value="/product/details/${item.id}"/>" title="add to cart"><span
                                        class="icon-search"></span> XEM THÊM</a>
                                <a href="<c:url value="/product/details/${item.id}"/>"><img src="${item.image}"  style="width: 200px; height: 200px" alt=""></a>
                                <div class="caption cntr">
                                    <p>${item.title}</p>
                                    <p><strong> ${item.price} VNĐ</strong></p>
                                    <h4><a class="shopBtn" href="<c:url value="/cart/add/${item.id}"/>" title="add to cart"> Add to cart </a></h4>
                                    <br class="clr">
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>


            </div>
        </div>
        <!--
Featured Products
        -->
        <div class="well well-small">
            <h3>Hãng Erado </h3>
            <hr class="soften" />
            <div class="row-fluid">
                <ul class="thumbnails">
                    <c:forEach items="${eradoProducts}" var="item">
                        <li class="span4">
                            <div class="thumbnail">
                                <a class="zoomTool" href="<c:url value="/product/details/${item.id}"/>" title="add to cart"><span
                                        class="icon-search"></span> XEM THÊM</a>
                                <a href="<c:url value="/product/details/${item.id}"/>"><img src="${item.image}"  style="width: 200px; height: 200px" alt=""></a>
                                <div class="caption cntr">
                                    <p>${item.title}</p>
                                    <p><strong> ${item.price} VNĐ</strong></p>
                                    <h4><a class="shopBtn" href="#" title="add to cart"> Thêm Vào Giỏ Hàng </a></h4>
                                    <br class="clr">
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="well well-small">
            <h3> Hãng Hoà Phát </h3>
            <hr class="soften" />
            <div class="row-fluid">
                <ul class="thumbnails">
                    <c:forEach items="${hoaPhatProducts}" var="item">
                        <li class="span4">
                            <div class="thumbnail">
                                <a class="zoomTool" href="<c:url value="/product/details/${item.id}"/>" title="add to cart"><span
                                        class="icon-search"></span> XEM THÊM</a>
                                <a href="<c:url value="/product/details/${item.id}"/>"><img src="${item.image}"  style="width: 200px; height: 200px" alt=""></a>
                                <div class="caption cntr">
                                    <p>${item.title}</p>
                                    <p><strong> ${item.price} VNĐ</strong></p>
                                    <h4><a class="shopBtn" href="<c:url value="/cart/add/${item.id}"/>" title="add to cart"> Thêm Vào Giỏ Hàng </a></h4>
                                    <br class="clr">
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <hr>
         <div class="well well-small">
            <h3> Hãng PVD Decor </h3>
            <hr class="soften" />
            <div class="row-fluid">
                <ul class="thumbnails">
                    <c:forEach items="${decorProducts}" var="item">
                        <li class="span4">
                            <div class="thumbnail">
                                <a class="zoomTool" href="product_details.html" title="add to cart"><span
                                        class="icon-search"></span> XEM THÊM</a>
                                <a href="product_details.html"><img src="${item.image}"  style="width: 200px; height: 200px" alt=""></a>
                                <div class="caption cntr">
                                    <p>${item.title}</p>
                                    <p><strong> ${item.price} VNĐ</strong></p>
                                    <h4><a class="shopBtn" href="#" title="add to cart"> Thêm Vào Giỏ Hàng </a></h4>
                                    <br class="clr">
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
