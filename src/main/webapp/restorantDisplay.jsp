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
<form action="RestorantDisplayServlet" method="POST">
<table>
	<tr>
		<td>RestorantNumber</td>
		<td>RestorantName</td>
		<td>Restorant OPEN???</td>
	</tr>
	<%int i = 0; %>
	<c:forEach items="${requestScope.restorants}" var="restorant">
	<tr>
		<td> <%=i %></td>
		<td><a href="RestorantDisplayDetailedServlet?id=${restorant.id}">${restorant.name}</a></td>
		
		<td>${restorant.status}</td>
	 	<%i++; %>
		
	</tr>
	</c:forEach>
</table>
<br>
SEARCHING BY:
<br>
<select name="searchType">
	  	<option value="restName">Restorant Name</option>
	  	<option value="restType"> Restorant Type </option>
 		<option value="restLocation"> restorant Location</option>
 		<option value="restRate">restorant rate </option>	  		
</select>
<br>

<input type="text" name ="searchValue"/>
<br>
Sortiranje---------------------------> izaberi kriterijum

<br>
<select name="sortingCrit">
		<option value="noSort">no Sort</option>
	  	<option value="restName">Restorant Name</option>
 		<option value="restLocation"> restorant Location</option>
 		<option value="restRate">restorant rate </option>	  		
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

FILTERING TYPE
<select name="filteringType">
		<option value="noFilter">no Filter</option>
	  	<c:forEach items="${requestScope.types}" var="type">
		<option value= "${type}"> ${type} </option>
		
	</c:forEach> 		
</select>

<br>
<br>

FILTERING OPEN
<select name="filteringOpen">
		<option value="noFilter">no Filter</option>
		<c:forEach items="${requestScope.status}" var="status">
		<option value= "${status}"> ${status} </option>
		
		</c:forEach> 
	  	 		
</select>
<br>
<input type="submit" value="Search">

</form>
</body>
</html>