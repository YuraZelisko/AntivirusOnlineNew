<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/29/2017
  Time: 8:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 style="text-align: center"><spring:message code="label.region"/></h1>
<div>
    <sf:form modelAttribute="region" method="post" action="/region?${_csrf.parameterName}=${_csrf.token}"
             enctype="multipart/form-data">

        <sf:input path="name" placeholder="Name"/>
        <input name="image" type="file" class="form-control"/>
        <button><spring:message code="label.save_region"/> </button>

    </sf:form>
</div>
<div style="margin: 5px 120px" >

    <table class="table table-hover">
        <thead>
        <tr>

            <th>Region</th>
            <th>Image</th>
            <th><spring:message code="label.delete"/></th>
            <th><spring:message code="label.update"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>

            <c:forEach var="region" items="${regions}">

            <td> ${region.name}</td>
            <td><img src="${region.pathImage}" alt="" width="160px" height="100px"></td>
            <td><a href="/deleteRegion/${region.id}"><spring:message code="label.delete"/> </a></td>
            <td> <a href="/updateRegion/${region.id}"><spring:message code="label.update"/> </a></td>
            <br></tr>
        </c:forEach>
        </tbody>
    </table>
</div>

