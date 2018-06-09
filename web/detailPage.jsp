<%-- 
    Document   : detailPage
    Created on : 8-jun-2018, 14:35:25
    Author     : denni
--%>

<%@page import="DAL.Organisation"%>
<%@page import="java.util.Date"%>
<%@page import="DAL.Internship"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Internship Details</title>
    </head>
    <body class="body-unpadded">
        <% 
            Internship current = (Internship)session.getAttribute("requestedInternship");
            String currentTitle = current.getTitle();
            String currentDescription = current.getDescription();
            String currentStartDate = current.getDateAsString();
            Organisation currentOrg = current.getOrganisationID();
            String OrgName = currentOrg.getName();
            String OrgStreet = currentOrg.getStreetAddress();
            String OrgZip = currentOrg.getZipCode();
            String OrgCity = currentOrg.getCity();
            String OrgContact = currentOrg.getContactPerson();
            String OrgEmail = currentOrg.getEmail();
        %>
        <div class ="page-header page-header-custom">
            <h1>Internship Finder <small>Internship details</small></h1>
        </div>
        <div>
            <button class="btn btn-success button-left-margined" onclick="document.location='index';">
                <span class="glyphicon glyphicon-chevron-left"></span>
                Return to overview
            </button>
            <button class="btn btn-primary button-left-margined" onclick="document.location='addToShortlist?id=${requestedInternship.id}';">
                <span class="glyphicon glyphicon-pushpin"></span>
                Add to shortlist
            </button>
            <table class="table table-striped table-custom-marged">
                <tbody>
                    <tr>
                        <td colspan="2" class="table-subtitle-row"><h3>Organisation</h3></td>
                    </tr>
                    <tr>
                        <td class="col-lg-2">Name:</td>
                        <td class="col-lg-10"><%= OrgName %></td>
                    </tr>
                    <tr>
                        <td>Street + N°:</td>
                        <td><%= OrgStreet %></td>
                    </tr>
                    <tr>
                        <td>Zip + City:</td>
                        <td><%= OrgZip %> <%= OrgCity %></td>
                    </tr>
                    <tr>
                        <td>Contact Person:</td>
                        <td><%= OrgContact %></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><%= OrgEmail %></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="table-subtitle-row"><h3>Internship</h3></td>
                    </tr>
                    <tr>
                        <td>Title:</td>
                        <td><%= currentTitle %></td>
                    </tr>
                    <tr>
                        <td>Starting on:</td>
                        <td><%= currentStartDate %></td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td><%= currentDescription %></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
