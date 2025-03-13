package com.Mega_City_Cab.dao;

import com.Mega_City_Cab.model.Payment;
import java.sql.*;

public class PaymentDAO {
    private Connection connection;

    public PaymentDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addPayment(Payment payment) {
        String query = "INSERT INTO payments (booking_id, customerName, amount, paymentMethod) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, payment.getBookingId());
            stmt.setString(2, payment.getCustomerName());
            stmt.setBigDecimal(3, payment.getAmount());
            stmt.setString(4, payment.getPaymentMethod());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
