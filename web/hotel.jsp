<%-- 
    Document   : hotel
    Created on : Feb 11, 2015, 8:22:27 PM
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manage Hotels</title>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">


        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and 
        media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via 
        file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js">
          </script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js">
          </script>
        <![endif]-->
    </head>
    <body>
        <p style="font-size: xx-small;"><a href="index.jsp">Home</a> &gt; Manage Hotels</p>
        <h1>Manage Hotels</h1>
        <p>Instructions: select one or more records to delete by checking boxes.
        <br>Select zero or one record to add or edit and Employee. <br>If you
        try to add/edit more than one record, only the first selection<br>
        will be recognized.</p>



        <form method="POST" action='<%= request.getContextPath()%>/hotel'>
        <input type="submit" value="Add/Edit" name="addEdit" />&nbsp;
        <input type="submit" value="Delete" name="delete" />
        <br><br>
        <table width="500" border="1" cellspacing="0" cellpadding="4">
            <tr style="background-color: black;">
                <th>&nbsp;</th>
                <th align="left" class="tableHead">Hotel Name</th>
                <th align="left" class="tableHead">Address</th>
                <th align="left" class="tableHead">City</th>
                <th align="right" class="tableHead">State</th>
                <th align="right" class="tableHead">Zip</th>
                <th align="right" class="tableHead">Notes</th>
            </tr>
        <c:forEach var="hotel" items="${hotels}" varStatus="rowCount">
            <c:choose>
                <c:when test="${rowCount.count % 2 == 0}">
                    <tr style="background-color: white;">
                </c:when>
                <c:otherwise>
                    <tr style="background-color: #ccffff;">
                </c:otherwise>
            </c:choose>
            <td><input type="checkbox" name="id" value="${hotelId}" /></td>
            <td align="left">${hotel.hotelName}</td>
            <td align="left">${hotel.streetAddress}</td>
            <td align="left">${hotel.city}</td>
            <td align="left">${hotel.state}</td>
            <td align="left">${hotel.postalCode}</td>
            <td align="left">${hotel.notes}</td>
        </tr>
        </c:forEach>
        </table>
        <br>
        <input type="submit" value="Add/Edit" name="addEdit" />&nbsp;
        <input type="submit" value="Delete" name="delete" />
        </form>


            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
            </script>
            <!-- Latest compiled and minified JavaScript -->
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    </body>
</html>

