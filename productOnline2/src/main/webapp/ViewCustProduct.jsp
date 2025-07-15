<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,Beans.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Customer Product</title>
<style>
    /* Google Fonts */
    @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

    body {
        font-family: 'Roboto', Arial, sans-serif;
        background: linear-gradient(135deg, #e0f2fe, #bae6fd);
        margin: 0;
        padding: 40px 10px;
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: flex-start;
    }
    .container {
        max-width: 900px;
        width: 100%;
        background-color: #ffffff;
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0 8px 25px rgba(14, 30, 37, 0.12);
        text-align: center;
    }
    h3 {
        font-size: 2rem;
        margin-bottom: 25px;
        color: #0c4a6e;
        font-weight: 700;
    }
    table {
        width: 100%;
        border-collapse: separate;
        border-spacing: 0 15px;
        margin-bottom: 30px;
    }
    th, td {
        padding: 15px 20px;
        text-align: left;
        font-size: 1rem;
        color: #333;
    }
    th {
        background-color: #0284c7;
        color: #fff;
        font-weight: 700;
        border-radius: 10px 10px 0 0;
    }
    tbody tr {
        background-color: #f9fafb;
        border-radius: 10px;
        box-shadow: 0 3px 7px rgba(2, 132, 199, 0.15);
        transition: transform 0.3s ease, box-shadow 0.3s ease;
        cursor: default;
    }
    tbody tr:hover {
        background-color: #dbeafe;
        transform: translateY(-3px);
        box-shadow: 0 10px 20px rgba(2, 132, 199, 0.3);
    }
    td a {
        display: inline-block;
        padding: 8px 18px;
        font-weight: 600;
        font-size: 0.95rem;
        color: #0284c7;
        border: 2px solid #0284c7;
        border-radius: 8px;
        text-decoration: none;
        transition: all 0.3s ease;
        user-select: none;
    }
    td a:hover {
        background-color: #0284c7;
        color: white;
    }
    .no-products {
        font-size: 1.2rem;
        color: #555;
        margin: 40px 0;
    }
    .logout-btn {
        display: inline-block;
        background-color: #ef4444;
        color: white;
        padding: 12px 28px;
        border-radius: 30px;
        font-weight: 700;
        font-size: 1rem;
        text-decoration: none;
        box-shadow: 0 4px 12px rgba(239, 68, 68, 0.4);
        transition: background-color 0.3s ease;
    }
    .logout-btn:hover {
        background-color: #b91c1c;
    }
    @media (max-width: 600px) {
        .container {
            padding: 20px 15px;
        }
        th, td {
            padding: 12px 10px;
            font-size: 0.9rem;
        }
        td a {
            padding: 7px 12px;
            font-size: 0.9rem;
        }
    }
</style>
</head>
<body>
<div class="container">
    <%
        CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
        ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("al");
    %>

    <h3>Welcome, <%= cb != null ? cb.getFirstName() : "Customer" %></h3>

    <%
        if (al == null || al.isEmpty()) {
    %>
        <p class="no-products">No products are currently available.</p>
    <%
        } else {
    %>
        <table>
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Price (₹)</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (ProductBean pb : al) {
                %>
                    <tr>
                        <td><%= pb.getCode() %></td>
                        <td><%= pb.getName() %></td>
                        <td><%= pb.getPrice() %></td>
                        <td><%= pb.getQty() %></td>
                        <td><a href='buyproduct?pcode=<%= pb.getCode() %>'>Buy</a></td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    <%
        }
    %>

    <a href="logout" class="logout-btn">Logout</a>
</div>
</body>
</html>
