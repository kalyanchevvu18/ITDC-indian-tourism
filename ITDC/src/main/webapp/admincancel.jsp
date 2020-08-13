<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	text-align: center;
	 background-image: url('img_girl.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
</head>
<body>
<h1>Canceling The User_Booking</h1>

<form action="admincancel">

Enter User Id Whose Booking You Want To Cancel:<input type="text" name="uid">
Enter Booking_Id of User:<input type="text" name="bid">
<input type="submit" value="Cancel">

</form>

</body>

</html>