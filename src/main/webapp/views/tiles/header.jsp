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

<ul class="nav">
    <div style="color: white">
    <sec:authentication property="name"/>
    </div>
    <%--<sec:authorize access="!isAuthenticated()">--%>

    <li class="navItem"><a href="/"><spring:message code="label.home"/> </a></li>

    <li class="navItem"><a href="/registration"><spring:message code="label.registration"/></a></li>
    <%--</sec:authorize>--%>
    <%--<sec:authorize access="hasRole('ROLE_USER')">--%>
    <li class="navItem"><a href="/orders"><spring:message code="label.order_list"/> </a></li>
    <li class="navItem"><a href="/product"><spring:message code="label.product_list"/> </a></li>
    <li class="navItem"><a href="/delivery"><spring:message code="label.delivery_type"/> </a></li>
    <%--</sec:authorize>--%>
    <%--<sec:authorize access="hasRole('ROLE_ADMIN')">--%>
    <li class="navItem"><a href="/opencity"><spring:message code="label.cities"/> </a></li>
    <li class="navItem"><a href="/region"><spring:message code="label.region"/> </a></li>
    <li class="navItem"><a href="/modules"><spring:message code="label.modules"/> </a></li>
    <li class="navItem"><a href="/systemRequirement"><spring:message code="label.system_requirement"/> </a></li>
    <%--</sec:authorize>--%>
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" role="button"
               aria-haspopup="true" aria-expanded="false">
                <spring:message code="label.lang"/> <span class="caret"></span>
                <ul class="dropdown-menu">
                    <li><a href="?lang=ua">ua</a></li>
                    <li><a href="?lang=ru">ru</a></li>
                    <li><a href="?lang=en">en</a></li>
                </ul>
            </a>
        </li>

    <%--<sec:authorize access="isAuthenticated()">--%>
    <li class="navItem"><form:form action="/logout">
        <button><spring:message code="label.logout"/></button>

    </form:form> </li>
    <%--</sec:authorize>--%>
</ul>


