<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url var="saveUrl" value="/updateSystemRequirement/${systemRequirement.id}" />
<form:form modelAttribute="systemRequirement" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="OSname">OS name</form:label></td>
            <td><form:input path="OSname"/></td>
        </tr>
        <tr>
            <td><form:label path="bitSystem">bitSystem</form:label></td>
            <td><form:input path="bitSystem"/></td>
        </tr>
        <tr>
            <td><form:label path="spaceAmount">spaceAmount</form:label></td>
            <td><form:input path="spaceAmount"/></td>
        </tr>
        <tr>
            <td><form:label path="OSlanguage">OSlanguage</form:label></td>
            <td><form:input path="OSlanguage"/></td>
        </tr>
        <tr>
            <td><form:label path="RAM">RAM</form:label></td>
            <td><form:input path="RAM"/></td>
        </tr>

    </table>
    <input type="submit" value="Save" />
</form:form>
