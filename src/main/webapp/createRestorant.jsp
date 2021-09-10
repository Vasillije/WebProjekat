<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<style type="text/css">
body
{
background-color: Bisque;
 background-image: url('image/gradjevina.jpg');
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
</style>
<head>
<meta charset="ISO-8859-1">
<title>Creating restaurant</title>
</head>
<div>
<span>expressdostava.com</span>
</div>
<body>

<form action="RestorantServlet"  method="POST" >
<table>
	<tr>
		<td>Name</td>
		<td><input type="text" name ="restorantName"/></td>
	</tr>
	<tr>
		<td>StreetName</td>
		<td><input type="text" name ="restorantStreetName"/></td>
	</tr>
	<tr>
		<td>CityName</td>
		<td><input type="text" name ="restorantPlace"/></td>
	</tr>
	<tr>
		<td>Street Number</td>
		<td><input type="text" name ="restorantStreetNumber"/></td>
	</tr>
	<tr>
		<td>ZipCode</td>
		<td><input type="text" name ="restorantZipCode"/></td>
	</tr>
	<tr>
		<td>restorantgLenght</td>
		<td><input type="text" name ="restorantgLenght"/></td>
	</tr>
	<tr>
		<td>restorantgWidth</td>
		<td><input type="text" name ="restorantgWidth"/></td>
	</tr>
	<tr>
		<td>Logo</td>
		<form action="RestorantServlet"  method="POST" >
		<td><input type="text" name="logo" /></td>
		</form>
	
	<tr>
		<td>RestaurantType</td>
		<td> 
			<select name="restorantType" >
			 <option value="ITALIAN">ITALIAN</option>
			 <option value="CHINESE">CHINESE</option>
			 <option value="GRILL">GRILL</option>
			 <option value="PIZZERIA">PIZZERIA</option>
			 
			</select>
		<td/>
	</tr>

	<tr>
		<td>Managers</td>
		<td> 
			<select name="manager" >
				<option value = "-1">Dodaj novog menadzera</option>
				 <c:forEach items="${requestScope.managers}" var="manager">
				 	<option value="${manager.id}">${manager.name}</option>
				 </c:forEach>
			</select>
		<td/>
		
	</tr>
	
	
	<tr><td><input type="submit" value="Create"></td></tr>
</table>
</form>
	<% if (request.getAttribute("error") != null) { %>
		<p style="color: red"><%=request.getAttribute("error")%></p>
	<% } %>
</body>
</html>