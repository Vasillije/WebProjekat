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
<title>OrderDisplay</title>
</head>
<div>
<span>expressdostava.com</span>
</div>

<body>
<form action="OrderDisplayServlet" method="POST">
<table>
	<tr>
		<td>OrderNumber</td>
		<td>RestorantName</td>
		<td>Restorant Cena</td>
		<td> Order Date</td>
		<td> Order Status</td>
		<td> Order Change</td>
	</tr>
	<%int i = 1; %>
	<c:forEach items="${requestScope.orders}" var="order">
	<tr>
		<td> <%=i %></td>
		<td>${order.restorant.name}</td>
		
		<td>${order.cena}</td>
		<td>${order.date}</td>
		<td>${order.status}</td>
		<td><a href="OrderChangeByAnybodyGoodProjectServlet?orderId=${order.id}">
		<c:choose>
			<c:when test="${order.status == 'PROCESSING'}">
				<c:if test="${sessionScope.user.role == 'CUSTOMER'}">
  					CANCEL
				</c:if>
				<c:if test="${sessionScope.user.role == 'MANAGER'}">
  					ACCEPT
				</c:if>
			</c:when>
			<c:when test="${order.status == 'INPREPARATION'}">
				WAITITNG
			</c:when>
			<c:when test="${order.status == 'WAITING'}">
				DELIVER
			</c:when>
			<c:when test="${order.status == 'INTRANSPORT'}">
				DELIVERED
			</c:when>
			<c:when test="${order.status == 'CANCELED'}">
				
			</c:when>
		</c:choose>
		</a></td>
		
	 	<%i++; %>
		
	</tr>
	</c:forEach>
</table>

<br>
SEARCHING BY:
<br>
<select name="searchType">
		<c:if test="${sessionScope.user.role != Role.MANAGER}">
  			<option value="restName">Restorant Name</option>
		</c:if>
	  	<option value="orderPrice"> Order Price </option>
 		  		
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
		<c:if test="${sessionScope.user.role != Role.MANAGER}">
  			<option value="restName">Restorant Name</option>
		</c:if>
 		<option value="orderPrice"> Order Price</option>
 		<option value="restDate"> Restorant Date </option>	  		
</select>

<br>
<br>
ORDER
<br>
<select name="sortingOrder">
	  	<option value="growing">growing</option>
 		<option value="descending"> descending</option>  		
</select>
<br>
<br>

<c:if test="${sessionScope.user.role != Role.MANAGER}">
  			

FILTERING Restorant TYPE
<select name=filteringRestorantType>
		<option value="noFilter">no Filter</option>
	  	<c:forEach items="${requestScope.types}" var="type">
		<option value= "${type}"> ${type} </option>
		
	</c:forEach> 		
</select>
</c:if>

<br>
<br>

Order STATUS
<select name="filteringOrderStatus">
		<option value="noFilter">no Filter</option>
		<c:forEach items="${requestScope.status}" var="status">
		<option value= "${status}"> ${status} </option>
		</c:forEach> 
</select>
<br>
<input type="submit" value="Find">

</form>
	<% if (request.getAttribute("error") != null) { %>
		<p style="color: red"><%=request.getAttribute("error")%></p>
	<% } %>
treba da se ubaci samo nedostavljene porudzbine
</body>

</html>