<%@page import="Beans.ProductBean"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, Beans.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background: linear-gradient(135deg, #667eea, #764ba2);
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            max-width: 900px;
            margin: 50px auto;
            padding: 30px;
            background: rgba(255, 255, 255, 0.15);
            border-radius: 15px;
            backdrop-filter: blur(8px);
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
            color: #fff;
        }
        h3 {
            text-align: center;
            font-size: 28px;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            overflow: hidden;
            border-radius: 10px;
        }
        th, td {
            padding: 12px 15px;
            text-align: center;
        }
        th {
            background-color: rgba(0,0,0,0.7);
            color: #fff;
            font-size: 16px;
        }
        tr {
            background-color: rgba(255,255,255,0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
        tr:hover {
            transform: scale(1.02);
            box-shadow: 0 8px 16px rgba(0,0,0,0.3);
        }
        a.action {
            text-decoration: none;
            padding: 6px 12px;
            border-radius: 20px;
            font-size: 14px;
            color: #fff;
            background: #00c6ff;
            background: linear-gradient(to right, #0072ff, #00c6ff);
            transition: background 0.3s ease;
        }
        a.action:hover {
            background: linear-gradient(to right, #f85032, #e73827);
        }
        .links {
            margin-top: 20px;
            text-align: center;
        }
        .links a {
            text-decoration: none;
            background: #ff6a00;
            background: linear-gradient(to right, #ee0979, #ff6a00);
            color: #fff;
            padding: 10px 20px;
            margin: 10px;
            border-radius: 30px;
            transition: transform 0.3s ease;
            display: inline-block;
        }
        .links a:hover {
            transform: scale(1.1);
            background: linear-gradient(to right, #56ab2f, #a8e063);
        }
    </style>
</head>
<body>
    <div class="container">
        <%
        UserBean ub = (UserBean) session.getAttribute("ubean");
        ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("al");
        %>
        <h3>Welcome, <%= ub.getUserName() %>! Here is your Product List:</h3>
        <%
        if(al.isEmpty()) {
        %>
            <p style="text-align:center;">No products available currently.</p>
        <%
        } else {
        %>
        <table>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Action</th>
            </tr>
            <%
            Iterator<ProductBean> it = al.iterator();
            while (it.hasNext()) {
                ProductBean pb = it.next();
            %>
            <tr>
                <td><%= pb.getCode() %></td>
                <td><%= pb.getName() %></td>
                <td><%= pb.getPrice() %></td>
                <td><%= pb.getQty() %></td>
                <td>
                    <a class="action" href='editproduct?pcode=<%= pb.getCode() %>'>Edit</a>
                    &nbsp;
                    <a class="action" href='deleteproduct?pcode=<%= pb.getCode() %>'>Delete</a>
                </td>
            </tr>
            <%
            }
            %>
        </table>
        <%
        }
        %>
        <div class="links">
            <a href="productadd.html">➕ Add Product</a>
            <a href="logout">🚪 Logout</a>
        </div>
    </div>
</body>
</html>
