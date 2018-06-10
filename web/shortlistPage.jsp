<%-- 
    Document   : shortlistPage
    Created on : 9-jun-2018, 14:28:07
    Author     : denni
--%>

<%@page import="java.util.Date"%>
<%@page import="DAL.Organisation"%>
<%@page import="java.util.List"%>
<%@page import="DAL.Internship"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>My shortlist</title>
    </head>
    <body class="body-unpadded">
        <div class ="page-header page-header-custom">            
            <h1>
                Internship Finder
                <small>My shortlist</small>           
            </h1>            
        </div>
        <button class="btn btn-success button-left-margined" onclick="document.location='index';">
            <span class="glyphicon glyphicon-chevron-left"></span>
            Return to overview
        </button>
        <div>
            <table class="table table-hover table-custom-marged">
                <thead>
                    <tr>
                        <th class="col-lg-3">Title</th>
                        <th class="col-lg-3">Organisation</th>
                        <th class="col-lg-6">Start Date</th>
                    </tr>
                </thead>
                <tbody class="finger-point">
                    <c:forEach items="${shortlist}" var="internship">
                        <tr onclick="document.location='detailPage?id=${internship.id}';">
                            <td>${internship.title}</td>
                            <td>${internship.organisationID.name}</td>
                            <td><fmt:formatDate value="${internship.startDate}" pattern="dd/MM/yyyy" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
