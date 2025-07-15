<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Beans.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product Page</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: 'Poppins', sans-serif;
            height: 100vh;
            background: linear-gradient(135deg, #1f4037, #99f2c8);
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            background: rgba(255, 255, 255, 0.1);
            padding: 35px 30px;
            border-radius: 20px;
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
            backdrop-filter: blur(10px);
            -webkit-backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.18);
            text-align: center;
            width: 90%;
            max-width: 500px;
            color: #fff;
        }
        h3 {
            font-size: 26px;
            font-weight: 600;
            margin-bottom: 15px;
            color: #00e6e6;
            text-shadow: 0 0 10px #00e6e6;
        }
        .message {
            font-size: 18px;
            color: #d1d1d1;
            margin-bottom: 25px;
        }
        .actions {
            display: flex;
            justify-content: center;
            gap: 20px;
            flex-wrap: wrap;
        }
        .actions a {
            padding: 12px 25px;
            background: linear-gradient(45deg, #ff4b2b, #ff416c);
            color: #fff;
            text-decoration: none;
            border-radius: 50px;
            font-weight: 600;
            box-shadow: 0 8px 15px rgba(255, 65, 108, 0.4);
            transition: all 0.4s ease;
            font-size: 15px;
            letter-spacing: 1px;
            border: 2px solid transparent;
        }
        .actions a:hover {
            background: linear-gradient(45deg, #43cea2, #185a9d);
            box-shadow: 0 12px 20px rgba(67, 206, 162, 0.6);
            transform: scale(1.05);
            border: 2px solid #fff;
        }
        .actions a:active {
            transform: scale(0.98);
        }

        @media(max-width: 500px) {
            .actions {
                flex-direction: column;
                gap: 15px;
            }
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
    <p class="message"><%= msg %></p>
    <div class="actions">
        <a href="viewProducts">View All Products</a>
        <a href="logout">Logout</a>
    </div>
</div>
</body>
</html>
