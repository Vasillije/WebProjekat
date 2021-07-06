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
<form action="ArticalDisplayServlet" method="POST">
<table>
	<tr>
		<td>ArticalNumber</td>
		<td>ArticalName</td>
	</tr>
	<%int i = 1; %>
	<c:forEach items="${requestScope.articls}" var="artical">
	<tr>
		<td> <%=i %></td>
		<td><a href="/ArticalUpdateServlet?id=${artical.id}">${artical.name}</a></td>
	 	<%i++; %>
		
	</tr>
	</c:forEach>
</table>
<br>

<br>
<input type="submit" value="Search">

</form>
</body>
</html>