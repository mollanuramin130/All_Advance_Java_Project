package com.ssn.servlet_to_servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class CalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		//out.print("Calculation Servlet Calling");
		
		String operationName=request.getParameter("operation").toLowerCase();
		
		//out.print("Operation: "+operationName);
		
		if(operationName.equals("prime")) {
			RequestDispatcher rd = request.getRequestDispatcher("PrimeOrNotServlet");
			rd.forward(request, response);
			
		}else if(operationName.equals("factor")) {
			RequestDispatcher rd = request.getRequestDispatcher("FactorServlet");
			rd.forward(request, response);			
		}else if(operationName.equals("factorial")) {
			RequestDispatcher rd = request.getRequestDispatcher("FactorialServlet");
			rd.forward(request, response);			
		}else if(operationName.equals("square")) {
			RequestDispatcher rd = request.getRequestDispatcher("SquareServlet");
			rd.forward(request, response);			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
