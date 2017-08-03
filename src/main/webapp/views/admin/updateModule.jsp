<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/10/2017
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url var="saveUrl" value="/updateModule/${module.id}" />
<form:form modelAttribute="module" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><span contenteditable="true" style="display: inline-block; border: solid 1px black; min-width: 50px; max-width: 200px"><form:input  height="150px" width="450px" path="description"/></span></td>

            <%--<td><input name="description" type="text" height=height*2 width=width*5 ></td>--%>
        </tr>

    </table>
    <input type="submit" value="Save" />
</form:form>