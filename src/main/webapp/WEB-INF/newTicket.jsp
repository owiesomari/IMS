<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
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
  <h1 class="navbar-brand text-light">Incident Management System</h1>
</nav>

<div class="container py-5">
    <div class="row">
        <div class="col-md-10 mx-auto">
          <h4>New Ticket</h4>
            <form method="post" action="addTicket">
                <div class="form-group row mt-5">
                
                <div class="col-sm-6">
                        <label>Customer Account Number</label>
                        <input type="text" class="form-control" name="customerAccountNumber" id="customerAccountNumber" required>
                    </div>
                
                    <div class="col-sm-6">
                        <label>Customer Name</label>
                        <input type="text" class="form-control" name="customerName" id="customerName" required>
                    </div>
                    
                    
                </div>
                <div class="form-group row">
                <div class="col-sm-6">
                        <label>Department</label>
                        <input type="text" class="form-control" name="department" id="department" required>
                    </div>
                    
                    <div class="col-sm-6">
                        <label>Subject</label>
                        <input type="text" class="form-control" name="subject" id="subject" required>
                    </div>
                   
                </div>
                <div class="form-group row">
                 <div class="col-sm-6">
                        <label>Assignee Email</label>
                        <input type="text" class="form-control" name="assigneeEmail" id="assigneeEmail" required>
                    </div>
                    <div class="col-sm-6">
                        <label>Status</label>
                        <input type="text" class="form-control" name="status" id="status" value="Open" readonly> 
                    </div>
                   
                </div>
                <div class="form-group row">
                 <div class="col-sm-6">
                        <label>Severity</label>
					    <select class="form-control" name="severity" id="severity" required>
					      <option value="low">Low</option>
					      <option value="medium">Medium</option>
					      <option value="high">High</option>					
		   			 </select>            			
         		  </div>
         		  
         		  <div class="col-sm-6">
                        <label>Issue Date</label>
					    <input type="date" class="form-control" name="issueDate" id="issueDate" ></textarea>
                    </div>                                  	
                </div>
                
                <div class="form-group row">
                <div class="col-sm-6">
                        <label>Description</label>
					    <textarea class="form-control" name="problemDescription" id="problemDescription" rows="3"></textarea>
                    </div>               
                </div>
              <button type="sumbit" class="btn btn-primary px-4 float-right" name="save" id="save"  style="background-color: #004383;">Save</button>  
             <a href="home.jsp"> <button type="button" class="btn btn-danger px-4 float-right mr-2" name="cancel" id="cancel">Cancel</button></a>
            </form>
        </div>
    </div>
</div>

</body>
</html>