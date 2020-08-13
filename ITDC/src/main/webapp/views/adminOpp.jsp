<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {

	font-size: 20px;
  background-image: url('https://aniportalimages.s3.amazonaws.com/media/details/Tourism_sector.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}


</style>
</head>
<body>
<h1>${message}</h1>

<a href="addhotel.jsp">Add Hotel</a><br><br>
<a href="hotels">Get List Of Hotel</a><br><br>
<a href="bookings">Look At Bookings</a><br><br>
<a href="admincancel.jsp">Cancel Booking</a><br><br>
<a href="delhotel.jsp">Delete Hotel</a><br><br>
<a href="user_req_can">Users Requested Cancellations</a><br><br>

</body>
</html>