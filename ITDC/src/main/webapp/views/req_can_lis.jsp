<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <style>  
    body
    {
 
  background-image: url('');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
    
    table,tr,td
    {

width:30%;
text-align:center;
background-color:white;
padding: 4px 50px;


}
a {
	text-align: center;
}
</style>
</head>


<body>
<h1>${message}</h1>


<table border="2px" >

<thead>
<tr>
<th>Booking_Id</th>
<th>Booked for</th>
<th>User_Id</th>
<th>Hotel_Id</th>
<th>Hotel_Name</th>
<th>Customer_Name</th>
<th>no_of_perons</th>
<th>no_of_rooms</th>
<th>no_of_days</th>

<th>Bill OF The Hotel for Rooms You Booked</th>
<th>Status Of Booking</th>



</tr>
</thead>

<tbody>
<c:forEach  var="s" items="${list}">
<tr>
<td><h4><c:out value="${s.getBooking_Id()}"></c:out></h4></td>
<td><h4><c:out value="${s.getDate()}"></c:out></h4></td>
<td><h4><c:out value="${s.getUser_Id()}"></c:out></h4></td>
<td><h4><c:out value="${s.getH_Id()}"></c:out></h4></td>
<td><h4><c:out value="${s.getHotel_Name()}"></c:out></h4></td>
<td><h4><c:out value="${s.getCustomer_Name()}"></c:out></h4></td>
<td><h4><c:out value="${s.getNo_of_perons()}"></c:out></h4></td>
<td><h4><c:out value="${s.getNo_of_rooms()}"></c:out></h4></td>
<td><h4><c:out value="${s. getNo_of_days()}"></c:out></h4></td>
<td><h4><c:out value="${s.getBill()}"></c:out></h4></td>
<td><h4><c:out value="${s.getBooking_Status()}"></c:out></h4></td>



</tr>
</c:forEach>
</tbody>
</table>
<a href="approveone.jsp"><button>Cancel One Request</button></a><br><br>
<a href="approveall"><button>Cancel All</button></a>


</body>
</html>  