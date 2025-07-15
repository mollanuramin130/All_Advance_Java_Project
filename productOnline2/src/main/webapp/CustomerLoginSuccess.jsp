<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" import="Beans.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Dashboard</title>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            font-family: 'Poppins', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
            background-size: 400% 400%;
            animation: gradientBG 15s ease infinite;
        }

        @keyframes gradientBG {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        .container {
            background: rgba(255, 255, 255, 0.2);
            backdrop-filter: blur(8px);
            border-radius: 15px;
            padding: 30px 40px;
            box-shadow: 0 8px 32px rgba(31, 38, 135, 0.37);
            text-align: center;
            color: #fff;
            width: 350px;
            animation: fadeIn 1s ease-out;
        }

        @keyframes fadeIn {
            from {opacity: 0; transform: scale(0.9);}
            to {opacity: 1; transform: scale(1);}
        }

        p {
            font-size: 18px;
            text-shadow: 1px 1px 2px #000;
            margin: 15px 0;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 25px;
            background: linear-gradient(135deg, #00c6ff, #0072ff);
            color: #fff;
            border: none;
            border-radius: 30px;
            text-decoration: none;
            font-size: 16px;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            box-shadow: 0 4px 6px rgba(0,0,0,0.2);
        }

        a:hover {
            transform: scale(1.08);
            box-shadow: 0 6px 12px rgba(0,0,0,0.3);
        }

        @media (max-width: 400px) {
            .container {
                width: 90%;
                padding: 20px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <p>
            <% 
                String msg = (String) request.getAttribute("msg");
                CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
                out.println((msg != null ? msg : "Welcome, ") + cb.getFirstName() + "!");
            %>
        </p>
        <a href="viewCproduct">View Products</a>
    </div>
</body>
</html>
