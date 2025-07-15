package com.ssn.application01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/login")
public class Application01Servlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp ) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=req.getParameter("userId");
		String fName=req.getParameter("fName");
		String lName=req.getParameter("lName");
		String mailId=req.getParameter("mailId");
		String phone=req.getParameter("phone");
		
		PrintWriter out=resp.getWriter();
		out.println("Given UserName is: "+userId+"\nFull Name: "+fName+" "+lName+"\nMaid id:"+
		mailId+"\nPhone Number: "+phone);
		
	}

}
