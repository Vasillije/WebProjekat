<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body
{
background-color: Bisque;
 background-image: url('image/purger.jpg');
 background-repeat : no-repeat;
 background-size: 100% 100%;
 background-attachment: fixed;

}
span
{
	color:white;
	font-size:40px;
}
div
{
background : black;
height : 50px;
}
input
{
	font-size:28px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<div>
<span>expressdostava.com</span>
</div>
<body>

<form action="LoginServlet" method="GET">

<input type="submit" value="Login"></input>
</form>
<br>
<br>
<form action="RegistrationServlet" method="GET">

<input type="submit" value="Register"></input>
</form>

</body>
</html>