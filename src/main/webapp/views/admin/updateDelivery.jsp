<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url var="saveUrl" value="/updateDelivery/${delivery.id}" />
<form:form modelAttribute="delivery" method="POST" action="${saveUrl}">
    ${deliveryNameException}
    ${deliveryCostException}
    ${deliveryDaysException}
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true"/></td>

        </tr>

        <tr>
            <td><form:label path="deliveryServiceName">Service Name</form:label></td>
            <td><form:input path="deliveryServiceName" /></td>
        </tr>
        <tr>
            <%--<td><label>Cost</label></td>--%>
            <%--<td><input name="cost" required="required"></td>--%>
            <td><form:label path="cost">Cost</form:label></td>
            <td><form:input path="cost" type="number"/></td>
        </tr>
        <tr>
            <td><form:label path="daysToArrive">Days</form:label></td>
            <td><form:input path="daysToArrive" type="number"/></td>
        </tr>
        <tr>
            <td><label name="region">Region</label></td>
            <td>
           <select name="regionId">
                <c:forEach var="reg" items="${regions}">
                    <option value="${reg.id}">${reg.name}</option>
                </c:forEach>
            </select>
            </td>
        </tr>
     </table>
    <input type="submit" value="Save" />
</form:form>