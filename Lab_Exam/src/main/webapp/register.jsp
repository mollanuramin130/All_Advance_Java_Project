<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Register - SSN Portal</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet" />

    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet" />

    <!-- Font Awesome for Navbar Icons -->
    <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
        crossorigin="anonymous"
        referrerpolicy="no-referrer"
    />

    <style>
        body {
            font-family: 'Montserrat', sans-serif;
            background: linear-gradient(135deg, #667eea, #764ba2);
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }
        .register-wrapper {
            flex-grow: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 2rem;
        }
        .register-card {
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
            padding: 2.5rem 3rem;
            max-width: 480px;
            width: 100%;
        }
        .register-card h3 {
            font-weight: 600;
            margin-bottom: 1.8rem;
            color: #4a4a4a;
            text-align: center;
        }
        .form-label {
            font-weight: 600;
            color: #4a4a4a;
        }
        .form-control {
            border-radius: 6px;
            border: 1.5px solid #ddd;
            transition: border-color 0.3s ease;
        }
        .form-control:focus {
            border-color: #667eea;
            box-shadow: 0 0 8px rgba(102, 126, 234, 0.5);
        }
        .btn-primary {
            background: #667eea;
            border: none;
            font-weight: 600;
            padding: 0.6rem 1.2rem;
            border-radius: 6px;
            transition: background 0.3s ease;
        }
        .btn-primary:hover {
            background: #5a6fdb;
        }
        .btn-secondary {
            border-radius: 6px;
        }
        .form-check-label {
            color: #555;
            font-weight: 500;
        }
        #passwordHelp {
            font-size: 0.9rem;
            margin-top: 0.3rem;
        }
        @media (max-width: 576px) {
            .register-card {
                padding: 2rem 1.5rem;
            }
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <jsp:include page="navbar.jsp" />

    <div class="register-wrapper">
        <div class="register-card shadow-sm">
            <h3><i class="bi bi-person-plus-fill me-2"></i>Create Your Account</h3>
            <form action="./rs" method="post" novalidate>
                <div class="mb-3">
                    <label for="fullname" class="form-label"><i class="bi bi-person-fill me-1"></i>Full Name</label>
                    <input
                        type="text"
                        id="fullname"
                        name="fullname"
                        class="form-control"
                        placeholder="John Doe"
                        required
                    />
                </div>
                <div class="mb-3">
                    <label for="username" class="form-label"><i class="bi bi-person-circle me-1"></i>Username</label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        class="form-control"
                        placeholder="john123"
                        required
                    />
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label"><i class="bi bi-envelope-fill me-1"></i>Email</label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        class="form-control"
                        placeholder="example@email.com"
                        required
                    />
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label"><i class="bi bi-lock-fill me-1"></i>Password</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        class="form-control"
                        placeholder="••••••••"
                        required
                    />
                </div>
                <div class="mb-3">
                    <label for="confirmpassword" class="form-label"><i class="bi bi-lock me-1"></i>Confirm Password</label>
                    <input
                        type="password"
                        id="confirmpassword"
                        name="confirmpassword"
                        class="form-control"
                        placeholder="••••••••"
                        required
                    />
                    <small id="passwordHelp" class="form-text"></small>
                </div>

                <div class="mb-3">
                    <label class="form-label d-block"><i class="bi bi-gender-ambiguous me-1"></i>Gender</label>
                    <div class="form-check form-check-inline">
                        <input
                            class="form-check-input"
                            type="radio"
                            name="gender"
                            id="genderMale"
                            value="Male"
                            required
                        />
                        <label class="form-check-label" for="genderMale">Male</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input
                            class="form-check-input"
                            type="radio"
                            name="gender"
                            id="genderFemale"
                            value="Female"
                        />
                        <label class="form-check-label" for="genderFemale">Female</label>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="dob" class="form-label"><i class="bi bi-calendar-date me-1"></i>Date of Birth</label>
                    <input type="date" id="dob" name="dob" class="form-control" required />
                </div>

                <div class="mb-3">
                    <label for="mobile" class="form-label"><i class="bi bi-phone-fill me-1"></i>Mobile</label>
                    <input
                        type="tel"
                        id="mobile"
                        name="mobile"
                        pattern="[0-9]{10}"
                        class="form-control"
                        placeholder="10-digit number"
                        required
                    />
                </div>

                <div class="mb-3">
                    <label for="address" class="form-label"><i class="bi bi-geo-alt-fill me-1"></i>Address</label>
                    <textarea
                        id="address"
                        name="address"
                        rows="3"
                        class="form-control"
                        placeholder="Enter full address"
                        required
                    ></textarea>
                </div>

                <div class="d-grid gap-2 mt-4">
                    <button type="submit" class="btn btn-primary btn-lg">Register</button>
                    <button type="reset" class="btn btn-outline-secondary btn-lg">Clear</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Bootstrap Bundle JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Password Match Validation -->
    <script>
        const pwd = document.getElementById('password');
        const cpwd = document.getElementById('confirmpassword');
        const message = document.getElementById('passwordHelp');

        function checkPasswords() {
            if (cpwd.value.length === 0) {
                message.textContent = '';
                return;
            }
            if (pwd.value === cpwd.value) {
                message.textContent = '✅ Passwords match!';
                message.style.color = '#28a745';
            } else {
                message.textContent = '❌ Passwords do not match!';
                message.style.color = '#dc3545';
            }
        }

        pwd.addEventListener('input', checkPasswords);
        cpwd.addEventListener('input', checkPasswords);

        document.querySelector('form').addEventListener('submit', function (e) {
            if (pwd.value !== cpwd.value) {
                e.preventDefault();
                alert('Passwords do not match!');
            }
        });
    </script>

</body>
</html>
