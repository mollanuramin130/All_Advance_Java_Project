<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Beans.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Product Bill</title>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

    body {
        font-family: 'Roboto', Arial, sans-serif;
        background: linear-gradient(135deg, #f0f4f8, #d9e2ec);
        margin: 0;
        padding: 50px 10px;
        display: flex;
        justify-content: center;
        align-items: flex-start;
        min-height: 100vh;
    }

    .container {
        background: #fff;
        max-width: 500px;
        width: 100%;
        padding: 30px 35px;
        border-radius: 15px;
        box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
        text-align: center;
    }

    h1 {
        color: #2c7be5;
        margin-bottom: 30px;
        font-weight: 700;
        font-size: 2rem;
    }

    table {
        width: 100%;
        border-collapse: separate;
        border-spacing: 0 12px;
        margin-bottom: 30px;
    }

    table tr {
        background: #f7f9fc;
        border-radius: 10px;
        box-shadow: 0 3px 8px rgba(44, 123, 229, 0.1);
    }

    table td {
        padding: 15px 20px;
        font-size: 1rem;
        color: #334e68;
        vertical-align: middle;
    }

    table td:first-child {
        font-weight: 600;
        color: #102a43;
        width: 50%;
        text-align: left;
        border-radius: 10px 0 0 10px;
    }

    table td:last-child {
        text-align: right;
        border-radius: 0 10px 10px 0;
    }

    input[type="submit"], a.button {
        display: inline-block;
        padding: 12px 28px;
        font-weight: 700;
        font-size: 1rem;
        border-radius: 30px;
        border: none;
        cursor: pointer;
        text-decoration: none;
        transition: background-color 0.3s ease;
        user-select: none;
    }

    input[type="submit"] {
        background-color: #2c7be5;
        color: white;
        margin-right: 15px;
    }

    input[type="submit"]:hover {
        background-color: #1a5bb8;
    }

    a.button {
        background-color: #f66a0a;
        color: white;
    }

    a.button:hover {
        background-color: #b15308;
    }

    @media (max-width: 480px) {
        .container {
            padding: 25px 20px;
        }
        table td {
            padding: 12px 10px;
            font-size: 0.95rem;
        }
        input[type="submit"], a.button {
            padding: 10px 20px;
            font-size: 0.95rem;
        }
    }
</style>
</head>
<body>
    <%
        CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
        ProductBean pb = (ProductBean) request.getAttribute("pb");
        Float totalAmount = (Float) request.getAttribute("totAmt");
        int reqQty = (int) request.getAttribute("reqqty");
    %>

    <div class="container">
        <h1>Product Bill</h1>
        <form action="payment" method="get">
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
                    <td>Required Quantity:</td>
                    <td><%= reqQty %></td>
                </tr>
                <tr>
                    <td>Total Billing Amount:</td>
                    <td>₹ <%= totalAmount %></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align:center; padding-top: 25px;">
                        <input type="hidden" name="reqqty" value="<%= reqQty %>" />
                        <input type="hidden" name="pcode" value="<%= pb.getCode() %>" />
                        <input type="submit" value="Proceed to Payment" />
                        <a href="viewCproduct" class="button">Back</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
