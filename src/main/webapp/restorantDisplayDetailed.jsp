<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<td>RestorantNumber</td>
		<td>RestorantName</td>
		<td>RestorantType</td>
		<td>RestorantLocation</td>
		<td>RestorantLogo</td>
		<td>RestorantRate</td>
	</tr>
	<tr>
		<td>${requestScope.restorant.name}</td>
		<td>${requestScope.restorant.type}</td>
		<td>${requestScope.restorant.status}</td>
		<td>${requestScope.restorant.location.adress.place}</td>
		<td><img width="80" height="80"   src="image/slikaOblik.png" /></td>
		<td>fali rate u klasi jbg</td>
		<td>${requestScope.restorant.status}</td>
	 	
		
	</tr>
</table>
<br>

</body>
</html>