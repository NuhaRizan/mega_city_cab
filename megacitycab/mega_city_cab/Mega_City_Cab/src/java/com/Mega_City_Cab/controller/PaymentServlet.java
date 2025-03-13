package com.Mega_City_Cab.controller;

import com.Mega_City_Cab.dao.PaymentDAO;
import com.Mega_City_Cab.model.Payment;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get data from the form
        String bookingId = request.getParameter("bookingId");
        String customerName = request.getParameter("customerName");
        String amount = request.getParameter("amount");
        String paymentMethod = request.getParameter("paymentMethod");

        // Create a Payment object
        Payment payment = new Payment();
        payment.setBookingId(Integer.parseInt(bookingId));
        payment.setCustomerName(customerName);
        payment.setAmount(new java.math.BigDecimal(amount));
        payment.setPaymentMethod(paymentMethod);

        // Get the database connection from servlet context
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        PaymentDAO paymentDAO = new PaymentDAO(connection);

        // Add payment to the database
        boolean isPaymentSuccessful = paymentDAO.addPayment(payment);

        // Redirect to the appropriate page based on success or failure
        if (isPaymentSuccessful) {
            response.sendRedirect("paymentSuccess.jsp");
        } else {
            response.sendRedirect("paymentFailure.jsp");
        }
    }
}
