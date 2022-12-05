<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar" class="span3">
    <div class="well well-small">
        <ul class="nav nav-list">

            <c:forEach items="${menuCategories}" var="item">
                <c:url value="/product" var="urlCategory">
                    <c:param name="page" value="1"/>
                    <c:param name="categorid" value="${item.id}"/>
                </c:url>
                <li><a href="${urlCategory}"><span class="icon-chevron-right"></span>${item.name}</a></li>
                    </c:forEach>
            <li style="border:0"> &nbsp;</li>
        </ul>
    </div>
    <a class="shopBtn btn-block" href="<c:url value="/product?page=1"/>">Upcoming products <br><small>Click to view</small></a>
    <br>
    <br>

</div>
