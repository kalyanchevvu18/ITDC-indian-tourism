<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
  text-align: center;
  background-image: url('https://cache.marriott.com/marriottassets/marriott/RDURN/rdurn-exterior-0048-hor-feat.jpg?output-quality=70&interpolation=progressive-bilinear&downsize=1180px:*');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}

</style>
</head>
<body>
<h1>ADDING HOTEL</h1>
<form action="addhotel">
Enter Hotel id:<input type="text" name="id"><br><br>
Enter Hotel Name<input type="text" name="name"><br><br>
Enter Hotel Address<input type="text" name="Address"><br><br>
Enter Hotel Contact Number<input type="text" name="ph_no"><br><br>
Enter Total Rooms<input type="text" name="total_rooms"><br><br>
Enter Available Rooms<input type="text" name="Avail_rooms"><br><br>
Enter Booked Rooms<input type="text" name="Booked_rooms"><br><br>
Enter cost of one Room<input type="text" name="cost"><br><br>

<input type="submit" value="Add_Hotel">

</form>
</body>
</html>