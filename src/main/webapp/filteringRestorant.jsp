<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style type="text/css">
body
{
background-color: Bisque;

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
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<div>
<span>expressdostava.com</span>
</div>

<body>
<form action="RestorantDisplayServlet" method="POST">
<table>
	<tr>
		<td>RestorantNumber</td>
		<td>RestorantName</td>
		<td>RestorantType</td>
		<td>RestorantLocation</td>
		<td>RestorantLogo</td>
		<td>RestorantRate</td>
	</tr>
	<%int i = 0; %>
	<c:forEach items="${requestScope.restorants}" var="restorant">
	<tr>
		<td> <%=i %></td>
		<td>${restorant.name}</td>
		<td>${restorant.type}</td>
		<td>${restorant.location.adress.place}</td>
		<td><img width="80" height="80"   src="image/slikaOblik.png" /></td>
		<td>fali rate u klasi jbg</td>
	 	<%i++; %>
		
	</tr>
	</c:forEach>
</table>
<br>




</form>
</body>
</html>




