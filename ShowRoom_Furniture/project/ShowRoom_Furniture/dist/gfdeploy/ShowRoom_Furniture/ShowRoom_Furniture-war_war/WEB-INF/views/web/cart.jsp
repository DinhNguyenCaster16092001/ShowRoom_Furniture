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
                <li><a href="index.html">Home</a> <span class="divider">/</span></li>
                <li class="active">Giỏ Hàng</li>
            </ul>
            <div class="well well-small">
                <h1>GIỎ HÀNG <small class="pull-right"> ${sessionScope.cartNum} Sản Phẩm Đang Trong Giỏ Hàng</small></h1>
                <hr class="soften"/>	

                <c:if test="${sessionScope.cartNum > 0}">
                    <table class="table table-bordered table-condensed">
                        <thead>
                            <tr>
                                <th>Product</th>
                                <th>Description</th>
                                <th>Unit price</th>
                                <th colspan="2">Qty </th>
                                <th>Total</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="map" items="${sessionScope.cartItems}">
                                <tr>
                                    <td><img width="100" src="${map.value.productDTO.image}" alt=""/></td>
                                    <td>${map.value.productDTO.title}</td>
                                    <td>${map.value.productDTO.price} VNĐ</td>
                                    <td colspan="2">
                                        <form id="formCartUpdate_${map.value.productDTO.id}" action="<c:url value="/cart/update/${map.value.productDTO.id}"/>">
                                            <input class="span1" name="qty" style="max-width:34px" placeholder="${map.value.quantity}" min="1" max="${map.value.productDTO.quantity}"  size="${map.value.productDTO.quantity}" type="number">
                                            <button type="submit" style="margin-bottom: 10px;" class="btn btn-success"><span class="icon icon-pencil"></span></button>
                                        </form>
                                    </td>
                                    <td>${map.value.productDTO.price * map.value.quantity} VNĐ</td>
                                    <td><a href="<c:url value="/cart/remove/${map.value.productDTO.id}"/>" class="btn btn-danger icon icon-trash">Xoá</a></td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="6" class="alignR">Tổng Hoá Đơn:</td>
                                <td class="label label-primary"> ${sessionScope.cartTotal}.000 VND</td>
                            </tr>
                        </tbody>
                    </table><br/>
                    <table class="table table-bordered">
                        <tbody>
                            <tr><td>THÔNG TIN GIAO HÀNG</td></tr>
                            <tr> 
                                <td>
                                    <form method="POST" class="form-horizontal" action="<c:url value="/order/checkOut"/>">
                                        <div class="control-group">
                                            <label class="span2 control-label" for="inputEmail">Địa chỉ: </label>
                                            <div class="controls">
                                                <textarea name="shipAddress" required class="form-control"></textarea>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="span2 control-label" required minlenght="10" for="inputPassword">Số điện thoại: </label>
                                            <div class="controls">
                                                <input type="text" placeholder="Number Phone" name="numberPhone">
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <div class="controls">
                                                <button type="submit" class="shopBtn">ĐẶT HÀNG</button>
                                            </div>
                                        </div>
                                    </form> 
                                </td>
                            </tr>
                        </tbody>
                    </table>	
                </c:if>	
                <c:if test="${sessionScope.cartNum == 0}">
                    <p>BẠN CHƯA CÓ MÓN HÀNG NÀO TRONG GIỎ HÀNG</p>
                </c:if>
                <a href="<c:url value="/product?page=1"/>" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Tiếp tục mua hàng </a>
            </div>
    </body>
</html>
