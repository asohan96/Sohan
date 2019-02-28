package com.lti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.service.Employee;
import com.lti.service.EmployeeService;

@WebServlet("/SearchEmployeeServlet")
public class SearchEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		EmployeeService employeeService = new EmployeeService();
		Employee emp = employeeService.getEmployeeDetails(empId);
		
		HttpSession session = request.getSession();				//users session_id 
		session.setAttribute("employeeData", emp);
		
		response.sendRedirect("searchEmpResult.jsp");
	}
}
