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
	
	<div class="content p-3">
	<button class="btn btn-sm btn-secondary bg-accent-light" style="border: none;"><img src="assets/icons/short_left.svg" class="py-1"></button>
	<form action="Resident_Servlet_res" method="post">
	  <label for="resid">resident id:</label><br>
	  <input type="text" id="resid" name="resid" value=""><br>
	  <label for="resname"> resident name:</label><br>
	  <input type="text" id="resname" name="resname" value=""><br>
	  <label for="resphoneno"> resident phone:</label><br>
	  <input type="text" id="resphoneno" name="resphoneno" value=""><br>
	  <label for="resaddress"> resident address:</label><br>
	  <input type="text" id="resaddress" name="resaddress" value=""><br>
	  <label for="respass"> resident password:</label><br>
	  <input type="text" id="respass" name="respass" value=""><br>
	  <br>
	  <br>
	  
	  <input type="submit" value="Create account resident">
	  
	  
	</form>
	</div>
	
	 
	
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/form-validation.js"></script>
	
</body>

</html>