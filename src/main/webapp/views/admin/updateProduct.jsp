<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<c:url var="saveUrl" value="/updateProduct/${product.id}"/>
<form:form modelAttribute="product" method="POST" action="${saveUrl}?${_csrf.parameterName}=${_csrf.token}">
    <p style="color: red">${productNameException}</p>
    <p style="color: red">${productDescriptionException}</p>
    <p style="color: red">${productPriceException}</p>
    <p style="color: red">${productQuantityException}</p>
    <p style="color: red">${productLicenceException}</p>
    <table>
        <tr>
            <td><form:label path="pathImage">Image:</form:label></td>
            <td><img src="/${product.pathImage}" alt="" width="130px" height="100px"></td>
            <td><form:input type="hidden" path="pathImage"/></td>
        </tr>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true" /></td>
        </tr>
        <tr>
            <td><form:label path="name">Antivirus Name</form:label></td>
            <td><form:input path="name" id="productName"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td><form:label path="price">Price</form:label></td>
            <td><form:input path="price" id="productPrice" type="number"/></td>
        </tr>
        <tr>
            <td><form:label path="quantityPC">QuantityPC</form:label></td>
            <td><form:input path="quantityPC" id="productQuantity" type="number" /></td>
        </tr>
        <tr>
            <td><form:label path="licenceDurationYears">Duration</form:label></td>
            <td><form:input path="licenceDurationYears" id="productLicence" type="number"/></td>
        </tr>
        <td><form:label path="modulesIncludeds">Modules</form:label></td>
        <td>
            <select multiple name="modulesIncludeds">
                <c:forEach var="modulesIncluded" items="${modulesIncludeds}">
                    <option value="${modulesIncluded.id}">${modulesIncluded.name}</option>
                </c:forEach>
            </select>
        </td>
        </tr>
        <tr>
            <td><label>System Requirements</label></td>
            <td>
                <select name="systemRequirements">
                    <c:forEach var="systemRequirement" items="${systemRequirements}">
                        <option value="${systemRequirement.id}">${systemRequirement.OSname}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <input name="image" type="file" class="form-control"/>
        </tr>

    </table>
    <input type="submit" value="Save" id="saveProduct"/>
</form:form>
<%--<script src="<c:url value="/js/updateProductValid.js"/>"></script>--%>