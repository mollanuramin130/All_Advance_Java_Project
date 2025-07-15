

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rs")
public class RegisterServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE"; // Change as per your DB
    private static final String DB_USER = "ADV_JAVA_DB";
    private static final String DB_PASSWORD = "123";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set encoding for form parameters
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Get parameters from form
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String dobStr = request.getParameter("dob");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");

        // Basic validation (you can expand)
        if (fullname == null || username == null || email == null || password == null || dobStr == null
                || fullname.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || dobStr.isEmpty()) {
            response.getWriter().println("<h3 style='color:red;'>Please fill all required fields!</h3>");
            return;
        }

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to DB
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Convert String dob to java.sql.Date
            Date dob = Date.valueOf(dobStr); // format: yyyy-MM-dd

            // SQL Insert Query
            String sql = "INSERT INTO USERS (FULLNAME, USERNAME, EMAIL, PASSWORD, GENDER, DOB, MOBILE, ADDRESS) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, fullname);
            ps.setString(2, username);
            ps.setString(3, email);
            ps.setString(4, password);  // Ideally hash password before storing!
            ps.setString(5, gender);
            ps.setDate(6, dob);
            ps.setString(7, mobile);
            ps.setString(8, address);

            int rows = ps.executeUpdate();

            if (rows > 0) {
            	/*
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().println("<html><head><title>Success</title></head><body>");
                response.getWriter().println("<script>");
                response.getWriter().println("window.open('', '_blank', 'width=400,height=300').document.write(" +
                    "'<h2 style=\"color:green; font-family:sans-serif; text-align:center; margin-top:50px;\">Registration Successful!</h2>' + " +
                    "'<p style=\"text-align:center;\">Thank you for registering with us.</p>' + " +
                    "'<button onclick=\"window.close()\" style=\"display:block; margin:20px auto; padding:10px 20px; font-size:16px;\">Close</button>'" +
                    ");");
                response.getWriter().println("</script>");
                response.getWriter().println("<h3>Registration successful! A new window/tab has opened.</h3>");
                response.getWriter().println("<a href='register.jsp'>Go back to Register page</a>");
                response.getWriter().println("</body></html>");
                */
            	request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("fullname", fullname);
                response.sendRedirect("registration_success.jsp");

            } else {
                response.getWriter().println("<h3 style='color:red;'>Registration Failed. Try again.</h3>");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().println("<h3 style='color:red;'>Oracle JDBC Driver not found!</h3>");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<h3 style='color:red;'>Database Error: " + e.getMessage() + "</h3>");
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

