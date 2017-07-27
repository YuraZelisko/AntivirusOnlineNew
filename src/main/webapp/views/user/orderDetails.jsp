<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="container">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>№</th>
                <th>Time</th>
                <th>User name</th>
                <th>Products</th>
                <th>Total</th>
            </tr>
            </thead>
            <tbody>
                <tr  style="border: solid">
                    <td>${orders.id}</td>
                    <td>${orders.dateTime}</td>
                    <td>${orders.user.name}</td>
                    <td>
                        <c:forEach var="order" items="${orders.products}">
                            ${order.name}<br>
                        </c:forEach>
                    </td>
                    <td>${orders.totalPrice}</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>