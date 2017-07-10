<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/30/2017
  Time: 8:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>--%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>




<h1><spring:message code="label.Modules_Included"/></h1>
<div>
    <sf:form modelAttribute="module" method="post" action="/modules">
        <sf:input path="name"/>
        <sf:input path="description"/>
        <button><spring:message code="label.save_new_module"/> </button>


    </sf:form>
</div>
<div>

    <c:forEach var="module" items="${modules.content}">
    <%--<c:forEach var="module" items= "${modules}" >--%>
        ${module.name}<br>
        ${module.description}

        <a href="/deleteModule/${module.id}"><spring:message code="label.delete"/> </a>
        <a href="/updateModule/${module.id}"><spring:message code="label.update"/> </a><br>
    </c:forEach>
</div>
<div style="display: flex; justify-content: center;text-align: center">

    <div class="col-md-12 col-xs-12">
        <div class="row">
            <div class="col-md-2 col-xs-6">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><spring:message code="label.Sort"/> <span
                            class="caret"></span>

                    <ul class="dropdown-menu">
                        <custom:sort innerHtml="Name asc" paramValue="name"/>
                        <custom:sort innerHtml="Name desc" paramValue="name,desc"/>
                    </ul>
                </div>
            </div>
            <div class="col-md-6 col-xs-12 text-center">
                <custom:pageable page="${modules}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
            </div>
            <div class="col-md-2 col-xs-6">
                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><spring:message code="label.Size"/> <span
                        class="caret"></span>
                 <custom:size posibleSizes="1,2,5,10" size="${modules.size}"/>
                </button>
            </div>
        </div>
    </div>
</div>