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
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <span class="navbar-brand mb-0 h1">Student Management App</span>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>


            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <form:form method="get"  action="/menu" class="form-inline">
                        <button style="margin-right: 5px" class="btn btn-outline-success my-2 my-sm-0" name="menu" value="students" type="submit">Students</button>
                        <button style="margin-right: 5px" class="btn btn-outline-success my-2 my-sm-0" name="menu" value="teachers" type="submit">Teachers</button>
                        <button style="margin-right: 5px" class="btn btn-outline-success my-2 my-sm-0" name="menu" value="adds" type="submit">Add Student</button>
                        <button style="margin-right: 5px" class="btn btn-outline-success my-2 my-sm-0" name="menu" value="addt" type="submit">Add Teacher</button>
                        <button style="margin-right: 5px" class="btn btn-outline-success my-2 my-sm-0" name="menu" value="logout" type="submit">Logout</button>
                    </form:form>
                    <form action="/edit-operations/edit_profile" method = "get">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Edit Profile</button>
                    </form>
                </ul>
                <form class="form-inline" action="/main/search" action="get">
                    <input class="form-control mr-sm-2" type="search" name="name" placeholder="Search by name" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </body>
</html>
