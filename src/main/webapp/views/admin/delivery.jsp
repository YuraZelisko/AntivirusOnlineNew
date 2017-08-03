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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h1 style="text-align: center"><spring:message code="label.Post_Service"/></h1>
<div style="text-align: center">
<sec:authorize access="hasRole('ROLE_ADMIN')">
<sf:form modelAttribute="delivery" method="post" action="/delivery?${_csrf.parameterName}=${_csrf.token}">
    ${deliveryNameException}
    ${deliveryCostException}
    ${deliveryDaysException}
    <sf:input path="deliveryServiceName" placeholder="Delivery Name"/>
    <sf:input type="number" value="1" path="cost" placeholder="cost"/>
    <sf:input type="number" value="1"  path="daysToArrive" placeholder="daysToArrive"/>
    <sf:label path="region"><spring:message code="label.region"/></sf:label>
    <sf:select path="region" items="${regions}" itemLabel="name" itemValue="id"/>


    <%--<select name="region">--%>
        <%--<c:forEach var="region" items="${regions}">--%>
            <%--<option value="${region.id}">${region.name}</option>--%>
        <%--</c:forEach>--%>
    <%--</select>--%>
    <button><spring:message code="label.Save"/></button>

</sf:form>
    </div>
</sec:authorize>
<div style="margin: 5px 170px">
<table class="table table-hover">
    <thead>
    <tr>
        <th><spring:message code="label.Post_Service_Name"/></th>
        <th><spring:message code="label.Cost"/></th>
        <th><spring:message code="label.Days_to_Arrive"/></th>
        <th><spring:message code="label.region"/></th>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <th><spring:message code="label.delete"/></th>
        <th><spring:message code="label.update"/></th>
        </sec:authorize>
    </tr>
    </thead>
    <tbody>
    <tr>

        <c:forEach var="delivery" items="${deliveries}">

        <td>${delivery.deliveryServiceName}</td>
        <td>${delivery.cost}</td>
        <td> ${delivery.daysToArrive}</td>
        <td> ${delivery.region.name}</td>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
        <td><a href="/deleteDelivery/${delivery.id}"><spring:message code="label.delete"/> </a></td>
        <td> <a href="/updateDelivery/${delivery.id}"><spring:message code="label.update"/> </a></td>
            </sec:authorize>
        <br></tr>
    </c:forEach>
    </tbody>
</table>
</div>