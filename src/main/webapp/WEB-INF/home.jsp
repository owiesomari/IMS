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
     <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #004383;">
  <h1 class="navbar-brand text-light">
    <img src="../images/IMS-logo.png" width="30" height="30" class="d-inline-block align-top">
    Incident Management System </h1>
    <button class="navbar-toggler mb-1" data-toggle="collapse" data-target="#navbarMenu"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navbarMenu" >
    <input class="form-control mb-1 mr-2 col-md-4 ml-auto" id="customerAccountNumber" type="text" 
    placeholder="Search for account#" minlength="13" autocomplete="off" ondrop="return false;" onpaste="return false;"
     onkeypress="return event.charCode >= 48 && event.charCode <= 57" minlength="13" maxlength="13" required>
     <button type="submit" class="btn btn-outline-light px-4 mr-2 mb-1" name="search" id="search">Search</button>
<a href="index"><button class="btn btn-danger btn-lg fas fa-sign-out-alt ml-2 mb-1" name="logout" id="logout" title="Logout"></button></a>
</div>
</nav>

<div class="container mt-5">

  <div class="row">
    <div class="col-12 col-sm-6 col-md-2 ml-0">
	<a href="addNewTicket"><button type="button" class="btn btn-outline-dark" name="newTicket" id="newTicket">
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
        <tr style="${ticket.status == 'Open' ? ticket.severity == 'High' ? 'background-color: #F88F99' : 'background-color: #fff3cd' :'background-color: #d4edda'}">
            <td><a href="ViewTicket/${ticket.id}" style="font-weight: bold; color: black; ">${ticket.id}</a></td>
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


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js" ></script>
<script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js" ></script>

<script>
    $(document).ready(function(){
      $('#table').DataTable();
    });
    
     $("#search").click(function(){
    	 var table="";
  	  var accountNum= $("#customerAccountNumber").val();
  	  console.log("account # "+accountNum);
  	  if(accountNum == "" || accountNum==null) return;
  	$.ajax({
  	    type: "POST",
  	    contentType: "application/json",
  	    url: "/api/SearchAccountNumber",
  	    data: accountNum,
  	  	dataType:"json",
  	    cache: false,
  	    success: function (data) {
  	          
  	      $.each(data, function(key,value) {
  	    	 table+="<tr style="+"${ticket.status == 'Open' ? ticket.severity == 'HIGH' ? 'background-color: #f8d7da' : 'background-color: #fff3cd' :'background-color: #d4edda'}"+">"+ 
  	    	 "<td><a href="+"ViewTicket/"+value.id+" style=font-weight: bold; color: black;>"+value.id+"</a></td>"+
   	        "<td>"+value.customerAccountNumber+"</td>"+
   	        "<td>"+value.subject+"</td>"+
   	     	"<td>"+value.status+"</td>"+
   	     	"<td>"+value.severity+"</td>"+
   	  		"<td>"+value.department+"</td>"+
   			"<td>"+value.assigneeEmail+"</td>"+
   			"</tr>";
	        
  	    	}); 
  	      $("#searchTable #searchTableBody").append(table);  	      
  	      $("#searchModal").modal("show");
  	      
  	    }
  	}); 
      table="";
    }); 
    </script>
    
<div class="modal fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document" style="max-width: fit-content;">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Account's Number Tickets</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
<table class="table table-bordered" id="searchTable">
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
  <tbody id="searchTableBody" >

  </tbody>
</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>