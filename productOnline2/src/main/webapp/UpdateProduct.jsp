<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product Page</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
<style>
    body {
        font-family: 'Poppins', sans-serif;
        background: linear-gradient(135deg, #1e3c72, #2a5298);
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        width: 450px;
        padding: 30px;
        background: rgba(255, 255, 255, 0.15);
        border-radius: 20px;
        backdrop-filter: blur(10px);
        box-shadow: 0 8px 32px rgba(31, 38, 135, 0.37);
        text-align: center;
        border: 1px solid rgba(255, 255, 255, 0.18);
        color: #fff;
    }

    h3 {
        font-size: 26px;
        margin-bottom: 15px;
        font-weight: 600;
    }

    p {
        font-size: 16px;
        margin-bottom: 30px;
        color: #e0e0e0;
    }

    .button-container {
        display: flex;
        justify-content: center;
        gap: 15px;
        flex-wrap: wrap;
    }

    .button {
        padding: 12px 22px;
        background: linear-gradient(45deg, #6a11cb, #2575fc);
        color: #fff;
        text-decoration: none;
        border-radius: 50px;
        font-weight: 600;
        font-size: 14px;
        transition: all 0.4s ease;
        box-shadow: 0 5px 15px rgba(90, 61, 255, 0.5);
        letter-spacing: 1px;
    }

    .button:hover {
        background: linear-gradient(45deg, #43e97b, #38f9d7);
        box-shadow: 0 8px 25px rgba(67, 233, 123, 0.6);
        transform: translateY(-4px);
    }

    .button:active {
        transform: translateY(-2px);
        box-shadow: 0 4px 10px rgba(67, 233, 123, 0.4);
    }
</style>
</head>
<body>
    <div class="container">
        <%
            String msg = (String) request.getAttribute("msg");
            UserBean ub = (UserBean) session.getAttribute("ubean");
        %>
        <h3>Welcome, <%= ub.getFirstName() %>!</h3>
        <p><%= msg %></p>

        <div class="button-container">
            <a href="productadd.html" class="button">Add Product</a>
            <a href="viewProducts" class="button">View All Products</a>
            <a href="logout" class="button">Logout</a>
        </div>
    </div>
</body>
</html>
