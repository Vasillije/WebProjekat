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
<form action="UserOrderDisplayServlet" method="POST">
<table>
	<tr>
		<td>OrderNumber</td>
		<td>RestorantName</td>
		<td>Restorant OPEN???</td>
	</tr>
	<%int i = 1; %>
	<c:forEach items="${requestScope.orders}" var="order">
	<tr>
		<td> <%=i %></td>
		<td>${order.restorant.name}</td>
		
		<td>${restorant.status}</td>
	 	<%i++; %>
		
	</tr>
	</c:forEach>
</table>


<br>
<input type="submit" value="Search">

</form>
treba da se ubaci samo nedostavljene porudzbine
</body>
</html>