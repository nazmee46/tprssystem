<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>
  <link rel="stylesheet" href="assets/css/home.css">
  <title>HomePage</title>
</head>

<body>
  <!-- Header -->
  <section id="header">
    <div class="header container">
      <div class="nav-bar">
        <div class="brand">
          <a href="#hero">
            <h1><span>TP</span>RS</h1>
          </a>
        </div>
        <div class="nav-list">
          <div class="hamburger">
            <div class="bar"></div>
          </div>
          <ul>
            <li><a href="logincommittee.jsp" data-after="Home">Committee Log in</a></li>
            <li><a href="loginresident.jsp" data-after="Service">Resident Log in</a></li>
            <li><a href="createResident.jsp" data-after="Projects">Resident Sign Up</a></li>
          </ul>
        </div>
      </div>
    </div>
  </section>
  <!-- End Header -->


  <!-- Hero Section  -->
  <section id="hero">
    <div class="hero container">
      <div>
        <h1>Welcome To <span></span></h1>
        <h1>Taman Pahlawan Reporting System 2023 <span></span></h1>
      </div>
    </div>
  </section>
  <!-- End Hero Section  -->
  <script src="./app.js"></script>
</body>

</html>