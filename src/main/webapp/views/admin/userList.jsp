<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/24/2017
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>--%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
<sec:authorize access="!hasRole('ROLE_ADMIN')">
    <h2 style="text-align: center">Only Admin can use this link</h2>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<h1 style="text-align: center"><spring:message code="label.User_List"/> </h1>
<div>
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th><spring:message code="label.Username"/></th>
                <th><spring:message code="label.Email"/></th>
                <th><spring:message code="label.Role"/></th>
                <th colspan=1><spring:message code="label.Action"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${usersList.content}" var="user">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.role}" /></td>
                    <td><a href="/deleteUser/${user.id}"><spring:message code="label.delete"/> </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div style="display: flex; justify-content: center;text-align: center">

    <div class="col-md-12 col-xs-12">
        <div class="row">
            <div class="col-md-2 col-xs-6">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><spring:message code="label.Sort"/> <span
                            class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <custom:sort innerHtml="Name asc" paramValue="name"/>
                        <custom:sort innerHtml="Name desc" paramValue="name,desc"/>
                    </ul>
                </div>
            </div>
            <div class="col-md-8 col-xs-12 text-center">
                <custom:pageable page="${usersList}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
            </div>
            <div class="col-md-2 col-xs-6">
                <custom:size posibleSizes="1,2,5,10" size="${usersList.size}"/>
            </div>
        </div>
    </div>
</div>
</sec:authorize>