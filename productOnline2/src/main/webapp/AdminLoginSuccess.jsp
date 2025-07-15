<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Beans.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Success</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(270deg, #ff6ec4, #7873f5, #48c6ef, #6f86d6);
            background-size: 800% 800%;
            animation: gradientShift 15s ease infinite;
            color: #fff;
        }

        @keyframes gradientShift {
            0% {background-position: 0% 50%;}
            50% {background-position: 100% 50%;}
            100% {background-position: 0% 50%;}
        }

        .container {
            background: rgba(255, 255, 255, 0.15);
            border-radius: 15px;
            padding: 30px 40px;
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
            backdrop-filter: blur(8px);
            text-align: center;
            width: 90%;
            max-width: 450px;
        }

        h3 {
            font-size: 24px;
            margin-bottom: 20px;
            font-weight: 600;
            letter-spacing: 1px;
        }

        .navigation {
            margin-top: 30px;
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
        }

        .navigation a {
            text-decoration: none;
            color: #fff;
            background: rgba(255, 255, 255, 0.2);
            padding: 12px 20px;
            margin: 10px;
            border-radius: 30px;
            transition: all 0.4s ease;
            box-shadow: 0 5px 15px rgba(0,0,0,0.3);
            display: flex;
            align-items: center;
            gap: 8px;
            font-weight: 500;
        }

        .navigation a:hover {
            background: #fff;
            color: #6f86d6;
            transform: scale(1.1);
            box-shadow: 0 8px 20px rgba(0,0,0,0.4);
        }

        .material-icons {
            vertical-align: middle;
        }

        @media screen and (max-width: 500px) {
            .navigation {
                flex-direction: column;
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
        <h3><%= msg %> <%= ub.getUserName() %> 🎉</h3>

        <div class="navigation">
            <a href="productadd.html"><span class="material-icons">add_box</span> Add Product</a>
            <a href="viewProducts"><span class="material-icons">view_list</span> View Products</a>
            <a href="logout"><span class="material-icons">logout</span> Logout</a>
        </div>
    </div>
</body>
</html>
