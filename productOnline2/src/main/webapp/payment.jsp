<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Beans.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Payment Page</title>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap');

    body {
        margin: 0;
        padding: 0;
        font-family: 'Montserrat', Arial, sans-serif;
        background: url('paymentimg.jpeg') no-repeat center center fixed;
        background-size: cover;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    .container {
        background-color: rgba(255, 255, 255, 0.85);
        max-width: 420px;
        width: 90%;
        padding: 35px 30px;
        border-radius: 15px;
        box-shadow: 0 16px 30px rgba(0, 0, 0, 0.2);
        text-align: center;
        color: #222;
    }

    h2 {
        font-weight: 700;
        font-size: 2.4rem;
        margin-bottom: 20px;
        color: #1565c0;
    }

    p.message {
        font-size: 1.2rem;
        margin-bottom: 35px;
        color: #444;
        line-height: 1.4;
    }

    a {
        display: inline-block;
        background-color: #1565c0;
        color: white;
        padding: 12px 28px;
        margin: 0 10px;
        border-radius: 30px;
        font-weight: 600;
        font-size: 1rem;
        text-decoration: none;
        box-shadow: 0 6px 12px rgba(21, 101, 192, 0.4);
        transition: background-color 0.3s ease, box-shadow 0.3s ease;
    }

    a:hover {
        background-color: #0d47a1;
        box-shadow: 0 8px 20px rgba(13, 71, 161, 0.6);
    }

    @media (max-width: 480px) {
        h2 {
            font-size: 2rem;
        }
        .container {
            padding: 30px 20px;
        }
        a {
            padding: 10px 22px;
            margin: 8px 5px;
            font-size: 0.9rem;
        }
    }
</style>
</head>
<body>
<div class="container">
    <%
        CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
        String msg = (String) request.getAttribute("msg");
    %>
    <h2>Welcome, <%= cb.getFirstName() %>!</h2>
    <p class="message"><%= msg %></p>
    <a href="viewCproduct">View All Products</a>
    <a href="logout">Logout</a>
</div>
</body>
</html>
