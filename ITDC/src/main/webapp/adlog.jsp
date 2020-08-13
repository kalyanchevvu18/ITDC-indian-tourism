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
	background-image: url('https://image.shutterstock.com/image-photo/picture-two-receptionists-work-600w-513839848.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
#a{
color: red;
}
</style>
</head>
<body>
<h1 id="a">${message} </h1>
<h1>Admin Login </h1>

<form action="adminlog">
<input type="number" name="id" placeholder="AdminId"><br><br>
<input type="text" name="pass" placeholder="Password"><br><br>
 <input type="submit" value="Login">
</form>

</body>
</html>