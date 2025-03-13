package test;

import com.Mega_City_Cab.dao.BookingDAO;
import com.Mega_City_Cab.model.Booking;
import com.Mega_City_Cab.utils.DBConnection;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.*;

public class BookingDAOTest {
    private static Connection connection;
    private BookingDAO bookingDAO;

    @BeforeAll
    public static void setupDatabase() throws SQLException {
        connection = DBConnection.getConnection();
        String createTable = "CREATE TABLE IF NOT EXISTS booking (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "customer_id INT, " +
                "pickup_location VARCHAR(255), " +
                "dropoff_location VARCHAR(255), " +
                "booking_time TIMESTAMP, " +
                "status VARCHAR(50), " +
                "FOREIGN KEY (customer_id) REFERENCES users(id))";

        try (PreparedStatement stmt = connection.prepareStatement(createTable)) {
            stmt.execute();
        }
    }

    @BeforeEach
    public void setup() {
        bookingDAO = new BookingDAO();
    }

    @Test
    public void testAddBooking() {
        Booking booking = new Booking(0, 1, "Colombo", "Kandy", Timestamp.valueOf(LocalDateTime.now()), "Pending");
        assertTrue(bookingDAO.addBooking(booking), "Booking should be successfully added");
    }

    @Test
    public void testGetBookingById() {
        Booking booking = bookingDAO.getBookingById(1);
        assertNotNull(booking, "Booking should be found");
        assertEquals("Colombo", booking.getPickupLocation(), "Pickup location should match");
    }

    @Test
    public void testUpdateBookingStatus() {
        assertTrue(bookingDAO.updateBookingStatus(1, "Completed"), "Booking status should be updated");
        Booking updatedBooking = bookingDAO.getBookingById(1);
        assertEquals("Completed", updatedBooking.getStatus(), "Booking status should be updated");
    }

    @AfterAll
    public static void cleanupDatabase() throws SQLException {
        String dropTable = "DROP TABLE IF EXISTS booking";
        try (PreparedStatement stmt = connection.prepareStatement(dropTable)) {
            stmt.execute();
        }
        connection.close();
    }
}
