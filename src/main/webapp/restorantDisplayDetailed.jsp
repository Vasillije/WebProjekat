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
		<td>RestorantName</td>
		<td>${requestScope.restorant.name}</td>
	</tr>	
	<tr>
		<td>RestorantType</td>
		<td>${requestScope.restorant.type}</td>
	</tr>	
	<tr>
		<td>RestorantLocation</td>
		<td>${requestScope.restorant.location.adress.place}</td>
	</tr>	
	<tr>
		<td>RestorantLogo</td>
		<td><img width="80" height="80"   src="image/slikaOblik.png" /></td>
	</tr>
	<tr>
		<td>STATUS</td>
		<td>${requestScope.restorant.status}</td>
		
	</tr>
</table>
<br>
RESTORANT COMMENTS:
<%int i = 0; %>
<table>
<c:forEach items="${requestScope.comments}" var="comment">
	<tr>
		<td> <%=i %></td>
		<td>${comment.text}</td>
		<td>${comment.grade}</td>
	 	<%i++; %>
		
	</tr>
	</c:forEach>

</table>
<br>
Restorant Rate:
${requestScope.rate}
<br>

RESTORANT Articls:
<% i = 0; %>
<table>
<tr>
		<td> index</td>
		<td>Ime</td>
		<td>Opis</td>
		<td>Price</td>
		<td>Slika</td>
		<td> Dodaj </td>
		<td> </td>
		</tr>
<c:forEach items="${requestScope.articls}" var="articl">
	<tr>
		<td> <%=i %></td>
		<td>${articl.name}</td>
		<td>${articl.opis}</td>
		<td>${articl.price}</td>
		<td>${articl.image}</td>
		
		<form action="AddArticalToBasket" method="GET"> 
			<input type="hidden" name="idArtical" value="${articl.id}">
			<td> <input type="number" name="amountOfArtical" min="1" max="1000"> </td>
			<td> <button type="submit">Add</button> </td>
		</form>
	 	<%i++; %>
		
	</tr>
	</c:forEach>

</table>

<br>
<br>
<br>
<a href="BasketServlet">KORPA</a>

<br>


</body>
</html>