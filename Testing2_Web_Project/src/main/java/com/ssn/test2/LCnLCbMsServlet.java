package com.ssn.test2;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LCnLCbMsServlet")
public class LCnLCbMsServlet extends HttpServlet {

	static {
		System.out.println("Servlet SB is executed, class is loaded");
	}

	public LCnLCbMsServlet() {
		System.out.println("Servlet NPC is executed, class is instantiated");
	}

//==========================================================================	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("Servlet init(SConfig) is executed, object is initialized,");
//	}

//	@Override
//	public void init() throws ServletException {
//		System.out.println("Servlet np init() is executed, object is initialized,");
//	}
//==========================================================================	

//	@Override
//	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
//		System.out.println("Servlet service(SR, SR) is executed, request is processed");
//
//		resp.getWriter().println("Check Server Console");
//	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("Servlet service(HSR, HSR) is executed, request is processed");
//
//		resp.getWriter().println("Check Server Console");
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet doGet(HSR, HSR) is executed, request is processed");

		resp.getWriter().println("Check Server Console");
	}

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("Servlet doPost(HSR, HSR) is executed, request is processed");
//
//		
//		resp.getWriter().println("Check Server Console");
//	}

//==========================================================================	
//	@Override
//	public void destroy() {
//		System.out.println("Servlet destroy() is executed, servlet is removed");
//	}
//==========================================================================	

}