
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP EXAMPLE</title>
</head>
<body>
<%													//scriptlet			//its a java code
		String str="Hello Everyone";
%>
<center>
<%
		for(int i=1;i<=6;i++) {
%>
		<font size="<%=i %>">HELLO WORLD</font><br>
	
<%
		}
%>
</center>
<h1><%= str.toUpperCase() %></h1>
</body>
</html>