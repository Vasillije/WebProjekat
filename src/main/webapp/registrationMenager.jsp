<%@page contentType="text/html; charset=UTF-8" %>
<html>
<style type="text/css">
body
{
background-color: Bisque;
 background-image: url('image/gradjevina.jpg');
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

</style>
<head>
</head>
<div>
<span>expressdostava.com</span>
</div>
<body>
<form action="RegistrationMenagerServlet" method="POST">
<input type="hidden" name="restID" value="${requestScope.restID}">
<table>
	
	<tr>
		<td>Username</td>
		<td><input type="text" name ="username"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name ="password"/></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><input type="text" name ="name"/></td>
	</tr>
	<tr>
		<td>Surname</td>
		<td><input type="text" name ="surname"/></td>
	</tr>
	
	<tr>
	
	<td>Gender</td>
	<td>
		<select name="gender">
	  		<option value="MALE">MUSKI POL</option>
	  		<option value="FEMALE">ZENSKI POL</option>
		</select>
	</td> 
	
	</tr>
	
	<tr>
	
	<td>Date</td>
	<td>
		<input type="date"  name="dateBirth">
	</td> 
	
	</tr>
	
	
	
	<tr>
	
	<td>Type</td>
	<td>
		<select name="type">
	  		<option value="SHIPPER">SHIPPER</option>
	  		<option value="MANAGER">MANAGER</option>
		</select>
	</td> 
	
	</tr>
	
	
	<tr><td><input type="submit" value="Register"></td></tr>
	
</table>
</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("error") != null) { %>
		<p style="color: red"><%=request.getAttribute("error")%></p>
	<% } %>
</body>
</html>