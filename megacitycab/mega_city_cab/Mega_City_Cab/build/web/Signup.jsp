
<%-- 
    Document   : user
    Created on : Mar 9, 2025, 12:31:22 PM
    Author     : Nuha Rizan
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up - Mega City Cab</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
        }
        .container {
            width: 40%;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px gray;
            margin-top: 50px;
        }
        input, button {
            padding: 10px;
            margin: 5px;
            width: 90%;
        }
        button {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Sign Up</h2>
        <form method="post" action="AuthControllerServlet" name="Signup">
            <input type="text" name="username" placeholder="Username" required><br>
            <input type="email" name="email" placeholder="Email" required><br>
            <input type="password" name="password" placeholder="Password" required><br>
            <button type="submit">Register</button>
        </form>

        <p>Already have an account? <a href="Login.jsp">Login here</a></p>

        <%-- Display success/error messages --%>
        <%
            String message = request.getParameter("message");
            if (message != null) {
                out.println("<p style='color:red;'>" + message + "</p>");
            }
        %>
    </div>

</body>
</html>