<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="container">
<table class="table table-hover">
    <thead>
    <tr>
        <th>name</th>
        <th>description</th>
        <th>price</th>
        <th>Delivery</th>
        <th>quantity</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody style="border: solid">
    <form:form action="/buy" method="post">
    <c:forEach var="product" items="${userBasket.products}">
        <tr style="border: solid">

            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>
                <select name="deliveryTypes">
                    <c:forEach items="${deliveryTypes}" var="deliveryType">
                        <option value="${deliveryType.id}">
                                ${deliveryType.deliveryServiceName}
                        </option>
                    </c:forEach>
                </select>
            </td>
            <td><input style="width: 40px" type="number"></td>
            <td><a href="/deleteFromBasket/${userBasket.id}/${product.id}"><spring:message code="label.delete"/> </a></td>

        </tr>
    </c:forEach>
    </form:form>
    </tbody>
</table>
</div>
<div style="text-align: center" class="btn-btn-default"><button class="btn btn-default">Buy</button></div>
<div style="text-align: center">
    <img src="http://inventionland.com/wp-content/uploads/2015/09/National_Thank_You_Day.png" alt="" height="250px">
</div>
