<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Beans.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: 'Roboto', sans-serif;
            background: linear-gradient(135deg, #667eea, #764ba2);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            background: rgba(255, 255, 255, 0.15);
            backdrop-filter: blur(12px);
            border-radius: 20px;
            padding: 30px 25px;
            width: 400px;
            box-shadow: 0 8px 32px rgba(31, 38, 135, 0.37);
            border: 1px solid rgba(255, 255, 255, 0.18);
            color: #fff;
            text-align: center;
        }
        h3 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #ffeb3b;
            text-shadow: 0 0 10px #ffeb3b;
        }
        table {
            width: 100%;
            margin-top: 10px;
        }
        table td {
            padding: 12px 0;
            font-size: 16px;
            color: #f1f1f1;
        }
        input[type="text"] {
            width: 95%;
            padding: 10px;
            border: none;
            border-radius: 8px;
            background: rgba(255, 255, 255, 0.3);
            color: #fff;
            font-size: 15px;
            outline: none;
            transition: 0.4s;
        }
        input[type="text"]:focus {
            background: rgba(255, 255, 255, 0.6);
            color: #333;
            box-shadow: 0 0 8px #00e6e6;
        }
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            margin-top: 20px;
            background: linear-gradient(45deg, #43cea2, #185a9d);
            color: #fff;
            border: none;
            border-radius: 25px;
            font-size: 17px;
            font-weight: bold;
            cursor: pointer;
            box-shadow: 0 8px 15px rgba(67, 206, 162, 0.4);
            transition: 0.4s ease;
        }
        input[type="submit"]:hover {
            background: linear-gradient(45deg, #ff4b2b, #ff416c);
            transform: scale(1.05);
            box-shadow: 0 10px 20px rgba(255, 65, 108, 0.5);
        }

        @media(max-width: 450px) {
            .container {
                width: 90%;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            ProductBean pb = (ProductBean) request.getAttribute("pb");
            UserBean ub = (UserBean) session.getAttribute("ubean");
        %>
        <h3>Edit Product - <%= pb.getName() %></h3>

        <form action="updateProduct55" method="post">
            <input type="hidden" name="pcode" value="<%= pb.getCode() %>">
            <table>
                <tr>
                    <td><strong>Product Price:</strong></td>
                    <td><input type="text" name="price" value="<%= pb.getPrice() %>"></td>
                </tr>
                <tr>
                    <td><strong>Product Quantity:</strong></td>
                    <td><input type="text" name="qty" value="<%= pb.getQty() %>"></td>
                </tr>
            </table>
            <input type="submit" value="Update Product">
        </form>
    </div>
</body>
</html>
