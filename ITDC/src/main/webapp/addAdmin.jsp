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
	background-image: url('https://image.shutterstock.com/z/stock-photo-restaurant-manager-and-his-staff-in-kitchen-interacting-to-head-chef-in-commercial-kitchen-1062459128.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
	
}
</style>
</head>
<body>
<h1>Creating New Admin </h1>
<form action="admin">
<input type="number" name="id" placeholder="AdminId"><br><br>
<input type="text" name="pass" placeholder="Password"><br><br>

<input type="text" name="repass" placeholder="Re-Password"><br><br>
 <input type="submit" value="Create">
</form>

</body>
</html>