<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/26/2017
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 style="text-align: center"><spring:message code="label.Antivirus_Solutions"/></h1>

</div>

<sf:form modelAttribute="product" method="post" action="/product?${_csrf.parameterName}=${_csrf.token}"
         enctype="multipart/form-data">

    <input name="image" type="file" class="form-control"/>
    <input name="name" type="text" placeholder="name">
    <input name="price" type="number" placeholder="price">
    <input name="quantityPC" type="number" placeholder="quantityPC">
    <input name="licenceDurationYears" type="number" placeholder="licenceDurationYears">
    <%--${modulesIncludeds}--%>
    <%--modulesIncludeds--%>
    <%--<sf:select path="modulesIncluded" items="${modulesIncludeds}" itemLabel="name" itemValue="id"/>--%>
    <select multiple name="modulesIncludeds">
        <c:forEach var="mi" items="${modulesIncludeds}">
            <option value="${mi.id}">${mi.name}</option>
        </c:forEach>
    </select>

    <select name="systemRequirements" type="text" id="systemRequirement">
        <c:forEach var="systemRequirement" items="${systemRequirements}">
            <option value="${systemRequirement.id}">${systemRequirement.OSname}</option>
        </c:forEach>
    </select>
    <button><spring:message code="label.Buy_this"/></button>

</sf:form>

</div>
<table class="table table-hover">
    <thead>
    <tr>
        <th>name</th>
        <th>price</th>
        <th>quantityPC</th>
        <th>module</th>
        <th>requirements</th>
        <th>region</th>
    </tr>
    </thead>
    <tbody id="result">
    </tbody>
</table>

<%--<sf:form modelAttribute="product" action="/product?${_csrf.parameterName}=${_csrf.token}"--%>
<%--method="post" enctype="multipart/form-data">--%>
<%--<div style="display: flex; justify-content: space-around ">--%>

<%--<div class="form-group">--%>
<%--<sf:input path="name" type="text" class="form-control" id="exampleInputEmail3"--%>
<%--placeholder="drink name"/>--%>
<%--<input type="file" name="image" class="form-control">--%>
<%--</div>--%>
<%--<div class="form-group">--%>
<%--<sf:textarea path="recipe" type="text" class="form-control" id="exampleInputEmail3"--%>
<%--placeholder="recipe"/>--%>
<%--</div>--%>
<%--<div class="form-group">--%>
<%--<select multiple name="ingredientsIds" type="text" class="form-control" id="exampleInputEmail3">--%>
<%--<c:forEach var="ingredient" items="${ingredients}">--%>
<%--<option value="${ingredient.id}">${ingredient.ingredientName}</option>--%>
<%--</c:forEach>--%>
<%--</select>--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<button class="btn btn-default">save ingredient</button>--%>
<%--</div>--%>
<%--</div>--%>
<%--</sf:form>--%>
