<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page - Enhanced Visibility</title>
    <style>
        body, p {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #6a11cb, #2575fc);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background: rgba(255, 255, 255, 0.2);
            backdrop-filter: blur(10px);
            border-radius: 15px;
            box-shadow: 0 8px 32px rgba(0,0,0,0.2);
            padding: 30px 40px;
            width: 400px;
            color: #fff;
            text-align: center;
        }

        p {
            font-size: 18px;
            font-weight: 500;
            color: #f1f1f1;
            text-shadow: 1px 1px 2px #000;
            margin-bottom: 20px;
        }

        @media (max-width: 500px) {
            .container {
                width: 90%;
                padding: 20px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <% String msg = (String) request.getAttribute("msg"); %>
        <p><%= (msg != null) ? msg : "Welcome to Home Page!" %></p>
    </div>
    
    <jsp:include page="htmlFile/Home.html"></jsp:include>
</body>
</html>
