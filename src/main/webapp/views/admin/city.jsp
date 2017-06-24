<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/21/2017
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Latest compiled and minified CSS -->
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>

<!-- Optional theme -->
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">--%>

<!-- Latest compiled and minified JavaScript -->
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>



<div class="container">
    <div class="panel">
        <div style="display: flex; justify-content: space-around ">

            <div class="form-group">

                <input type="text" class="form-control" id="cityName"
                       placeholder="city name"/>
            </div>
            <div class="form-group">
                <button class="btn btn-default" id="saveCity">save city</button>
            </div>
        </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody id="result">
            </tbody>
        </table>
    </div>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />


<script src="/js/city.js"></script>
