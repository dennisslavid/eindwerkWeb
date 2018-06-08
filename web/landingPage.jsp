<%-- 
    Document   : landingPage
    Created on : 8-jun-2018, 8:24:09
    Author     : denni
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="DAL.Internship"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="./style/general.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Internship Finder</title>
    </head>
    <body class="padded">
        <div class ="page-header">
            <h1>Internship Finder <small>Find the right internship for you</small></h1>
        </div>
        <div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>title</th>
                        <th>Organisation</th>
                        <th>Start Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${allInternships}" var="internship">
                        <tr onclick="document.location='detailPage?id=${internship.id}';">
                            <td>${internship.title}</td>
                            <td>${internship.organisationID.name}</td>
                            <td>${internship.startDate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
    </body>
</html>
