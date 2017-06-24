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

<h1 style="color: white">Region</h1>
<div>
    <sf:form modelAttribute="region" method="post" action="/region?${_csrf.parameterName}=${_csrf.token}"
             enctype="multipart/form-data">

        <sf:input path="name"/>
        <input name="image" type="file" class="form-control"/>
        <button>Save Region</button>

    </sf:form>
</div>
<div style="color: white">

    <c:forEach var="region" items="${regions}">
        ${region.name}
        <div>
        <img src="${region.pathImage}" alt="" width="20%" height="20%">
        </div>
        <a href="/deleteRegion/${region.id}">delete</a><br>
    </c:forEach>


</div>

