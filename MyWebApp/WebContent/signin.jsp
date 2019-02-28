<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"  href="login.css">
<meta charset="ISO-8859-1">
<title>:AUTHENTICATE:</title>
</head>
<body>

	<form method="post" action="logserv">
		<div><table>
			<tr><th>DATA</th>
			<th>CONFIDENTIAL</th></tr>
			<tr>
				<td><label>USER_ID:</label></td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td><label>PASS_ID:</label></td>
				<td><input type="password" name="pname"></td>
			</tr>
		</table></div>
		<button type="submit">LOGIN</button>
			 <%--  <%=if(!session.getAttribute("loggedInUser") %>
	<h1>	<%=session.getAttribute("error-message") %></h1>	</form> --%>	
<%
	String message=(String) session.getAttribute("message");
if(message!=null)
	out.println("<b>" + message+ "</b>");
session.removeAttribute("message");
%>
</body>
</html>