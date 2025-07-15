<%@page import="javax.swing.text.DefaultEditorKit.CutAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Beans.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Buy Product</title>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

    body {
        font-family: 'Roboto', Arial, sans-serif;
        background: linear-gradient(135deg, #e3f2fd, #bbdefb);
        margin: 0;
        padding: 50px 10px;
        display: flex;
        justify-content: center;
        align-items: flex-start;
        min-height: 100vh;
    }

    .container {
        background: #fff;
        max-width: 520px;
        width: 100%;
        padding: 30px 35px;
        border-radius: 15px;
        box-shadow: 0 12px 28px rgba(0, 0, 0, 0.12);
        text-align: center;
    }

    h1 {
        color: #1565c0;
        font-weight: 700;
        margin-bottom: 25px;
        font-size: 2.2rem;
    }

    p {
        font-size: 1.1rem;
        color: #0d47a1;
        margin-bottom: 35px;
        font-weight: 600;
    }

    table {
        width: 100%;
        border-collapse: separate;
        border-spacing: 0 15px;
    }

    table tr {
        background: #f5faff;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(21, 101, 192, 0.1);
    }

    table td {
        padding: 15px 20px;
        vertical-align: middle;
        font-size: 1rem;
        color: #1e3a8a;
    }

    table td:first-child {
        font-weight: 600;
        text-align: left;
        width: 40%;
        border-radius: 10px 0 0 10px;
    }

    table td:last-child {
        border-radius: 0 10px 10px 0;
    }

    input[type="text"] {
        width: 100%;
        padding: 12px 15px;
        font-size: 1rem;
        border: 2px solid #90caf9;
        border-radius: 8px;
        outline-color: #1565c0;
        transition: border-color 0.3s ease;
    }

    input[type="text"]:focus {
        border-color: #0d47a1;
    }

    input[type="submit"] {
        background-color: #1565c0;
        color: #fff;
        border: none;
        border-radius: 30px;
        padding: 14px 30px;
        font-size: 1.1rem;
        font-weight: 700;
        cursor: pointer;
        margin-top: 20px;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #0d47a1;
    }

    @media (max-width: 480px) {
        .container {
            padding: 25px 20px;
        }
        h1 {
            font-size: 1.8rem;
        }
        table td {
            font-size: 0.95rem;
            padding: 12px 15px;
        }
        input[type="text"], input[type="submit"] {
            font-size: 1rem;
            padding: 12px 20px;
        }
    }
</style>
</head>
<body>
<div class="container">
    <h1>Buy Product</h1>
    <p>
        <%
            ProductBean pb = (ProductBean) request.getAttribute("pb");
            CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
            out.println("Page Belongs To: " + cb.getFirstName());
        %>
    </p>
    <form action="billProduct" method="get">
        <table>
            <tr>
                <td>Code:</td>
                <td><%= pb.getCode() %></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><%= pb.getName() %></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>₹ <%= pb.getPrice() %></td>
            </tr>
            <tr>
                <td>Stock:</td>
                <td><%= pb.getQty() %></td>
            </tr>
            <tr>
                <td>Required Qty:</td>
                <td>
                    <input type="text" name="reqqty" placeholder="Enter quantity" required pattern="[0-9]+" title="Please enter a valid number" />
                    <input type="hidden" name="pcode" value="<%= pb.getCode() %>" />
                </td>
            </tr>
        </table>
        <input type="submit" value="Buy Product" />
    </form>
</div>
</body>
</html>
