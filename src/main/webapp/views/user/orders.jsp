<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/26/2017
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>


<div>
   <sf:form modelAttribute="ord" method="post">
       <sf:input path="dateTime"/>


   </sf:form>


</div>
<div>

    <c:forEach var="orders" items= "${orderss}">
        ${orders.name}

        <a href="/deleteOrder/${orders.id}">delete</a><br>


    </c:forEach>


</div>
