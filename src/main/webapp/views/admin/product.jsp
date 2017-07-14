<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/26/2017
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 style="text-align: center"><spring:message code="label.Antivirus_Solutions"/></h1>

</div>

<sf:form modelAttribute="product" method="post" action="/product?${_csrf.parameterName}=${_csrf.token}"
         enctype="multipart/form-data">

    <input name="image" type="file" class="form-control"/>
    <input name="name" type="text" placeholder="name">
    <input name="description" type="text" placeholder="description">
    <input name="price" type="number" placeholder="price">
    <input name="quantityPC" type="number" placeholder="quantityPC">
    <input name="licenceDurationYears" type="number" placeholder="licenceDurationYears">

    <select multiple name="modulesIncludeds">
        <c:forEach var="modulesIncluded" items="${modulesIncludeds}">
            <option value="${modulesIncluded.id}">${modulesIncluded.name}</option>
        </c:forEach>
    </select>

    <select name="systemRequirements">
        <c:forEach var="systemRequirement" items="${systemRequirements}">
            <option value="${systemRequirement.id}">${systemRequirement.OSname}</option>
        </c:forEach>
    </select>

    <button><spring:message code="label.Buy_this"/></button>

</sf:form>

</div>
<table class="table table-hover">
    <thead>
    <tr>
        <th>name</th>
        <th>description</th>
        <th>price</th>
        <th>quantityPC</th>
        <th>licenceDurationYears</th>
        <th>Image</th>
        <%--<th>module</th>--%>
        <th>requirements</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>

            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.quantityPC}</td>
            <td>${product.licenceDurationYears}</td>
            <td><img src="${product.pathImage}" alt="" width="160px" height="100px"></td>
            <%--<td>--%>
                <%--<c:forEach var="modulesIncluded" items="${modulesIncludeds}">--%>
                    <%--${modulesIncluded.name}--%>
                <%--</c:forEach>--%>
            <%--</td>--%>

            <td>${product.systemRequirements.OSname}</td>

            <td><a href="/deleteProduct/${product.id}"><spring:message code="label.delete"/> </a></td>
            <td><a href="/updateProduct/${product.id}"><spring:message code="label.update"/> </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
