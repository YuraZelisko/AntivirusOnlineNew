<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="<c:url value="/js/search.js"/>"></script>
<link rel="stylesheet" href="/css/index.css">

<script type="text/javascript">
    $(document).ready(function () {
        $('.add-to-cart').on('click', function () {
            $('html, body').animate({
                'scrollTop': $(".cart_anchor").position().top
            });
            var itemIMG = $(this).parent().find('img').eq(0);
            flyToElement($(itemIMG), $('.cart_anchor'));
        });
    });

</script>

<div class="hero">
    <div style="text-align: center">
        <sec:authorize access="!isAuthenticated()">
        <h3 style="color: white"class="btn"><spring:message code="label.Hello_welcome"/> </h3><br>
            <a style="color: white" class="btn" href="/registration"><spring:message code="label.registration"/></a>
        </sec:authorize>
        <%--<img src="https://static3.esetstatic.com/fileadmin/Images/INT/styles/thank-you-for-downloading/v9/img/1/1024x768.jpg" height="300" width="300">--%>
    </div>

    <div style="margin-bottom: 10px; margin-top: 10px; width: 20%; float: right; padding-right: 10px">
        <div data-role="rangeslider">
            <p>
                <label for="amount"><spring:message code="label.Price_range"/></label>
                <input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
            </p>
            <label for="price-min"><spring:message code="label.min"/> </label>
            <input type="range" name="price-min" id="price-min" value="200" min="0" max="3000" onchange="changeLabel()"
                   oninput="searchPrices()">
            <label for="price-max"><spring:message code="label.max"/></label>
            <input type="range" name="price-max" id="price-max" value="2500" min="0" max="3000" onchange="changeLabel()"
                   oninput="searchPrices()">
        </div>
        <input style="margin-top: 5px" type="text" class="form-control" id="searchIn" oninput="searchInTable()"
               placeholder="<spring:message code="label.search"/>"/>
    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th><spring:message code="label.name"/> </th>
            <th><spring:message code="label.Description"/> </th>
            <th><spring:message code="label.Price"/> </th>
            <th><spring:message code="label.Quantity_PC"/> </th>
            <th><spring:message code="label.License"/> </th>
            <th><spring:message code="label.image"/> </th>
            <th><spring:message code="label.Modules_Included"/> </th>
            <th><spring:message code="label.system_requirement"/></th>
            <sec:authorize access="hasRole('ROLE_USER')">
            <th><spring:message code="label.BASKET"/> </th>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <th colspan="2">Action</th>
            </sec:authorize>
        </tr>
        </thead>
        <tbody style="border: solid">
        <c:forEach var="product" items="${products}">
            <tr style="border: solid">

                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.quantityPC}</td>
                <td>${product.licenceDurationYears}</td>
                <td><img src="${product.pathImage}" alt="" width="150px" height="150px"></td>
                <td>
                    <a href="/modules">
                    <c:forEach var="modulesIncluded" items="${product.modulesIncludeds}">
                        ${modulesIncluded.name}<br>
                    </c:forEach>
                    </a>
                </td>

                <td>${product.systemRequirements.OSname}<br>${product.systemRequirements.bitSystem}</td>

                <sec:authorize access="hasRole('ROLE_USER')">
                <td><a href="/addToBasket/${product.id}"><spring:message code="label.InBasket"/></a></td>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <td><a href="/deleteProduct/${product.id}"><spring:message code="label.delete"/> </a></td>
                    <td><a href="/updateProduct/${product.id}"><spring:message code="label.update"/> </a></td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
