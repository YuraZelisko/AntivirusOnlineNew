<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/31/2017
  Time: 6:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1><spring:message code="label.system_requirement"/></h1>

<sf:form modelAttribute="systemRequirement" method="post" action="/systemRequirement">
    <sf:input path="OSname"/>
    <%--<sf:input path="bitSystem"/>--%>

    <label for="bit32">x32</label>
    <input type="radio" name="bitSystem" id="bit32" value="false" />
    <label for="bit64">x64</label>
    <input type="radio" name="bitSystem" id="bit64" value="true" />

    <sf:input path="spaceAmount"/>
    <sf:input path="RAM"/>
    <sf:input path="OSlanguage"/>
    <button><spring:message code="label.save_requirements"/></button>

</sf:form>
<table class="table table-hover">
<thead>
<tr>
    <th>OS name </th>
    <th>Bit of system</th>
    <th>spaceAmount</th>
    <th>RAM</th>
    <th>OS language</th>
    <th><spring:message code="label.delete"/></th>
</tr>
</thead>
    <tbody>
    <tr>

        <c:forEach var="systemRequirement" items="${systemRequirements}">
            <td>${systemRequirement.OSname}</td>

            <td>${systemRequirement.bitSystem}</td>

            <td> ${systemRequirement.spaceAmount}</td>

            <td> ${systemRequirement.RAM}</td>

            <td>${systemRequirement.OSlanguage}</td>
            <td><a href="/deleteSystemRequirement/${systemRequirement.id}"><spring:message code="label.delete"/> </a></td>
            <td> <a href="/updateSystemRequirement/${systemRequirement.id}"><spring:message code="label.update"/> </a></td>
            <br></tr>
    </c:forEach>
</tbody>
</table>


<%--<div style="display: flex; justify-content: center;text-align: center">--%>

    <%--<div class="col-md-12 col-xs-12">--%>
        <%--<div class="row">--%>
            <%--<div class="col-md-2 col-xs-6">--%>
                <%--<div class="dropdown">--%>
                    <%--<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span--%>
                            <%--class="caret"></span>--%>
                    <%--</button>--%>
                    <%--<ul class="dropdown-menu">--%>
                        <%--<custom:sort innerHtml="Name asc" paramValue="name"/>--%>
                        <%--<custom:sort innerHtml="Name desc" paramValue="name,desc"/>--%>
                    <%--</ul>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="col-md-6 col-xs-12 text-center">--%>
                <%--<custom:pageable page="${modules}" cell="<li></li>" container="<ul class='pagination'></ul>"/>--%>
            <%--</div>--%>
            <%--<div class="col-md-2 col-xs-6">--%>
                <%--<custom:size posibleSizes="1,2,5,10" size="${modules.size}"/>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>