<%@page import="com.lti.service.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
</head>
<body>
<%
	Employee emp = (Employee) session.getAttribute("employeeData");
%>
Employee Id : <%= emp.getEmployeeId() %> <br/>
Firstname : <%= emp.getFirstName() %> <br/>
Lastname : <%= emp.getLastName() %> <br/>
Email : <%= emp.getEmail() %> <br/>
Phone Number : <%= emp.getPhoneNumber() %> <br/>
Hire Date : <%= emp.getHireDate() %> <br/>
Salary : <%= emp.getSalary() %> <br/>
</body>
</html>