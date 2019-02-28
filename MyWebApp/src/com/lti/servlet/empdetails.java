package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.service.DBST_EmployeesService;

@WebServlet("/empdetails")
public class empdetails extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String empno=request.getParameter("empno");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		DBST_EmployeesService empservice=new DBST_EmployeesService();
		boolean isValid=DBST_EmployeesService.isValidEmployee(empno);
		String details[]=DBST_EmployeesService.employeeDetails(empno);
		if(isValidEmployee) 
			{
			session.setAttribute("empid", details[0]); 
			session.setAttribute("firstname", details[1]);
			session.setAttribute("salary", details[2]);//its like key and value type
			response.sendRedirect("emp-details.jsp");
	}
		else
		{
			response.sendRedirect("signin.jsp");
			session.setAttribute("message", "INVALID USER?PASS");
		}
}
