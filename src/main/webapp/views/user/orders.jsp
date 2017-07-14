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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1><spring:message code="label.order_list"/></h1>
<div>
   <sf:form modelAttribute="ord" method="post">

       <select name="product">
           <c:forEach items="${products}" var="product">
               <option value="${product.id}">
                       ${product.name}
               </option>
           </c:forEach>
       </select>

       <select name="product">
           <c:forEach items="${products}" var="product">
               <option value="${product.id}">
                       ${product.price}
               </option>
           </c:forEach>
       </select>

       <input type="text" placeholder="Insert quantity">
       <button>Save</button>

   </sf:form>



</div>
<div>

    <c:forEach var="orders" items= "${orderss}">
        ${orders.name}

        <a href="/deleteOrder/${orders.id}"><spring:message code="label.delete"/> </a><br>


    </c:forEach>


</div>
