<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - SSN Market</title>
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <style>
        body {
            background: #f0f2f5;
        }
        .login-box {
            max-width: 400px;
            margin: 60px auto;
            padding: 30px;
            background: white;
            border-radius: 12px;
            box-shadow: 0 0 10px rgba(0,0,0,0.15);
        }
        .login-box h2 {
            text-align: center;
            margin-bottom: 25px;
            font-weight: bold;
            color: #0d6efd;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="login-box">
     <% String errorMsg = (String) request.getAttribute("errorMsg");
           if (errorMsg != null) { %>
            <div class="alert alert-danger text-center" role="alert">
                <%= errorMsg %>
            </div>
        <% } %>
        <h2><i class="fas fa-sign-in-alt"></i> Login</h2>
        <form action="./LoginServlet" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Username or Email</label>
                <input type="text" class="form-control" id="username" name="username" required placeholder="Enter username or email">
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" required placeholder="Enter password">
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-primary"><i class="fas fa-lock"></i> Login</button>
            </div>
        </form>
        <p class="text-center mt-3">Don't have an account? <a href="register.jsp">Register</a></p>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
