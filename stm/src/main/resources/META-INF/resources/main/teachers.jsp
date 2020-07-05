<%-- 
    Document   : index
    Created on : Jul 28, 2019, 6:46:14 PM
    Author     : Hamid
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
                    <th>Age</th>
                    <th>Email</th>
                    <th>Number of Students</th>
                    <th>Button</th>
                </tr>
                </thead>
                <tbody>

                <%
                    Integer n = 1;
                %>

                <c:forEach items="${teachersList}" var="item">
                    <tr>
                        <td><%=n%></td>
                        <td>${item.name}</td>
                        <td>${item.surname}</td>
                        <td>${item.age}</td>
                        <td>${item.email}</td>
                        <td>${item.studentscount}</td>
                        <td>
                            <form:form method="get" action="/main/teachers/actions">

                                <button type="Submit" name="action" value="edit" class="btn btn-outline-warning">
                                    <i class="fas fa-user-edit"></i>
                                </button>
                                <input type="hidden" name="id" value = "${item.id}"/>
                            </form:form>
                        </td>
                    </tr>

                    <% n++; %>
                </c:forEach>

                </tbody>
            </table>
        </div>

    </body>
</html>
