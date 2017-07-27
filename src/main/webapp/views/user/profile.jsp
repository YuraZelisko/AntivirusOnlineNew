<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/24/2017
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div>
    <div class="container">

        <table class="table table-hover">
            <thead>
            <tr>
                <th><spring:message code="label.name"/></th>
                <th><spring:message code="label.Email"/></th>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                <th><spring:message code="label.Password"/></th>
                </sec:authorize>
                <th><spring:message code="label.Role"/></th>
                <th><spring:message code="label.orders"/></th>
                <th><spring:message code="label.update"/></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.email}" /></td>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td><c:out value="${user.password}" /></td>
                </sec:authorize>
                <td><c:out value="${user.role}" /></td>
                <td>
                    <c:forEach items="${user.orders}" var="order">
                        <a href="/orderDetails/${order.id}">2017№205${order.id}</a><br />
                    </c:forEach>
                </td>
                <td><a href="/updateUser/${user.id}"><spring:message code="label.update"/> </a></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>