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
	background-image: url('https://images.pexels.com/photos/2017802/pexels-photo-2017802.jpeg?cs=srgb&dl=pexels-helena-lopes-2017802.jpg&fm=jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
</head>
<body bgcolor="silver">
<h1>Creating New User </h1>




<form action="user">
<input type="number" name="id" placeholder="UserId"><br><br>
<input type="text" name="pass" placeholder="Password"><br><br>
<input type="text" name="repass" placeholder="Password"><br><br>
 <input type="submit" value="Create">
</form>



</body>
</html>