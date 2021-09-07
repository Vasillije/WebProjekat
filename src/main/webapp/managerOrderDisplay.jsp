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




<br>
SEARCHING BY:
<br>
<select name="searchType">
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
treba da se ubaci samo nedostavljene porudzbine


	<% if (request.getAttribute("error") != null) { %>
		<p style="color: red"><%=request.getAttribute("error")%></p>
	<% } %>



</body>
</html>