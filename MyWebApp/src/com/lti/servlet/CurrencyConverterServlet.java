package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CurrencyServlet")
public class CurrencyConverterServlet extends HttpServlet {
	
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//reading request parameters
		String from=request.getParameter("fromCurrency");
		String to=request.getParameter("toCurrency");
		double amount=Double.parseDouble(request.getParameter("amount"));
		double result=0;
		if(from.equals("USD") && to.equals("INR"))
		result=amount*72.72;
		else if(from.equals("INR") && to.equals("USD"))
			result=amount/71.71;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<h1>RESULT OF CONVERSION : "+result+"</h1>");
		out.println("</body></html>");
		
		
	}

}
