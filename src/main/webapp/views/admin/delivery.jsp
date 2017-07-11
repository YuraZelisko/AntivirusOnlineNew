<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/26/2017
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 style="text-align: center"><spring:message code="label.Post_Service"/></h1>

<sf:form modelAttribute="delivery" method="post" action="/delivery">
    <sf:input path="deliveryServiceName"/>
    <sf:input path="cost"/>
    <sf:input path="daysToArrive"/>

    <sf:select path="region" items="${regions}" itemLabel="name" itemValue="id"/>


    <%--<select name="region">--%>
        <%--<c:forEach var="region" items="${regions}">--%>
            <%--<option value="${region.id}">${region.name}</option>--%>
        <%--</c:forEach>--%>
    <%--</select>--%>
    <button>save</button>

</sf:form>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Delivery Service Name </th>
        <th>Cost</th>
        <th>Days To Arrive</th>
        <th>Region</th>
        <th><spring:message code="label.delete"/></th>
        <th><spring:message code="label.update"/></th>
    </tr>
    </thead>
    <tbody>
    <tr>

        <c:forEach var="delivery" items="${deliveries}">

        <td>${delivery.deliveryServiceName}</td>
        <td>${delivery.cost}</td>
        <td> ${delivery.daysToArrive}</td>
        <td> ${region.name}</td>
        <td><a href="/deleteDelivery/${delivery.id}"><spring:message code="label.delete"/> </a></td>
        <td> <a href="/updateDelivery/${delivery.id}"><spring:message code="label.update"/> </a></td>
        <br></tr>
    </c:forEach>
    </tbody>
</table>