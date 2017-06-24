<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <link rel="stylesheet" href="/css/registration.css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/js/registration.js"></script>


<div class="form-wrap">
    <div class="tabs">
        <h3 class="signup-tab"><a class="active" href="#signup-tab-content">Sign Up</a></h3>
        <h3 class="login-tab"><a href="#login-tab-content">Login</a></h3>
    </div><!--.tabs-->

    <div class="tabs-content">
        <div id="signup-tab-content" class="active">
            <form:form modelAttribute="user" action="/registration" method="post">
           <%--<form:form modelAttribute="user"--%>
            <form class="signup-form" action="/registration" method="post">
               <p style="color: mediumblue">${usernameException}</p>
                <p style="color: red">${useremailException}</p>
                <input name="name" type="text" class="input" id="user_name" autocomplete="off" placeholder="Username">
                <input name="email" type="email" class="input" id="user_email" autocomplete="off" placeholder="Email">
                <input name="password" type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">
                <input type="submit" class="button" value="Sign Up">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form><!--.login-form-->
            </form:form>
            <div class="help-text">
                <p>By signing up, you agree to our</p>
                <p><a href="#">Terms of service</a></p>
            </div><!--.help-text-->
        </div><!--.signup-tab-content-->

        <div id="login-tab-content">
            <form class="login-form" action="/login" method="post">
                <input name = "username" type="text" class="input" id="user_login" autocomplete="off" placeholder="Email or Username">
                <input name = "password" type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">
                <input type="checkbox" class="checkbox" id="remember_me">
                <label for="remember_me">Remember me</label>

                <input type="submit" class="button" value="Login">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form><!--.login-form-->
            <div class="help-text">
                <p><a href="#">Forget your password?</a></p>
            </div><!--.help-text-->
        </div><!--.login-tab-content-->
    </div><!--.tabs-content-->
</div><!--.form-wrap-->
