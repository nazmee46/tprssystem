<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	<meta name="generator" content="Hugo 0.84.0">
	<title> tprsystem </title>
	<link rel="icon" href="assets/images/UiTM_logo.png">
	<link href="assets/css/bootstrap.css" rel="stylesheet">
	<link href="assets/css/style.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="assets/js/datatables.js"></script>
    <link rel="stylesheet" href="assets/css/datatables.css">
   
</head>

<body>
	<main class="form-signin text-center mt-8 bg-accent">
	
		<input type="button" class="w-50 p-3 fw-bold bg-accent" value="">
	<form action="Resident_Servlet_res" method="post" class="m-4">
	<label>Create Resident Account</label>
	<div class="form-floating">
				
				<input type="text" name="resid" id="resid" class="form-control" required>
				<label>Enter ID</label>
			</div><br>
			<div class="form-floating">
				<input type="text" name="resname" id="resname" class="form-control" required>
				<label>Enter name</label>
			</div><br>
			<div class="form-floating">
				<input type="text" name="resphoneno" id="resphoneno" class="form-control" required>
				<label>Enter phone number</label>
			</div><br>
			<div class="form-floating">
				<input type="text" name="resaddress" id="resaddress" class="form-control" required>
				<label>Enter address</label>
			</div><br>
			<div class="form-floating">
				<input type="password" name="respass" id="respass" class="form-control" required>
				<label>Enter password</label>
			</div><br>
			<button style=background-color:#DC143C class="w-100 btn btn-lg btn-primary my-5" type="submit">Sign Up</button>
			<p class=" pb-4 text-muted">&copy; 2022 - 2023</p>
	  
	</form>
	</main>
	
	 
	
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/form-validation.js"></script>
	
</body>

</html>