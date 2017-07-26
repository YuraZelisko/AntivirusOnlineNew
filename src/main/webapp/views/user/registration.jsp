<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="stylesheet" href="/css/registration.css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/js/registration.js"></script>


<div class="form-wrap">
    <div class="tabs">
        <h3 class="signup-tab"><a class="active" href="#signup-tab-content"><spring:message code="label.Sign_Up"/> </a></h3>
        <h3 class="login-tab"><a href="#login-tab-content"><spring:message code="label.Login"/> </a></h3>
    </div><!--.tabs-->

    <div class="tabs-content">
        <div id="signup-tab-content" class="active">
            <form:form modelAttribute="user" action="/registration" method="post">

            <form class="signup-form" action="/registration" method="post">
               <p style="color: mediumblue">${usernameException}</p>
                <p style="color: red">${useremailException}</p>
                <input name="name" type="text" class="input" id="user_name" autocomplete="off" placeholder="<spring:message code="label.Username"/> ">
                <input name="email" type="text" class="input" id="user_email" autocomplete="off" placeholder="<spring:message code="label.Email"/> ">
                <input name="password" type="password" class="input" id="user_pass" autocomplete="off" placeholder="<spring:message code="label.Password"/> ">
                <input type="submit" class="button" value="<spring:message code="label.Sign_Up"/> ">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form><!--.login-form-->
            </form:form>

        </div><!--.signup-tab-content-->

        <div id="login-tab-content">
            <form class="login-form" action="/login" method="post">
                <p style="color: mediumblue">${exception}</p>
                <%--<p style="color: red">${loginException}</p>--%>
                <input name = "username" type="text" class="input" id="user_login" autocomplete="off" placeholder="<spring:message code="label.Email_or_Username"/>">
                <input name = "password" type="password" class="input" id="user_pass" autocomplete="off" placeholder="<spring:message code="label.Password"/>">
                <input type="submit" class="button" value="<spring:message code="label.Login"/> ">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form><!--.login-form-->
            <div class="help-text">
            </div><!--.help-text-->
        </div><!--.login-tab-content-->
    </div><!--.tabs-content-->
</div><!--.form-wrap-->
