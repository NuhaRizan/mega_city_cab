package com.Mega_City_Cab.controller;

import com.Mega_City_Cab.dao.BookingDAO;
import com.Mega_City_Cab.model.Booking;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BookingController extends HttpServlet {

    private BookingDAO bookingDAO;

    public void init() {
        bookingDAO = new BookingDAO();
    }

    // Handle POST requests (adding new booking)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get booking details from the form
        String orderNumber = request.getParameter("orderNumber");
        String customerName = request.getParameter("customerName");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String destination = request.getParameter("destination");

        // Create new booking object
        Booking booking = new Booking();
        booking.setOrderNumber(orderNumber);
        booking.setCustomerName(customerName);
        booking.setAddress(address);
        booking.setTelephone(telephone);
        booking.setDestination(destination);

        // Add booking to the database
        bookingDAO.addBooking(booking);

        // Redirect to the dashboard or view bookings page
        response.sendRedirect("dashboard.jsp");
    }

    // Handle GET requests (view all bookings)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Booking> bookings = bookingDAO.getAllBookings();
        request.setAttribute("bookings", bookings);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewBookings.jsp");
        dispatcher.forward(request, response);
    }
}
