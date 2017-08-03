<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div class="container">


    <div class="panel">
        <form:form modelAttribute="country"
                   action="/country?${_csrf.parameterName}=${_csrf.token}"
                   method="post" enctype="multipart/form-data">
            <div style="display: flex; justify-content: space-around ">

                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail3">Email address</label>
                        ${nameException}
                    <form:input path="name" type="text" class="form-control" id="exampleInputEmail3"
                                placeholder="country name"/>
                </div>
                <div class="form-group" id="images">
                    <input name="images" type="file" class="form-control" required="required"/>
                </div>
                <div class="form-group" style="width: 20px; height: 20px">
                    <input type="button" value="add image" class="btn btn-default" id="addImage" >
                </div>
                <div class="form-group">
                    <button class="btn btn-default">save country</button>
                </div>
            </div>
        </form:form>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
                <th>images</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="country" items="${countries}">
                <tr>
                    <td>
                            ${country.name}
                    </td>
                    <c:forEach var="img" items="${country.countryImages}">
                        <td>
                            <img src="${img.pathImage}" alt="${img.pathImage}" height="192px" width="150px">
                        </td>
                    </c:forEach>
                    <td>
                        <a href="/updateCountry/${country.id}">update</a>
                    </td>
                    <td>
                        <a href="deleteCountry/${country.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>



<script>
    document.getElementById('addImage').onclick = function () {
        var newFileInput = document.createElement('input');
        newFileInput.type = 'file';
        newFileInput.name = 'images';
        newFileInput.className = 'form-control';
        newFileInput.required = 'required';
        document.getElementById('images').appendChild(newFileInput);
    }
</script>