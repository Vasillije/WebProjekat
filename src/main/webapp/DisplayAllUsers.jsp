<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<style type="text/css">
body
{
background-color: Bisque;
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
<body>


	<table>
	<tr>
		<td>User Id</td>
		<td>Name</td>
		<td>SurName</td>
		<td>Sex</td>
		<td>Date of birdth</td>
		<td>Role </td>
		<td>pointsCustomer</td>
	</tr>

	<c:forEach items="${requestScope.allUsers}" var="user">
	<tr>
		<td> ${user.id}</td>
		<td> ${user.name}</td>
		<td> ${user.surname}</td>
		<td> ${user.birdth}</td>
		<td> ${user.role}</td>
		<td> ${user.pointsCustomer}</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>