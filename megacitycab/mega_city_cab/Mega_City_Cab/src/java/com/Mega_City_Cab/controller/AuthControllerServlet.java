package com.Mega_City_Cab.controller;

import com.Mega_City_Cab.model.User;
import com.Mega_City_Cab.service.CusRegService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/auth")
public class AuthControllerServlet extends HttpServlet {
    private final CusRegService cusRegService = new CusRegService(); // Fixed naming convention

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("name");

        if ("Signup".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            User user = new User(0, username, password, email);
            if (cusRegService.registerUser(user)) {
                response.sendRedirect("Login.jsp?message=Registration successful");
            } else {
                response.sendRedirect("Signup.jsp?error=Registration failed");
            }
        } 
        else if ("Login".equals(action)) { 
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = cusRegService.validateLogin(username, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("dashboard.jsp");
            } else {
                response.sendRedirect("Login.jsp?error=Invalid credentials");
            }
        }
    }
}
