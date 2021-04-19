<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="windows-1256">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<title>Incident Management System</title>
</head>
<body>

<nav class="navbar navbar-light" style="background-color: #004383;">
  <h1 class="navbar-brand text-light" >
    <img src="images/IMS-logo.png" width="30" height="30" class="d-inline-block align-top" alt="IMS-logo" >
    Incident Management System  </h1>
 <form class="form-inline">
    <input class="form-control mb-1" id="myInput" type="text" placeholder="Search...">
    <a href="login.jsp"> <button type="button" class="btn btn-danger px-4 ml-2 mb-1" name="logout" id="logout">Logout</button></a>
  </form>
</nav>

<div class="container mt-5">
  <div class="row justify-content-end">
    <div class="col-12 col-sm-6 col-md-2">
<a href="newTicket.jsp"><button type="button" class="btn btn-outline-dark" >Add New Ticket</button></a>
    </div>
  </div>
  </div>

<div class="container mt-4">
<table class="table table-striped table-bordered" id="table">
  <thead>
    <tr>
      <th scope="col">Ticket ID</th>
      <th scope="col">Customer Account Number</th>
      <th scope="col">Subject</th>
      <th scope="col">Status</th>
      <th scope="col">Severity</th>
      <th scope="col">Department</th>
      <th scope="col">Assignee Email</th>
    </tr>
  </thead>
  <tbody id="myTable">

      <c:forEach items="${tickets}" var="ticket">
        <tr>
            <td><a href="viewTicket.jsp" style="font-weight: bold; color: black; ">${ticket.id}</a></td>
            <td>${ticket.customerAccountNumber}</td>
            <td>${ticket.subject}</td>
            <td>${ticket.status}</td>
            <td>${ticket.severity}</td>
            <td>${ticket.department}</td>
            <td>${ticket.assigneeEmail}</td>
        </tr>
    </c:forEach>
   
  </tbody>
</table>
</div>

<script>
    $(document).ready(function(){
      $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function() {
          $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
      });
    });
    </script>
    
</body>
</html>