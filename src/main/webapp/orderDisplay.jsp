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
<form action="UserOrderDisplayServlet" method="POST">
<table>
	<tr>
		<td>OrderNumber</td>
		<td>RestorantName</td>
		<td>Restorant Cena</td>
		<td> Order Date</td>
	</tr>
	<%int i = 1; %>
	<c:forEach items="${requestScope.orders}" var="order">
	<tr>
		<td> <%=i %></td>
		<td>${order.restorant.name}</td>
		
		<td>${order.cena}</td>
		<td>${order.date}</td>
	 	<%i++; %>
		
	</tr>
	</c:forEach>
</table>

<br>
SEARCHING BY:
<br>
<select name="searchType">
		<c:if test="${sessionScope.user.type != UserType.MANAGER}">
  			<option value="restName">Restorant Name</option>
		</c:if>
	  	<option value="orderPrice"> Order Price </option>
 		<option value="orderDate"> order Date</option>	  		
</select>
<br>

<input type="text" name ="searchValueFrom"/>
<input type="text" name ="searchValueTo"/>
<br>

<br>
<br>

Sortiranje---------------------------> izaberi kriterijum

<br>
<select name="sortingCrit">
		<option value="noSort">no Sort</option>
		<c:if test="${sessionScope.user.type != UserType.MANAGER}">
  			<option value="restName">Restorant Name</option>
		</c:if>
 		<option value="orderPrice"> Order Price</option>
 		<option value="restDate"> Restorant Date </option>	  		
</select>

<br>
<br>
ORDER???
<br>
<select name="sortingOrder">
	  	<option value="growing">growing</option>
 		<option value="descending"> descending</option>  		
</select>
<br>
<br>

<c:if test="${sessionScope.user.type != UserType.MANAGER}">
  			

FILTERING Restorant TYPE
<select name="filteringType">
		<option value="noFilter">no Filter</option>
	  	<c:forEach items="${requestScope.types}" var="type">
		<option value= "${type}"> ${type} </option>
		
	</c:forEach> 		
</select>
</c:if>

<br>
<br>

Order STATUS
<select name="filteringOpen">
		<option value="noFilter">no Filter</option>
		<c:forEach items="${requestScope.status}" var="status">
		<option value= "${status}"> ${status} </option>
		
		</c:forEach> 
	  	 		
</select>
<br>


</form>
	<% if (request.getAttribute("error") != null) { %>
		<p style="color: red"><%=request.getAttribute("error")%></p>
	<% } %>
treba da se ubaci samo nedostavljene porudzbine
</body>

</html>