<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">
body
{
background-color: Bisque;
 background-image: url('image/meni.jpg');
 background-repeat : no-repeat;
 background-size: 100% 100%;
 background-attachment: fixed;

}

table
{
color: white;
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



<form action="CreateArticalServlet" method="POST">
<table>

	<tr>
		<td>Name</td>
		<td><input type="text" name ="name"/></td>
	</tr>
	<tr>
		<td>Price</td>
		<td><input type="text" name ="price"/></td>
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