package com.Mega_City_Cab.dao;

import com.Mega_City_Cab.model.Booking;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mega_city_cab";
    private static final String USER = "root"; // Change this according to your database credentials
    private static final String PASSWORD = "password"; // Change this according to your database credentials

    // Get database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Add booking to database
    public void addBooking(Booking booking) {
        String query = "INSERT INTO bookings (order_number, customer_name, address, telephone, destination) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, booking.getOrderNumber());
            stmt.setString(2, booking.getCustomerName());
            stmt.setString(3, booking.getAddress());
            stmt.setString(4, booking.getTelephone());
            stmt.setString(5, booking.getDestination());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all bookings from database
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings";
        
        try (Connection conn = getConnection(); 
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setOrderNumber(rs.getString("order_number"));
                booking.setCustomerName(rs.getString("customer_name"));
                booking.setAddress(rs.getString("address"));
                booking.setTelephone(rs.getString("telephone"));
                booking.setDestination(rs.getString("destination"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    // Get a specific booking by order number
    public Booking getBookingByOrderNumber(String orderNumber) {
        String query = "SELECT * FROM bookings WHERE order_number = ?";
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, orderNumber);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Booking booking = new Booking();
                booking.setOrderNumber(rs.getString("order_number"));
                booking.setCustomerName(rs.getString("customer_name"));
                booking.setAddress(rs.getString("address"));
                booking.setTelephone(rs.getString("telephone"));
                booking.setDestination(rs.getString("destination"));
                return booking;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
