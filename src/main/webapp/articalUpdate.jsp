<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ArticalUpdateServlet" method="POST">
<input type="hidden" name="articalID" value="${requestScope.artical.id}">
<table>

	<tr>
		<td>Name</td>
		<td><input type="text" value="${requestScope.artical.name}" name ="name"/></td>
	</tr>
	<tr>
		<td>Price</td>
		<td><input type="text" value="${requestScope.artical.price}" name ="price"/></td>
	</tr>
	
	<tr>
	<td>Artical Type</td>
	<td>
		<select name="articalType">
		
		<c:forEach items="${requestScope.types}" var="type1">
			<c:choose>
			<c:when test="${requestScope.artical.type == type1}"><option value="${type1}" selected>${type1}</option></c:when>
			<c:otherwise><option value="${type1}">${type1}</option></c:otherwise>
			
			</c:choose>
		</c:forEach>
		</select>
	</td> 
	</tr>
	
	<tr>
	<td>Image NMP  N !!!</td>
	<td>
		<input type="text" value="${requestScope.artical.image}" name="image">
	</td> 
	</tr>
	
	<tr>
	<td>Description(Optional)</td>
	<td>
		<input type="text"  value="${requestScope.artical.opis}" name="description">
	</td> 
	</tr>
	
	<tr>
	<td>Amount(Optional)</td>
	<td>
		<input type="text" value="${requestScope.artical.amount}" name="amount">
	</td> 
	</tr>
	
	
	
	<tr><td><input type="submit" value="update"></td></tr>
	
</table>

</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("error") != null) { %>
		<p style="color: red"><%=request.getAttribute("error")%></p>
	<% } %>

</body>
</html>