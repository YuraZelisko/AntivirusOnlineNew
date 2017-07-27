<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h1 style="text-align: center"><spring:message code="label.order_list"/></h1>

<div>
    <table class="table table-hover"  style="border: solid">
        <thead>
        <tr>
            <th>№</th>
            <th><spring:message code="label.time"/></th>
            <th><spring:message code="label.Username"/></th>
            <th><spring:message code="label.product"/></th>
            <th><spring:message code="label.total"/></th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="orders" items="${ordersAll}">
            <tr  style="border: solid">
                <td>${orders.id}</td>
                <td>${orders.dateTime}</td>
                <td>${orders.user.name}</td>
                <td>
                    <c:forEach var="order" items="${orders.products}">
                        ${order.name}<br>
                    </c:forEach>
                </td>
                <td>${orders.totalPrice}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

