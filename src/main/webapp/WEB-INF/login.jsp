<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<title>Incident Management System</title>
</head>

<body>

	<div class="container-fluid mt-5 p-2">
        <div class="row justify-content-center ">
        <div class="col-12 col-sm-6 col-md-4">
            <img src="images/AB-logo.png" alt="AB Logo" >
            <form action="dashboard" method="post" id="form" class="needs-validation" novalidate>
        <div class="form-group">
            <label class="font-weight-bold">Email</label>
            <input type="text" class="form-control" name="email" id="email" 
            pattern=".+@arabbank.com.jo" placeholder="example@arabbank.com.jo" required>
            <div class="invalid-feedback">Please provide a valid email</div>
        </div>
            <div class="form-group">
            <label class="font-weight-bold" >Password</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="********" minlength="8" required>
            <div class="invalid-feedback">Password should be at least 8 characters</div>
        </div>
            <button type="submit" class="btn btn-success btn-block font-weight-bold">Login</button>
        </form>
        </div>
        </div>
</div>

</body>

<script>
    (function() {
      window.addEventListener('load', function() {
        var forms = document.getElementsByClassName('needs-validation');
        var validation = Array.prototype.filter.call(forms, function(form) {
          form.addEventListener('submit', function(event) {
            if (form.checkValidity() === false) {
              event.preventDefault();
              event.stopPropagation();
            }
            form.classList.add('was-validated');
          }, false);
        });
      }, false);
    })();
    </script>
</html>