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

<h1 style="color: #8317AD">System requirements</h1>
<sf:form modelAttribute="systemRequirement" method="post" action="/systemRequirement">
    <sf:input path="OSname"/>
    <sf:input path="bitSystem"/>
    <sf:input path="spaceAmount"/>
    <sf:input path="RAM"/>
    <sf:input path="OSlanguage"/>
    <button>Save Requirements</button>

</sf:form>

<%--<div style="color: white">--%>

    <%--<c:forEach var="systemRequirement" items="${systemRequirements.content}">--%>
        <%--&lt;%&ndash;<c:forEach var="module" items= "${modules}" >&ndash;%&gt;--%>
        <%--${systemRequirement.name}--%>

        <%--<a href="/deleteModule/${systemRequirement.id}">delete</a><br>--%>
    <%--</c:forEach>--%>
<%--</div>--%>
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