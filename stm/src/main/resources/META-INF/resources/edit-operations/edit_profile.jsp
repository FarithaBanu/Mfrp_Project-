<%--
  Created by IntelliJ IDEA.
  User: Hamid
  Date: 18-Aug-19
  Time: 18:24
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

<%
    String path = "/edit-operations/edit_profile/"+request.getAttribute("path");
    String bad = (String) request.getAttribute("bad");
    System.out.println(path+" "+bad);
%>

<br>

<div align="center">
    <c:if test="<%=bad!=null%>">
        <%=bad%>
    </c:if>
    <form:form method="POST"
               action="<%=path%>" modelAttribute="type">
        <table>
            <tr>
                <td><form:label path="username">Username</form:label></td>
                <td><form:input class="form-control mb-2" path="username" required ="true"/></td>
            </tr>
                <tr>
                    <td><label>New password</label></td>
                    <td><input class="form-control mb-2" name="newpassword" required ="true"/></td>
                </tr>
                <tr>
                    <td><label>Confirm new password</label></td>
                    <td><input class="form-control mb-2" name="confirmnewpassword" required ="true"/></td>
                </tr>
            <tr>
                <form:hidden path="id"/>
                <td><button style="margin-left: 200%;" type="submit" class="btn btn-success" >OK</button></td>
            </tr>
        </table>
    </form:form>
</div>


</body>
</html>
