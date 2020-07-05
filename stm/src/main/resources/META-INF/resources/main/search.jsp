<%--
  Created by IntelliJ IDEA.
  User: hamidsultanzadeh
  Date: 20.09.19
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Student Management</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <%--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>--%>
    <%--        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

</head>
<body>
<jsp:include page="../navbar.jsp"/>

<div class="table-responsive-md">
    <table class="table table-striped table-light">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Surname</th>
        </tr>
        </thead>
        <tbody>

        <%
            Integer n = 1;
        %>

        <c:forEach items="${search1List}" var="item">
            <tr>
                <td><%=n%></td>
                <td>${item.name}</td>
                <td>${item.surname}</td>
            </tr>

            <% n++; %>
        </c:forEach>

        <%
            Integer m = 1;
        %>

        <c:forEach items="${search2List}" var="item">
            <tr>
                <td><%=m%></td>
                <td>${item.name}</td>
                <td>${item.surname}</td>
            </tr>

            <% m++; %>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>
