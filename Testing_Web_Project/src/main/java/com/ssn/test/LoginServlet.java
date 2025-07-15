package com.ssn.test;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT id FROM users2 WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password); // Hash this in production!
            ResultSet rs = ps.executeQuery();
            boolean nextStatus=rs.next();
            PrintWriter out =response.getWriter();
            out.print("rs.next() value: "+nextStatus);

            if (nextStatus) {
                int userId = rs.getInt("id");

                String token = UUID.randomUUID().toString();
                Timestamp expiry = new Timestamp(System.currentTimeMillis() +
                        (remember != null ? 30L * 24 * 60 * 60 * 1000 : 30 * 60 * 1000)); // 30 days or 30 mins

                PreparedStatement insert = conn.prepareStatement(
                    "INSERT INTO login_tokens (token, user_id, expiry_date) VALUES (?, ?, ?)"
                );
                insert.setString(1, token);
                insert.setInt(2, userId);
                insert.setTimestamp(3, expiry);
                insert.executeUpdate();

                Cookie cookie = new Cookie("auth_token", token);
                cookie.setHttpOnly(true);
                cookie.setSecure(true); // Only for HTTPS
                cookie.setPath("/");
                cookie.setMaxAge((int) (remember != null ? 30L * 24 * 60 * 60 : 30 * 60));
                cookie.setAttribute("SameSite", "Strict");
                
                response.addCookie(cookie);

                response.sendRedirect("home.jsp");
            } else {
                response.getWriter().println("Invalid credentials");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
