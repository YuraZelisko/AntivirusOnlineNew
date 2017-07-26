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
<h1 style="text-align: center"><spring:message code="label.order_list"/></h1>
<%--<div>--%>
   <%--<sf:form modelAttribute="ord" method="post">--%>

       <%--<select name="product">--%>
           <%--<c:forEach items="${products}" var="product">--%>
               <%--<option value="${product.id}">--%>
                       <%--${product.name}--%>
               <%--</option>--%>
           <%--</c:forEach>--%>
       <%--</select>--%>

       <%--<select name="product">--%>
           <%--<c:forEach items="${products}" var="product">--%>
               <%--<option value="${product.id}">--%>
                       <%--${product.price}--%>
               <%--</option>--%>
           <%--</c:forEach>--%>
       <%--</select>--%>

       <%--<input type="text" placeholder="Insert quantity">--%>
       <%--<button>Save</button>--%>

   <%--</sf:form>--%>



<%--</div>--%>
<%--<div>--%>

    <%--<c:forEach var="orders" items= "${orderss}">--%>
        <%--${orders.quantity}--%>

        <%--<a href="/deleteOrder/${orders.id}"><spring:message code="label.delete"/> </a><br>--%>


    <%--</c:forEach>--%>


<%--</div>--%>
<div>
    <table class="table table-hover"  style="border: solid">
        <thead>
        <tr>
            <th>№</th>
            <th>Time</th>
            <th>Quantity</th>
            <th>User name</th>
            <th>Products</th>
            <th>Total</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="orders" items="${orderss}">
            <tr  style="border: solid">
                <td>${orders.id}</td>
                <td>${orders.dateTime}</td>
                <td>${orders.quantity}</td>
                <td>${orders.user.name}</td>
                <td>
                    <c:forEach var="order" items="${orders.products}">
                        ${order.name}<br>
                    </c:forEach>
                </td>
                <%--<td>${orders.user.name}</td>--%>
                <%--<td>${orders.products.name}</td>--%>
                <td>${orders.totalPrice}</td>
                <%--<td>${product.licenceDurationYears}</td>--%>
                <%--<td><img src="${product.pathImage}" alt="" width="160px" height="100px"></td>--%>
                <%--<td>${product.systemRequirements.OSname}</td>--%>
                <%--<td>--%>
                    <%--<select name="deliveryTypes">--%>
                        <%--<c:forEach items="${deliveryTypes}" var="deliveryType">--%>
                            <%--<option value="${deliveryType.id}">--%>
                                    <%--${deliveryType.deliveryServiceName}--%>
                            <%--</option>--%>
                        <%--</c:forEach>--%>
                    <%--</select>--%>
                <%--</td>--%>
                <td><a href="/addToBasket/${product.id}">In Basket</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

