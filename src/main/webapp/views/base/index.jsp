<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="/css/index.css">
<div class="hero">
    <div style="text-align: center">
        <h3 style="color: white"class="btn"><spring:message code="label.Hello_welcome"/> </h3><br>
        <sec:authorize access="!isAuthenticated()">
            <a style="color: white" class="btn" href="/registration"><spring:message code="label.registration"/></a>
        </sec:authorize>
        <%--<img src="https://static3.esetstatic.com/fileadmin/Images/INT/styles/thank-you-for-downloading/v9/img/1/1024x768.jpg" height="300" width="300">--%>
    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>name</th>
            <th>description</th>
            <th>price</th>
            <th>quantity PC</th>
            <th>License Duration</th>
            <th>Image</th>
            <th>module</th>
            <th>requirements</th>
            <sec:authorize access="hasRole('ROLE_USER')">
            <th>Basket</th>
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
                <td><img src="${product.pathImage}" alt="" width="160px" height="100px"></td>
                <td>
                    <c:forEach var="modulesIncluded" items="${product.modulesIncludeds}">
                        ${modulesIncluded.name}<br>
                    </c:forEach>
                </td>

                <td>${product.systemRequirements.OSname}</td>
                <sec:authorize access="hasRole('ROLE_USER')">
                <td><a href="/addToBasket/${product.id}">In Basket</a></td>
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




<%--https://codepen.io/ajaypatelaj/pen/zIBjJ--%>