package com.ssn.servlet_to_servlet;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class PrimeOrNotServlet extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("number"));

        response.setContentType("text/html");
        response.getWriter().println("<div style='color: green; font-size: 18px; font-weight: bold;'>");
        boolean flag=true;
        for(int i=2;i<=num/2;i++) {
        	if(num%i==0) {
        		flag=false;
        		break;
        	}
        }
        if(flag) {
        	
        	response.getWriter().println("Your Given Number: " + num + "is<b style='color:blue'> a Prime Number..</b>"+"<br>");
        }else {
        	response.getWriter().println("Your Given Number: " + num + " is<b style='color:red'> not a Prime Number..<b>"+"<br>");
			
		}
        response.getWriter().println("</div>");

        RequestDispatcher rd = request.getRequestDispatcher("numberCal.html");
        rd.include(request, response);
    }
}
