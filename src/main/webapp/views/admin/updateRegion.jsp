<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url var="saveUrl" value="/updateRegion/${region.id}?${_csrf.parameterName}=${_csrf.token}" />
<form:form modelAttribute="region" method="POST" action="${saveUrl}" enctype="multipart/form-data">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="name">Region Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td><form:label path="pathImage">Image:</form:label></td>
            <td><img src="/${region.pathImage}" alt="" width="130px" height="100px"></td>
            <td><form:input type="hidden" path="pathImage"/></td>
        </tr>
        <tr>
            <input name="image" type="file" class="form-control"/>
        </tr>

    </table>
    <input type="submit" value="Save" />
</form:form>