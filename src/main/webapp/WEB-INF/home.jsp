<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="windows-1256">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<title>Incident Management System</title>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #004383;">
  <h1 class="navbar-brand text-light">
    <img src="images/IMS-logo.png" width="30" height="30" class="d-inline-block align-top">
    Incident Management System </h1>
    <button class="navbar-toggler mb-1" data-toggle="collapse" data-target="#navbarMenu"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navbarMenu" >
 <form class="form-inline navbar-nav ml-auto" method="post">
     <button type="submit" class="btn btn-outline-light px-4 mr-2 mb-1" name="search" id="search">Search</button>
    <input class="form-control mb-1" id="customerAccountNumber" type="text" placeholder="Search for account#" minlength="13" autocomplete="off" required>
   <button class="btn btn-danger btn-lg fas fa-sign-out-alt ml-2 mb-1" name="logout" id="logout"></button> 
  </form>
</div>
</nav>

<div class="container mt-5">

  <div class="row">
    <div class="col-12 col-sm-6 col-md-2 mr-auto">
    <input class="form-control mb-1" id="filter" type="text" placeholder="Filter..." autocomplete="off">
    </div>
    <div class="col-12 col-sm-6 col-md-2 ml-2">
	<a href="newTicket.jsp"><button type="button" class="btn btn-outline-dark" name="newTicket" id="newTicket">
	<span class="fas fa-plus"></span> New Ticket</button></a>
    </div>
  </div>
  </div>

<div class="container mt-4">
<table class="table table-bordered" id="table">
  <thead>
    <tr style="background-color: #F2F2F2">
      <th scope="col">Ticket ID</th>
      <th scope="col">Customer Account Number</th>
      <th scope="col">Subject</th>
      <th scope="col">Status</th>
      <th scope="col">Severity</th>
      <th scope="col">Department</th>
      <th scope="col">Assignee Email</th>
    </tr>
  </thead>
  <tbody id="myTable" >

      <c:forEach items="${tickets}" var="ticket">
        <tr style="${ticket.status == 'Open' ? ticket.severity == 'HIGH' ? 'background-color: #f8d7da' : 'background-color: #fff3cd' :'background-color: #d4edda'}">
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
      $("#filter").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#filter tr").filter(function() {
          $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
      });
    });
    </script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</body>
</html>