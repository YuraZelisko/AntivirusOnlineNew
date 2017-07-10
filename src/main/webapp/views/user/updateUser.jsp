<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/24/2017
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="<c:url value="/css/registration.css"/>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/js/registration.js"/>"></script>

<div class="form-wrap">
    <div class="tabs-content">

        <div id="update-tab-content" class="active">
            <c:url var="save" value="/updateUser/${userAttribute.id}?${_csrf.parameterName}=${_csrf.token}"/>
            <form:form modelAttribute="userAttribute" class="signup-form" action="${save}" method="post">
                <form:input path="email" type="text" class="input" id="user_email" autocomplete="off" placeholder="UserEmail"/>
                <form:input path="name" type="text" class="input" id="user_name" autocomplete="off" placeholder="Username"/>
                <input type="password" name="newPassword" class="input" id="user_password">
                <input type="submit" class="button" value="Save">
            </form:form>
        </div>
    </div>
</div>