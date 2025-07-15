<%@page import="Beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard Page</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
<style>
    body {
        font-family: 'Poppins', sans-serif;
        background: linear-gradient(135deg, #667eea, #764ba2);
        margin: 0;
        padding: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        width: 500px;
        padding: 30px;
        background: rgba(255, 255, 255, 0.1);
        border-radius: 20px;
        box-shadow: 0 8px 32px rgba(31, 38, 135, 0.37);
        backdrop-filter: blur(8px);
        border: 1px solid rgba(255, 255, 255, 0.18);
        text-align: center;
        color: #fff;
    }

    h3 {
        font-size: 24px;
        font-weight: 600;
        margin-bottom: 15px;
    }

    .message {
        font-size: 18px;
        color: #e0e0e0;
        margin: 20px 0;
    }

    .actions {
        margin-top: 20px;
        display: flex;
        justify-content: center;
        gap: 15px;
        flex-wrap: wrap;
    }

    .actions a {
        text-decoration: none;
        padding: 12px 20px;
        background: linear-gradient(to right, #6a11cb, #2575fc);
        color: #fff;
        border-radius: 30px;
        font-weight: 600;
        font-size: 14px;
        transition: all 0.4s ease;
        box-shadow: 0 5px 15px rgba(90, 61, 255, 0.5);
        letter-spacing: 1px;
    }

    .actions a:hover {
        background: linear-gradient(to right, #43e97b, #38f9d7);
        box-shadow: 0 8px 20px rgba(67, 233, 123, 0.6);
        transform: translateY(-4px);
    }

    .actions a:active {
        transform: translateY(-2px);
        box-shadow: 0 4px 10px rgba(67, 233, 123, 0.4);
    }
</style>
</head>
<body>
<div class="container">
    <%
    String mgs = (String) request.getAttribute("msg");
    UserBean ub = (UserBean) session.getAttribute("ubean");
    %>
    <h3>Welcome, <%= ub.getFirstName() %>!</h3>
    <p class="message"><%= mgs %></p>
    <div class="actions">
        <a href="productadd.html">Add Product</a>
        <a href="viewProducts">View All Products</a>
        <a href="logout">Logout</a>
    </div>
</div>
</body>
</html>
