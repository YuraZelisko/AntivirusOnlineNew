<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 31.05.2017
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="fixed-header">
    <div class="container">
        <nav>
    <div>
    <sec:authentication property="name"/>
    </div>
    <sec:authorize access="!isAuthenticated() || hasRole('ROLE_USER') ">
    <a href="/"><spring:message code="label.home"/> </a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
    <a href="/delivery"><spring:message code="label.delivery_type"/> </a>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated() ">
    <a href="/registration"><spring:message code="label.registration"/></a>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_USER')">

    <a href="/orders"><spring:message code="label.order_list"/> </a>

    <a href="/profile"><spring:message code="label.PROFILE"/></a>
    <a href="/basket"><spring:message code="label.BASKET"/></a>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="/product"><spring:message code="label.product_list"/> </a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated() ">
    <a href="/modules"><spring:message code="label.modules"/> </a>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
    <%--<a href="/opencity"><spring:message code="label.cities"/> </a>--%>
    <a href="/region"><spring:message code="label.region"/> </a>
    <a href="/userList"><spring:message code="label.User_List"/> </a>
    <a href="/systemRequirement"><spring:message code="label.system_requirement"/></a>
    </sec:authorize>
            <div class="dropdown" style="float: right">
            <a class="dropdown-toggle" data-toggle="dropdown" role="button"
               aria-haspopup="true" aria-expanded="false">
                <spring:message code="label.lang"/> <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu" style="margin: 1%; padding: 0%">
                    <li><a href="?lang=ua"><spring:message code="label.ua"/></a></li>
                    <li><a href="?lang=ru"><spring:message code="label.ru"/></a></li>
                    <li><a href="?lang=en"><spring:message code="label.en"/></a></li>
                </ul>
            </div>

    <sec:authorize access="isAuthenticated()">
   <form:form action="/logout">
        <button style="color: black"><spring:message code="label.logout"/></button>

    </form:form>
    </sec:authorize>
        </nav>
    </div>
</div>


