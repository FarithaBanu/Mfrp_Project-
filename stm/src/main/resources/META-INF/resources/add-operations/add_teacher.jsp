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

        <br>
        <div align="center">
            <form:form method="POST"
                       action="/add-operations/add_teacher/add" modelAttribute="teacher">
                <table>
                    <tr>
                        <td><form:label path="name">Name</form:label></td>
                        <td><form:input class="form-control mb-2" path="name" required ="true"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="surname">Surname</form:label></td>
                        <td><form:input class="form-control mb-2" path="surname" required ="true"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="age">Age</form:label></td>
                        <td><form:input class="form-control mb-2" path="age" required ="true" type="number"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="email">Email</form:label></td>
                        <td><form:input class="form-control mb-2" path="email" required ="true"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="username">Username</form:label></td>
                        <td><form:input class="form-control mb-2" path="username" required ="true"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="password">Password</form:label></td>
                        <td><form:input class="form-control mb-2" path="password" required ="true"/></td>
                    </tr>
                    <tr>
<%--                        <form:hidden path="teacher_id"/>--%>
                        <td><button style="margin-left: 200%;" type="submit" class="btn btn-success" >OK</button></td>
                    </tr>
                </table>
            </form:form>
        </div>


    </body>
</html>
