<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<form action="ArticalUpdateServlet" method="POST">
<table>

	<tr>
		<td>Name</td>
		<td><input type="text" placeholder="${requestScope.arical.name}" name ="name"/></td>
	</tr>
	<tr>
		<td>Price</td>
		<td><input type="text" placeholder="${requestScope.arical.price}" name ="price"/></td>
	</tr>
	
	<tr>
	<td>Artical Type</td>
	<td>
		<select name="articalType">
	  		<option value="DRINK">DRINK</option>
	  		<option value="DISH">DISH</option>
		</select>
	</td> 
	</tr>
	
	<tr>
	<td>Image NMP  N !!!</td>
	<td>
		<input type="text"  name="image">
	</td> 
	</tr>
	
	<tr>
	<td>Description(Optional)</td>
	<td>
		<input type="text"  name="description">
	</td> 
	</tr>
	
	<tr>
	<td>Amount(Optional)</td>
	<td>
		<input type="text"  name="amount">
	</td> 
	</tr>
	
	
	
	<tr><td><input type="submit" value="Login"></td></tr>
	
</table>
</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("error") != null) { %>
		<p style="color: red"><%=request.getAttribute("error")%></p>
	<% } %>

</body>
</html>