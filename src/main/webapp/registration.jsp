<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
</head>
<body>
<form action="RegistrationServlet" method="POST">
<table>


<!-- 
	private LocalDate birdth;
	private Role role;


 -->
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
	
	
	<tr><td><input type="submit" value="Login"></td></tr>
	
</table>
</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("error") != null) { %>
		<p style="color: red"><%=request.getAttribute("error")%></p>
	<% } %>
</body>
</html>