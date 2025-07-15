package com.ssn.login_register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/register-handler")

public class Register implements Servlet {

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
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();

		out.print("Register Successful....");
		final String url = "jdbc:oracle:thin:@localhost:1521:XE";
		final String userName = "ADV_JAVA_DB";
		final String password = "123";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print(e.getMessage());
		}
		try (Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement ps = con
						.prepareStatement("INSERT INTO USER_REGISTER (FULL_NAME,EMAIL,PASSWORD) VALUES(?,?,?)");) {

			//out.print("Connection Successful....");
			String fullName = req.getParameter("name");
			String email = req.getParameter("email");
			String password2 = req.getParameter("password");
			String confirm_password = req.getParameter("confirm_password");

			if (password2.equals(confirm_password)) {
				ps.setString(1, fullName);
				ps.setString(2, email);
				ps.setString(3, password);

				int executeUpdate = ps.executeUpdate();
				if (executeUpdate >= 0) {
					// ✅ Forward to success page
					req.setAttribute("username", fullName);
					RequestDispatcher dispatcher = req.getRequestDispatcher("registration-success.jsp");
					dispatcher.forward(req, resp);
				}

			} else {
				out.print("Password Mismatch..");
			}

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			out.print(e.getMessage());
			e.printStackTrace();
		}

	}

}
