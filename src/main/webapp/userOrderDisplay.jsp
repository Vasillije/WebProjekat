<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style type="text/css">
body
{
background-color: Bisque;
 background-image: url('image/burgeri.jpg');
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
table
{
	color : white;
}

h3
{
	color : white;
}
h1
{
	color : white;
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
<h1> Customer </h1>
<form action="OrderDisplayServlet" method="POST">
<table>
	<tr>
		<td>OrderNumber</td>
		<td>RestorantName</td>
		<td>Restorant Cena</td>
		<td> Order Date</td>
		<td> Order Status</td>
	</tr>
	<%int i = 1; %>
	<c:forEach items="${requestScope.orders}" var="order">
	<tr>
		<td> <%=i %></td>
		<td>${order.restorant.name}</td>
		
		<td>${order.cena}</td>
		<td>${order.date}</td>
		<td>${order.status}</td>
	 	<%i++; %>
		
	</tr>
	</c:forEach>
</table>

<br>
<h3>SEARCHING BY:</h3>
<br>
<select name="searchType">
	  	<option value="restName">Restorant Name</option>
	  	<option value="orderPrice"> Order Price </option>
 		<option value="orderDate"> order Date</option>	  		
</select>
<br>

<input type="text" name ="searchValueFrom"/>
<input type="text" name ="searchValueTo"/>
<br>

<!-- 

	<input type="date" name ="searchDateStart"/>  <input type="date" name ="searchDateEnd"/>

	<input type="time" name ="searchTimeStart"/>                                          <input type="time" name ="searchTimeEnd"/>
-->


<br>
<br>

<h3>Sortiranje---------------------------> izaberi kriterijum</h3>

<br>
<select name="sortingCrit">
		<option value="noSort">no Sort</option>
	  	<option value="restName">Restorant Name</option>
 		<option value="orderPrice"> Order Price</option>
 		<option value="restDate"> Restorant Date </option>	  		
</select>

<br>
<br>
<h3>ORDER???</h3>
<br>
<select name="sortingOrder">
	  	<option value="growing">growing</option>
 		<option value="descending"> descending</option>  		
</select>
<br>
<br>

<h3>FILTERING Restorant TYPE</h3>
<select name="filteringRestorantType">
		<option value="noFilter">no Filter</option>
	  	<c:forEach items="${requestScope.types}" var="type">
		<option value= "${type}"> ${type} </option>
		
	</c:forEach> 		
</select>

<br>
<br>

<h3>Order STATUS</h3>
<select name="filteringOrderStatus">
		<option value="noFilter">no Filter</option>
		<c:forEach items="${requestScope.status}" var="status">
		<option value= "${status}"> ${status} </option>
		
		</c:forEach> 
	  	 		
</select>
<br>


<button type="submit">Add</button>

</form>
	<% if (request.getAttribute("error") != null) { %>
		<p style="color: red"><%=request.getAttribute("error")%></p>
	<% } %>

</body>
</html>