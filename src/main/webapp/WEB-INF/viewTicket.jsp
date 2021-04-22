<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="windows-1256">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<title>Incident Management System</title>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<script>
    $(document).ready(function(){
        $("#error").hide();
        if($("#errorMessage").val()!=""){
          $("#error").text($("#errorMessage").val());
          $("#error").addClass("alert alert-danger");
           $("#error").show();
           setTimeout(function (){$("#error").hide()}, 5000);
        }
            var selectedStatus=  $("#status").children("option:selected").val();
            var isClosed=$("#isClosed").val();
            if(selectedStatus=="Close" || isClosed=="true"){
            	$("#close").attr('selected','selected')
                $("#customerAccountNumber").attr('disabled','disabled')
                $("#assigneeEmail").attr('disabled','disabled')
                $("#department").attr('disabled','disabled')
                $("#subject").attr('disabled','disabled')
                $("#problemDescription").attr('disabled','disabled')
                $("#solution").attr('disabled','disabled')
                $("#severity").attr('disabled','disabled')
                $("#status").attr('disabled','disabled')
                $("#update").hide()
                $("#cancel").hide()
            }
            var severity= "${ticket.severity}";
            $('#severity option[value="'+severity+'"]').attr("selected",true);
            
            var dept= "${ticket.department}";
            $('#department option[value="'+dept+'"]').attr("selected",true); 
            
            var status= "${ticket.status}";
            $('#status option[value="'+status+'"]').attr("selected",true);
    });
    </script>
</head>
<body>

<nav class="navbar navbar-light" style="background-color: #004383;">
    <a href="../dashboard"> <h1 class="navbar-brand text-light" >
        Incident Management System  </h1></a></nav>

<div class="container py-5">
    <div class="row">
        <div class="col-md-10 mx-auto">
                  <div id="error" role="alert"></div>
      <input type="hidden" id="errorMessage" value="${errorMessage}">
          <h4>Ticket #${ticket.id}</h4>
            <form method="post" action="../UpdateTicket">
            	<input hidden name="id" value="${ticket.id}">
                <div class="form-group row mt-5">
                    <div class="col-sm-6">
                            <label>Customer Account Number</label>       
                            <input type="text" class="form-control" autocomplete="false"
                            onkeypress="return event.charCode >= 48 && event.charCode <= 57" minlength="13" maxlength="13"
                            placeholder="#############"
                            name="customerAccountNumber" id="customerAccountNumber" value="${ticket.customerAccountNumber }" readonly>
                        </div>
                         <div class="col-sm-6">
                            <label>Department</label>
                        <select class="form-control" name="department" id="department" required >
                            <c:forEach items="${departments}" var="department">
                        		<option value="${department}">${department}</option>
                    		</c:forEach>				
                          </select>  
                        </div>
                    </div>

                    <div class="form-group row">
                     <div class="col-sm-6">
                            <label>Subject</label>
                            <input type="text" class="form-control" name="subject" id="subject" autocomplete="off" value="${ticket.subject }" required>
                     </div> 
                        <div class="col-sm-6">
                            <label>Assignee Email</label>
                            <input type="email" class="form-control" name="assigneeEmail" id="assigneeEmail" value="${ticket.assigneeEmail }" pattern=".+@arabbank.com.jo" 
                            required>
                        </div>
                       
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label>Severity</label>
                            <select class="form-control" name="severity" id="severity" required>
                              <option value="Low">Low</option>
                              <option value="Medium">Medium</option>
                              <option value="High">High</option>					
                            </select>            			
                       </div>   
                        <div class="col-sm-6">
                            <label>Status</label>
                            <select class="form-control" name="status" id="status">
                                <option value="Open" id="open">Open</option>		
                                <option value="Close" id="close">Close</option>	
                                <input type="hidden" id="isClosed" value="${ticket.status=='Close'?true:false}"> 	
                              </select>     
                        </div>
                    </div>
           
                    <div class="form-group row">
                    <div class="col-sm-6">
                            <label>Description</label>
                            <textarea class="form-control" name="problemDescription" id="problemDescription" rows="3" required>${ticket.problemDescription }</textarea>
                        </div>    
                        <div class="col-sm-6">
                            <label>Solution</label>
                            <textarea class="form-control" name="solution" id="solution" rows="3" required>${ticket.solution }</textarea>
                        </div>              
                    </div>

              <button type="submit" class="btn btn-primary px-4 float-right" name="update" id="update"  style="background-color: #004383;">Update</button>  
<button onclick="window.history.back();" type="button" class="btn btn-danger px-4 float-right mr-2" name="cancel" id="cancel">Cancel</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>