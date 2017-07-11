<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url var="saveUrl" value="/updateDelivery/${delivery.id}" />
<form:form modelAttribute="delivery" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="deliveryServiceName">Service Name</form:label></td>
            <td><form:input path="deliveryServiceName"/></td>
        </tr>
        <tr>
            <td><form:label path="cost">Price</form:label></td>
            <td><form:input path="cost"/></td>
        </tr>
        <tr>
            <td><form:label path="daysToArrive">Days to arrive</form:label></td>
            <td><form:input path="daysToArrive"/></td>
        </tr>

    </table>
    <input type="submit" value="Save" />
</form:form>