<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader ("Expires", 0);
	
	if(session.getAttribute("session_commid") == null) {
		response.sendRedirect("index.jsp");
	}
%>
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
    <script>
        $(document).ready(function() {
            $('#example').DataTable({
                "info": false
            });
        });
    </script>
</head>

<body>
	<div class="sidebar p-3 bg-accent">
		<div class="staff-name px-4 fs-5 fw-bold">
			<c:out value="${session_name}"></c:out>
		</div>
		<div class="staff-level px-4 fs-6 text-secondary mb-2">
			<c:out value="${session_commid}"></c:out>
		</div>
		<hr>
		<ul class="mt-4 nav nav-pills flex-column mb-auto">
			<li>
				<a href="Committee_Servlet?action=list"   class="nav-link link-dark">
					<img src="assets/icons/file.svg" class="pb-1 px-2">
					<label class="link-name">Lists of Committees </label>
				</a>
			</li>
			<li>
				<a href="Report_Servlet?action=list" class="nav-link active">
					<img src="assets/icons/monitor_white.svg" class="pb-1 px-2">
					<label class="link-name">Report</label>
				</a>
			</li>
			<li>
				<a href="Resident_Servlet?action=list" class="nav-link link-dark">
					<img src="assets/icons/file.svg" class="pb-1 px-2">
					<label class="link-name">Lists of Resident</label>
				</a>
			</li><li>
				<a href="Company_Servlet?action=list" class="nav-link link-dark">
					<img src="assets/icons/file.svg" class="pb-1 px-2">
					<label class="link-name">Lists of Company</label>
				</a>
			</li>
			<li>
				<a href="Logout_Servlet" class="nav-link link-dark" data-bs-toggle="modal" data-bs-target="#exampleModal"> <img src="assets/icons/log_out.svg" class="pb-1 px-2">
					<label class="link-name">Log out</label>
				</a>
			</li>
		</ul>
	</div>
	<div class="content p-3">
	<button class="btn btn-sm btn-secondary bg-accent-light" style="border: none;"><img src="assets/icons/short_left.svg" class="py-1"></button>
	<div class="card w-100">
			<div class="card-header fw-bold">Report List</div>
			<div class="card-body">
				<table id="example" class="display" style="width: 100%">
					<thead>
						<tr>
							<th>Report ID</th>
							<th>Report Description</th>
							<th>Report Type</th>
							<th>Report Status</th>
							<th>Report Date</th>
							<th>Committee ID</th>
							<th>Resident ID</th>
							<th>Company ID</th>
						</tr>
					</thead>
					<tbody>
						
							<tr>
								<td><c:out value="${report.reportid}"></c:out></td>
								<td><c:out value="${report.reportdesc}"></c:out></td>
								<td><c:out value="${report.reporttype}"></c:out></td>
								<td><c:out value="${report.reportstatus}"></c:out></td>	
								<td><c:out value="${report.reportdate}"></c:out></td>
								<td><c:out value="${report.commid}"></c:out></td>
								<td><c:out value="${report.resid}"></c:out></td>
								<td><c:out value="${report.compid}"></c:out></td>
							</tr>
						
					</tbody>
				</table>
			</div>
		</div>
	
	</div>
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Log out</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body text-center">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-primary" onclick="window.location.href='Logout_Servlet'">Confirm</button>
				</div>
			</div>
		</div>
	</div>
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/form-validation.js"></script>
	
</body>

</html>