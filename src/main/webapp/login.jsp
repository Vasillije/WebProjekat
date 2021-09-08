<%@page contentType="text/html; charset=UTF-8" %>
<html>
<style type="text/css">
body
{
background-color: Bisque;
 background-image: url('image/welcome.jpg');
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
<form action="LoginServlet" method="POST">
<table>
	<tr>
		<td>Username</td>
		<td><input type="text" name ="username"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name ="password"/></td>
	</tr>
	<tr><td><input type="submit" value="Login"></td></tr>
</table>
</form>
	<% if (request.getAttribute("error") != null) { %>
		<p style="color: red"><%=request.getAttribute("error")%></p>
	<% } %>
</body>
</html>