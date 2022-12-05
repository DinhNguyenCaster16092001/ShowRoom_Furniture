<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<div class="span9">
    <div class="well well-small">
        <h3>Sản Phẩm Của Chúng Tôi </h3>
    </div>
    <c:if test="${products.size() > 0}">
        <form action="<c:url value='/product'/>" id="formSubmit" method="get">
            <ul class="thumbnails">
                <c:forEach items="${products}" var="item">
                    <li class="span3">
                        <div class="thumbnail">
                            <a href="<c:url value="/product/details/${item.id}"/>" class="overlay"></a>
                            <a class="zoomTool" href="<c:url value="/product/details/${item.id}"/>" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                            <a href="<c:url value="/product/details/${item.id}"/>"><img  class="img-thumbnail img-fluid"src="${item.image}" style="width: 200px; height: 150px"  alt=""></a>
                            <div class="caption cntr">
                                <p>${item.title}</p>
                                <p style="color: #ff253a"><strong> ${item.price} VNĐ</strong></p>
                                <h4><a class="shopBtn" href="<c:url value="/cart/add/${item.id}"/>" title=""> THÊM VÀO GIỎ HÀNG </a></h4
                                <br class="clr">
                            </div>
                        </div>
                    </li>
                </c:forEach>

            </ul>
            <div class="container">
                <nav aria-label="Page navigation">
                    <div class="pagination" id="pagination"></div>
                    <input type="hidden" value="" id="page" name="page"/>
                    <c:if test="${categorid != null || not empty categorid}">
                        <input type="hidden" value="${categorid}" id="categorid" name="categorid"/>
                    </c:if>
                    <c:if test="${title != null || not empty title}">
                        <input type="hidden" value="${title}" id="title" name="title"/>
                    </c:if>
                </nav>
            </div>
        </form>
    </c:if>
    <c:if test="${products.size() == 0}">
        <h3>Không tìm thấy vật phẩm nào</h3>
    </c:if>
</div>

<script type="text/javascript">
    var totalPages = ${totalPages};
    var currentPage = ${page};
    var limit = 6;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#page').val(page);
                    $('#categorid').val();
                    $('#title').val();
                    $('#formSubmit').submit();
                }
            }
        });
    });
</script>