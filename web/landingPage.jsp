<%-- 
    Document   : landingPage
    Created on : 8-jun-2018, 8:24:09
    Author     : denni
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="DAL.Internship"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Internship Finder</title>
    </head>
    <% 
        String hasSearched = (String)session.getAttribute("hasSearched");
        String searchQuery = (String)session.getAttribute("searchQuery");
        String buttonText = "Submit";
        String srchPlaceholder = "Search";
        String formAction = "searchInternship";
        String disabler = "";
        if(hasSearched.equals("true")) {
            buttonText = "Clear";
            srchPlaceholder = searchQuery;
            formAction = "index";
            disabler = " disabled";
        }
        
    %>
    <body class="body-unpadded">
        <div class ="page-header page-header-custom">            
            <h1>
                Internship Finder
                <small>Find the right internship for you</small>
                <button class="btn btn-primary" id="button-shortlist" onclick="document.location='addToShortlist';">
                    <span class="glyphicon glyphicon-list-alt"></span>
                    My Shortlist
                </button>            
            </h1>            
        </div>
        <form class="navbar-form navbar-right form-right-top-margin" method="POST" action="<%= formAction %>">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="<%= srchPlaceholder %>" name="searchQuery"<%= disabler %>>
            </div>
            <button type="submit" class="btn btn-default"><%= buttonText %></button>
        </form>
    
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
                    <c:forEach items="${allInternships}" var="internship">
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
