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

<table>
	<tr>
		<td>index</td>
		<td>Artical Name</td>
		<td>Kolicina</td>
		<td> Cena </td>
		
	</tr>
	<%int i = 0; %>
	<c:forEach items="${requestScope.basket}" var="basketHelpInfo">
	<tr>
		<td> <%=i %></td>
		<td>${basketHelpInfo.artical.name}</td>
		
		<td>${basketHelpInfo.amount}</td>
		<td> ${basketHelpInfo.price} </td>
		
		<form action="BasketUpdateServlet" method="POST"> 
			<input type="hidden" name="idArtical" value="${basketHelpInfo.artical.id}">
			<td> <input type="number" name="amountOfArtical" min="1" max="1000"> </td>
			<td> <button type="submit">Update ako je prazno javasctirp</button> </td>
		</form>
		<form action="BasketDeleteServlet" method="POST">
			<input type="hidden" name="idArtical" value="${basketHelpInfo.artical.id}">
			<td> <button type="submit">Delete</button> </td>
		
		</form>
	 	<%i++; %>
		
	</tr>
	</c:forEach>
</table>

<br>
<h1> Ukupna Cena:</h1>
${requestScope.ukupna}


<br>
<br>
<form action="BasketServlet" method="POST"> 
	<button type="submit">Add</button> 
</form>

</body>
</html>