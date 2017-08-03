<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url var="saveUrl" value="/updateSystemRequirement/${systemRequirement.id}" />
<form:form modelAttribute="systemRequirement" method="POST" action="${saveUrl}">
    <p style="color: mediumblue">${SRNameException}</p>
    <p style="color: red">${SRBitException}</p>
    <p style="color: red">${SRAmountException}</p>
    <p style="color: red">${SRRAMException}</p>
    <p style="color: red">${SRLangException}</p>
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="OSname">OS name</form:label></td>
            <td><form:input path="OSname"/></td>
        </tr>
        <tr>
            <td><form:label path="bitSystem">Bit System</form:label></td>
            <td><label for="bit32">x32</label>
            <input type="radio" name="bitSystem" id="bit32" value="x32" checked="checked"/>
            <label for="bit64">x64</label>
            <input type="radio" name="bitSystem" id="bit64" value="x64"/></td>
        </tr>
        <tr>
            <td><form:label path="spaceAmount">spaceAmount</form:label></td>
            <td><form:input path="spaceAmount" type="number" /></td>
        </tr>
        <tr>
            <td><form:label path="OSlanguage">OSlanguage</form:label></td>
            <td><form:input path="OSlanguage"/></td>
        </tr>
        <tr>
            <td><form:label path="RAM">RAM</form:label></td>
            <td><form:input path="RAM" type="number" /></td>
        </tr>

    </table>
    <input type="submit" value="Save" />
</form:form>
