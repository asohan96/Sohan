package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.lti.service.DBLoginService;
import com.lti.service.InMemoryLoginService;


@WebServlet("/logserv")
public class logserv extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=request.getParameter("uname");
		String password=request.getParameter("pname");
		String user;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		DBLoginService DBloginService=new DBLoginService();
		boolean isValid=DBloginService.isValidUser(username,password);
		String fname=DBloginService.fullname(username);
		if(isValid) {
			
			session.setAttribute("loggedInUser", username); 
			session.setAttribute("namesurname", fname);//its like key and value type
			response.sendRedirect("welcome.jsp");
		}else
		{
			response.sendRedirect("signin.jsp");
			session.setAttribute("message", "INVALID USER?PASS");
		}			
	}

}






















/*if(USER_ID.equals("admin@gmail.com") && PASS_ID.equals("iloveindia"))
{
user=USER_ID;
out.println("<html><body>");
out.println("<h1>WELCOME : "+user+"</h1>");
out.println("</body></html>");
response.sendRedirect("welcome.html");
}
else 
{
user=USER_ID;
out.println("<html><body>");
out.println("<h1>NOT A USER : "+user+"</h1>");
out.println("</body></html>");
response.sendRedirect("signin.html");
}	*/

