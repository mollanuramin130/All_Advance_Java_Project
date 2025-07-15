<!-- 
 -->
<%@ page import="java.sql.*" %>
<%@ page import="com.ssn.test.*" %>
<%
    String token = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("auth_token".equals(c.getName())) {
                token = c.getValue();
            }
        }
    }

    String username = null;
    if (token != null) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT u.username FROM users u JOIN login_tokens t ON u.id = t.user_id WHERE t.token = ? AND t.expiry_date > CURRENT_TIMESTAMP"
            );
            ps.setString(1, token);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                username = rs.getString("username");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>
<!DOCTYPE html>
<html>
<head><title>Home</title></head>
<body>
    <% if (username != null) { %>
        <h2>Welcome, <%= username %>!</h2>
        <form action="LogoutServlet" method="post">
            <input type="submit" value="Logout">
        </form>
    <% } else { %>
        <h3>You are not logged in. <a href="login.jsp">Login</a></h3>
    <% } %>
</body>
</html>
