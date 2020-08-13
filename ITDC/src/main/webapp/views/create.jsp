<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">


body {
  background-image: url('https://aniportalimages.s3.amazonaws.com/media/details/Tourism_sector.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}



#a{
background-color:gray;
}
button {
	width:200px;
	height:80px;

	font-size: 25px;
	text-align: center;
}

</style>
</head>

<body>

<h1 id="a"> Welcome TO Indian Tourism Development Corporation</h1>
<table>
<a href="addAdmin.jsp"><button>Create Admin</button> </a><br><br>
<a href="addUser.jsp"><button> Create User</button></a><br><br>
<a href="adlog.jsp"><button>Admin Login</button> </a><br><br>
<a href="uslog.jsp"> <button>User Login</button></a><br><br>
</table>
</body>

</html>