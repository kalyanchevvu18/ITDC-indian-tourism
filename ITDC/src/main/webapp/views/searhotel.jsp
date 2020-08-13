<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <style>  
    body {
  background-image: url('data:image/jpeg;base64,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');
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

</style>
</head>


<body bgcolor="silver">
<h1>${message }</h1>


<table border="2px" >

<thead>
<tr>
<th>Hotel_Id</th>
<th>Hotel_Name</th>
<th>Hotel Address</th>
<th>Contact Number</th>
<th>Total Rooms</th>
<th>Available Rooms</th>
<th>Booked Rooms</th>
<th>Cost of Room/Day</th>


</tr>
</thead>

<tbody>
<c:forEach  var="s" items="${list}">
<tr>
<td><h4><c:out value="${s.getId()}"></c:out></h4></td>
<td><h4><c:out value="${s.getName()}"></c:out></h4></td>
<td><h4><c:out value="${s.getAddress()}"></c:out></h4></td>
<td><h4><c:out value="${s.getPh_no()}"></c:out></h4></td>
<td><h4><c:out value="${s.getTotal_rooms()}"></c:out></h4></td>
<td><h4><c:out value="${s.getAvail_rooms()}"></c:out></h4></td>
<td><h4><c:out value="${s. getBooked_rooms()}"></c:out></h4></td>
<td><h4><c:out value="${s.getCost()}"></c:out></h4></td>

</tr>
</c:forEach>
</tbody>
</table>


</body>
</html>  