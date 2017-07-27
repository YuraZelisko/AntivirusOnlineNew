<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <c:if test="${userBasket.products.size() == 0}">
                Basket is empty!!!
            </c:if>
            <c:if test="${userBasket.products.size() != 0}">
                <th><spring:message code="label.name"/></th>
                <th><spring:message code="label.Description"/></th>
                <th><spring:message code="label.Price"/></th>
                <th><spring:message code="label.delivery_type"/></th>
                <th><spring:message code="label.delete"/></th>
            </c:if>
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
                    <td><input style="width: 40px" name="productQuantity" type="number" value="1" min="1"></td>
                    <td><a href="/deleteFromBasket/${userBasket.id}/${product.id}"><spring:message
                            code="label.delete"/> </a></td>

                </tr>
            </c:forEach>
            <c:if test="${userBasket.products.size() != 0}">
                <div style="text-align: center" class="btn-btn-default">
                    <button class="btn btn-default">Buy</button>
                </div>
            </c:if>
        </form:form>
        </tbody>
    </table>
</div>
<div style="text-align: center">
    <img src="http://inventionland.com/wp-content/uploads/2015/09/National_Thank_You_Day.png" alt="" height="250px">
</div>
