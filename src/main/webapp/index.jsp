<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">
body
{
background-color: Bisque;
 background-image: url('image/food.jpg');
 background-repeat : no-repeat;
 background-size: 100% 100%;
 background-attachment: fixed;

}
span
{
	color:white;
	font-size:40px;
}
<span>expressdostava.com</span>
</div>
a {
  color: hotpink;
}
.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
div
{
background : black;
height : 50px;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<div>
<body>
	<div class="topnav">
	
	<a class="active" href="OrderDisplayServlet">orders</a>
	<a href="RestorantDisplayServlet">restaurants</a>
	<a href="ArticalDisplayServlet">display articles</a>
	<a href="CreateArticalServlet">create articles</a>
	<a href="RegistrationMenagerServlet">register manager</a>
	<a href="RestorantServlet">Create restaurants</a>
	<a href = "UserDisplayServlet"> Your profile</a>
		
	</div>
	
	<% if (request.getAttribute("error") != null) { %>
		<p style="color: red"><%=request.getAttribute("error")%></p>
	<% } %>
</body>
</html>