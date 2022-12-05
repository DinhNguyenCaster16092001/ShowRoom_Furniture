<%-- 
    Document   : product_details
    Created on : May 7, 2022, 6:51:37 PM
    Author     : Nguyen Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="span9">
            <ul class="breadcrumb">
                <li><a href="<c:url value="/"/>">Home</a> <span class="divider">/</span></li>
                <li><a href="<c:url value="/product?page=1"/>">Product</a> <span class="divider">/</span></li>
                <li class="active">Preview</li>
            </ul>	
            <div class="well well-small">
                <div class="row-fluid">
                    <div class="span5">
                        <a href="#"> <img src="${product.image}" alt="" style="width:100%;"></a>
                    </div>
                    <div class="span7">
                        <h3 style="color: red">${product.title}</h3>
                        <hr class="soft"/>
                        <label class="control-label">Đơn giá: <h3 style="color: green">${product.price} VNĐ</h3></label>
                        <form class="form-horizontal qtyFrm" action="<c:url value="/cart/add/${product.id}"/>">

                            <div class="control-group">
                                <label class="control-label">Thêm Vào Giỏ: </label>
                                <div class="controls">
                                    <input type="number"  name="qty" style="margin-left: -80px;" required class="span6" max="${product.quantity}" min="1" placeholder="Số lượng">
                                </div>
                            </div>


                            <h4 style="color: #003bb3">${product.quantity} sản phẩm ở trong kho</h4>
                            <p>${product.shortDescription}....<a href="#product_description">Xem Thêm</a>
                            <p>
                                <button type="submit" class="shopBtn"><span class=" icon-shopping-cart"></span> Thêm Vào Giỏ</button>
                        </form>
                    </div>
                </div>
                <hr class="softn clr"/>


                <ul id="productDetail" class="nav nav-tabs">
                    <li class="active"><a href="#home" data-toggle="tab">Thông Tin Chi Tiết</a></li>
                    <li class=""><a href="#profile" data-toggle="tab">Sản Phẩm Cùng Loại</a></li>
                </ul>
                <div id="myTabContent" class="tab-content tabWrapper">
                    <div class="tab-pane fade active in" id="home">
                        <h4>Product Information</h4>
                        <table class="table table-striped">
                            <tbody>
                                <tr class="techSpecRow"><td class="techSpecTD1">Loại Sản Phẩm</td><td class="techSpecTD2">${product.categoryName}</td></tr>
                                <tr class="techSpecRow"><td class="techSpecTD1">Chất Liệu</td><td class="techSpecTD2">${product.substance}</td></tr>
                                <tr class="techSpecRow"><td class="techSpecTD1">Hãng Sản Xuất</td><td class="techSpecTD2">${product.brandName}</td></tr>
                            </tbody>
                        </table>
                        <p id="product_description">${product.description}</p>
                    </div>
                    <div class="tab-pane fade" id="profile">
                        <c:forEach items="${productsRelative}" var="item">
                            <div class="row-fluid">	  
                                <div class="span2">
                                    <img src="${item.image}" alt="">
                                </div>
                                <div class="span6">
                                    <h5>${item.title}</h5>
                                    <p>
                                        ${item.shortDescription}
                                    </p>
                                </div>
                                <div class="span4 alignR">
                                    <form class="form-horizontal qtyFrm">
                                        <h3 style="color: green">${item.price} VND</h3>
                                        <div class="btn-group">
                                            <a href="<c:url value="/cart/add/${item.id}?qty=1"/>" class="defaultBtn"><span class=" icon-shopping-cart"></span>Thêm vào giỏ</a>
                                            <a href="<c:url value="/product/details/${item.id}"/>" class="shopBtn">Xem Thêm</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <hr class="soft">
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
